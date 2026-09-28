package com.example.KoreanNaturalMonumentAnimals.service

import com.example.KoreanNaturalMonumentAnimals.Fixtures.animal
import com.example.KoreanNaturalMonumentAnimals.Fixtures.place
import com.example.KoreanNaturalMonumentAnimals.domain.AnimalCategory
import com.example.KoreanNaturalMonumentAnimals.domain.HeritageField
import com.example.KoreanNaturalMonumentAnimals.repository.NaturalMonumentRepository
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import java.util.Optional
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

/** Unit tests: the repository is a Mockito mock, so only the service's own logic runs. */
class NaturalMonumentServiceTest {

	private val repository: NaturalMonumentRepository = mock(NaturalMonumentRepository::class.java)
	private val service = NaturalMonumentService(repository)
	private val animalFields = listOf(HeritageField.WILD_ANIMAL, HeritageField.LIVESTOCK)

	private val hwangsae = animal("황새", id = 13)
	private val mukHwangsae = animal("먹황새", id = 14)

	@Nested
	inner class SearchAnimals {

		@Test
		fun `passes category and keyword to the repository`() {
			given(repository.searchAnimals(animalFields, AnimalCategory.BIRD, "황"))
				.willReturn(listOf(hwangsae, mukHwangsae))

			val result = service.searchAnimals(AnimalCategory.BIRD, "황")

			assertEquals(listOf("황새", "먹황새"), result.animals.map { it.speciesName })
			assertEquals(AnimalCategory.BIRD, result.selectedCategory)
			assertEquals("황", result.q)
		}

		@Test
		fun `trims the keyword`() {
			given(repository.searchAnimals(animalFields, null, "황")).willReturn(listOf(hwangsae))

			val result = service.searchAnimals(null, "  황 ")

			assertEquals("황", result.q)
			verify(repository).searchAnimals(animalFields, null, "황")
		}

		@Test
		fun `blank keyword means no keyword condition`() {
			given(repository.searchAnimals(animalFields, null, null)).willReturn(listOf(hwangsae))

			val result = service.searchAnimals(null, "   ")

			assertNull(result.q)
			verify(repository).searchAnimals(animalFields, null, null)
		}

		@Test
		fun `null category means all categories`() {
			given(repository.searchAnimals(animalFields, null, null)).willReturn(emptyList())

			val result = service.searchAnimals(null, null)

			assertNull(result.selectedCategory)
			assertEquals(AnimalCategory.entries, result.categories)
		}

		@Test
		fun `always searches only animal fields, never places`() {
			given(repository.searchAnimals(animalFields, null, null)).willReturn(emptyList())

			service.searchAnimals(null, null)

			verify(repository).searchAnimals(animalFields, null, null)
		}

		@Test
		fun `no match gives an empty list`() {
			given(repository.searchAnimals(animalFields, null, "호랑이")).willReturn(emptyList())

			assertTrue(service.searchAnimals(null, "호랑이").animals.isEmpty())
		}
	}

	@Nested
	inner class SummaryMapping {

		@Test
		fun `uses the species name, not the official name`() {
			val jindo = animal("진도개", AnimalCategory.MAMMAL, name = "진도의 진도개", id = 4)
			given(repository.searchAnimals(animalFields, null, null)).willReturn(listOf(jindo))

			val card = service.searchAnimals(null, null).animals.single()

			assertEquals("진도개", card.speciesName)
			assertEquals("MAMMAL", card.categoryCode)
			assertEquals("포유류", card.categoryName)
			assertEquals("1968.05.31", card.designatedDate)
		}

		@Test
		fun `falls back to the placeholder image and no credit when there is no photo`() {
			given(repository.searchAnimals(animalFields, null, null)).willReturn(listOf(hwangsae))

			val card = service.searchAnimals(null, null).animals.single()

			assertEquals(MonumentSummaryDto.PLACEHOLDER_IMAGE, card.imageUrl)
			assertNull(card.photoCredit)
		}

		@Test
		fun `carries the photo and its credit`() {
			val otter = animal(
				"수달", AnimalCategory.MAMMAL, scientificName = "Lutra lutra",
				imageUrl = "/images/animals/68.jpg", imageAuthor = "Jane Doe", imageLicense = "CC BY 4.0", id = 68,
			)
			given(repository.searchAnimals(animalFields, null, null)).willReturn(listOf(otter))

			val card = service.searchAnimals(null, null).animals.single()

			assertEquals("/images/animals/68.jpg", card.imageUrl)
			assertEquals("Lutra lutra", card.scientificName)
			assertEquals("Jane Doe", card.photoCredit?.author)
			assertEquals("CC BY 4.0", card.photoCredit?.license)
		}
	}

