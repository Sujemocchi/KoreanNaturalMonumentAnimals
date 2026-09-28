package com.example.KoreanNaturalMonumentAnimals

import com.example.KoreanNaturalMonumentAnimals.domain.HeritageField
import com.example.KoreanNaturalMonumentAnimals.repository.NaturalMonumentRepository
import com.example.KoreanNaturalMonumentAnimals.service.NaturalMonumentService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Whole application with the real data.sql: checks the seed data itself
 * and that every page works end to end.
 */
@SpringBootTest
@AutoConfigureMockMvc
class DataIntegrationTest(
	@Autowired val service: NaturalMonumentService,
	@Autowired val repository: NaturalMonumentRepository,
	@Autowired val mockMvc: MockMvc,
) {

	private val animals by lazy { service.searchAnimals(null, null).animals }

	private fun idOf(speciesName: String) = animals.first { it.speciesName == speciesName }.id

	@Test
	fun `seed data has all 102 monuments, 71 of them animals`() {
		assertEquals(102, repository.count())
		assertEquals(71, animals.size)
	}

	@Test
	fun `every animal has a category`() {
		assertEquals(
			mapOf("MAMMAL" to 13, "BIRD" to 47, "REPTILE" to 1, "FISH" to 4, "INSECT" to 4, "CORAL" to 2),
			animals.groupingBy { it.categoryCode }.eachCount(),
		)
	}

	@Test
	fun `species names carry no place qualifier`() {
		val names = animals.map { it.speciesName }

		assertTrue("진도개" in names)
		assertTrue("황쏘가리" in names)
		assertFalse(names.any { it.contains("서식지") || it.contains("의 ") }, "place qualifier left in $names")
	}

	@Test
	fun `places are linked to the animals they are designated for`() {
		val places = service.getAnimalDetail(idOf("저어새")).relatedPlaces.map { it.name }

		assertEquals(listOf("영광 칠산도 괭이갈매기·노랑부리백로·저어새 번식지", "강화 갯벌 및 저어새 번식지"), places)
	}

	@Test
	fun `places have no species data`() {
		val places = repository.findAll().filter { !it.heritageField.isAnimal }

		assertEquals(31, places.size)
		assertTrue(places.all { it.speciesName == null && it.category == null && it.imageUrl == null })
	}

	@Test
	fun `every animal except 반딧불이 has a scientific name`() {
		val missing = animals.filter { it.scientificName == null }.map { it.speciesName }

		assertEquals(listOf("반딧불이"), missing)
	}

	@Test
	fun `every photo has a credit and its file is served`() {
		val withPhoto = repository.findByHeritageFieldInOrderByIdAsc(HeritageField.entries.filter { it.isAnimal })
			.filter { it.imageUrl != null }

		assertTrue(withPhoto.isNotEmpty())
		withPhoto.forEach {
			assertTrue(it.imageAuthor != null && it.imageLicense != null && it.imageSourceUrl != null, "${it.name} has no credit")
			mockMvc.get(it.imageUrl!!).andExpect { status { isOk() } }
		}
	}

	@Test
	fun `pages work end to end`() {
		mockMvc.get("/").andExpect { status { isOk() } }
		mockMvc.get("/credits").andExpect { status { isOk() } }
		mockMvc.get("/monuments") {
			param("category", "BIRD")
			param("q", "황")
		}.andExpect { status { isOk() } }
		mockMvc.get("/monuments/${idOf("크낙새")}").andExpect { status { isOk() } }
		// id 1 is 광릉 크낙새 서식지, a place
		mockMvc.get("/monuments/1").andExpect { status { isNotFound() } }
	}
}
