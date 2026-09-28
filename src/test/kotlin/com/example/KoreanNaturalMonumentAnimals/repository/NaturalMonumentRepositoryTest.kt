package com.example.KoreanNaturalMonumentAnimals.repository

import com.example.KoreanNaturalMonumentAnimals.Fixtures.animal
import com.example.KoreanNaturalMonumentAnimals.Fixtures.place
import com.example.KoreanNaturalMonumentAnimals.domain.AnimalCategory
import com.example.KoreanNaturalMonumentAnimals.domain.HeritageField
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Runs the real JPQL filter/search query against H2 with a small fixture set.
 * data.sql is switched off so the tests only see the rows they insert.
 */
@DataJpaTest(properties = ["spring.sql.init.mode=never"])
class NaturalMonumentRepositoryTest(@Autowired val repository: NaturalMonumentRepository) {

	private val animalFields = listOf(HeritageField.WILD_ANIMAL, HeritageField.LIVESTOCK)
	private var hwangsaeId = 0L

	@BeforeEach
	fun setUp() {
		val hwangsae = repository.save(animal("황새", AnimalCategory.BIRD))
		repository.save(animal("황쏘가리", AnimalCategory.FISH, name = "한강의 황쏘가리"))
		repository.save(animal("먹황새", AnimalCategory.BIRD))
		repository.save(animal("수달", AnimalCategory.MAMMAL))
		repository.save(animal("진도개", AnimalCategory.MAMMAL, name = "진도의 진도개", field = HeritageField.LIVESTOCK))
		repository.save(place("황새 번식지", HeritageField.BREEDING_GROUND, relatedAnimals = listOf(hwangsae)))
		hwangsaeId = requireNotNull(hwangsae.id)
	}

	private fun search(category: AnimalCategory?, keyword: String?) =
		repository.searchAnimals(animalFields, category, keyword).map { it.speciesName }

	@Test
	fun `without conditions returns every animal in insertion order and no places`() {
		assertEquals(listOf("황새", "황쏘가리", "먹황새", "수달", "진도개"), search(null, null))
	}

	@Test
	fun `filters by category`() {
		assertEquals(listOf("수달", "진도개"), search(AnimalCategory.MAMMAL, null))
	}

	@Test
	fun `searches a part of the species name`() {
		assertEquals(listOf("황새", "황쏘가리", "먹황새"), search(null, "황"))
	}

	@Test
	fun `combines category and keyword`() {
		assertEquals(listOf("황새", "먹황새"), search(AnimalCategory.BIRD, "황"))
	}

	@Test
	fun `searches the species name only, not the official name`() {
		// "한강" appears only in the official name "한강의 황쏘가리"
		assertTrue(search(null, "한강").isEmpty())
	}

	@Test
	fun `returns nothing when nothing matches`() {
		assertTrue(search(AnimalCategory.CORAL, "황").isEmpty())
		assertTrue(search(null, "호랑이").isEmpty())
	}

	@Test
	fun `finds the places designated for an animal`() {
		val places = repository.findByRelatedAnimalsIdOrderByIdAsc(hwangsaeId)

		assertEquals(listOf("황새 번식지"), places.map { it.name })
	}
}