	@Nested
	inner class RandomAnimal {

		@Test
		fun `returns one of the animals`() {
			given(repository.findByHeritageFieldInOrderByIdAsc(animalFields)).willReturn(listOf(hwangsae, mukHwangsae))

			val picked = assertNotNull(service.findRandomAnimal())

			assertTrue(picked.speciesName in listOf("황새", "먹황새"))
		}

		@Test
		fun `prefers animals that have a photo`() {
			val otter = animal("수달", imageUrl = "/images/animals/68.jpg", imageAuthor = "Jane Doe", imageLicense = "CC BY 4.0", id = 68)
			given(repository.findByHeritageFieldInOrderByIdAsc(animalFields)).willReturn(listOf(hwangsae, otter, mukHwangsae))

			repeat(20) {
				assertEquals("수달", service.findRandomAnimal()?.speciesName)
			}
		}

		@Test
		fun `returns null when there are no animals`() {
			given(repository.findByHeritageFieldInOrderByIdAsc(animalFields)).willReturn(emptyList())

			assertNull(service.findRandomAnimal())
		}
	}

	@Nested
	inner class AnimalDetail {

		@Test
		fun `returns the animal with its related places`() {
			val knaksae = animal("크낙새", scientificName = "Dryocopus javensis", id = 11)
			val gwangneung = place("광릉 크낙새 서식지", region = "경기도", id = 1)
			given(repository.findById(11)).willReturn(Optional.of(knaksae))
			given(repository.findByRelatedAnimalsIdOrderByIdAsc(11)).willReturn(listOf(gwangneung))

			val detail = service.getAnimalDetail(11)

			assertEquals("크낙새", detail.speciesName)
			assertEquals("Dryocopus javensis", detail.scientificName)
			assertEquals(listOf("광릉 크낙새 서식지"), detail.relatedPlaces.map { it.name })
			assertEquals("서식지", detail.relatedPlaces.single().fieldName)
		}

		@Test
		fun `keeps the official name next to the species name`() {
			val jindo = animal("진도개", AnimalCategory.MAMMAL, name = "진도의 진도개", field = HeritageField.LIVESTOCK, region = "전라남도", id = 4)
			given(repository.findById(4)).willReturn(Optional.of(jindo))
			given(repository.findByRelatedAnimalsIdOrderByIdAsc(4)).willReturn(emptyList())

			val detail = service.getAnimalDetail(4)

			assertEquals("진도의 진도개", detail.officialName)
			assertEquals("축양동물", detail.fieldName)
			assertEquals("전라남도", detail.region)
		}

		@Test
		fun `a place has no detail page`() {
			given(repository.findById(1)).willReturn(Optional.of(place("광릉 크낙새 서식지", id = 1)))

			assertThrows<MonumentNotFoundException> { service.getAnimalDetail(1) }
		}

		@Test
		fun `a missing id is not found`() {
			given(repository.findById(9999)).willReturn(Optional.empty())

			assertThrows<MonumentNotFoundException> { service.getAnimalDetail(9999) }
		}
	}

	@Test
	fun `photo credits list only animals that have a photo`() {
		val withPhoto = animal("수달", imageUrl = "/images/animals/68.jpg", imageAuthor = "Jane Doe", imageLicense = "CC BY 4.0", id = 68)
		given(repository.findByHeritageFieldInOrderByIdAsc(animalFields)).willReturn(listOf(hwangsae, withPhoto))

		assertEquals(listOf("수달"), service.findAnimalsWithPhotoCredit().map { it.speciesName })
	}
}
