package com.example.KoreanNaturalMonumentAnimals.service

import com.example.KoreanNaturalMonumentAnimals.domain.AnimalCategory
import com.example.KoreanNaturalMonumentAnimals.domain.HeritageField
import com.example.KoreanNaturalMonumentAnimals.repository.NaturalMonumentRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class NaturalMonumentService(
	private val naturalMonumentRepository: NaturalMonumentRepository,
) {

	private val animalFields = HeritageField.entries.filter { it.isAnimal }

	/**
	 * Animals (야생동물·축양동물) in the spreadsheet's order, filtered by [category] and by [q] in the species name.
	 * A null category or a blank q means "no condition". Places are never included.
	 */
	fun searchAnimals(category: AnimalCategory?, q: String?): AnimalSearchResultDto {
		val keyword = q?.trim()?.takeIf { it.isNotEmpty() }
		val animals = naturalMonumentRepository.searchAnimals(animalFields, category, keyword)
			.map { MonumentSummaryDto.from(it) }
		return AnimalSearchResultDto(animals, category, keyword)
	}

	/** Animals that have a photo, for the photo credits page. */
	fun findAnimalsWithPhotoCredit(): List<MonumentSummaryDto> =
		naturalMonumentRepository.findByHeritageFieldInOrderByIdAsc(animalFields)
			.map { MonumentSummaryDto.from(it) }
			.filter { it.photoCredit != null }

	/**
	 * One random animal for the home page, picked among those with a photo
	 * (falls back to any animal when none has a photo), or null if there is none.
	 */
	fun findRandomAnimal(): MonumentSummaryDto? {
		val animals = naturalMonumentRepository.findByHeritageFieldInOrderByIdAsc(animalFields)
		val withPhoto = animals.filter { it.imageUrl != null }
		return withPhoto.ifEmpty { animals }
			.randomOrNull()
			?.let { MonumentSummaryDto.from(it) }
	}

	/** Detail of one animal with the places designated for it. Places have no detail page. */
	fun getAnimalDetail(id: Long): MonumentDetailDto {
		val animal = naturalMonumentRepository.findByIdOrNull(id)
			?.takeIf { it.heritageField.isAnimal }
			?: throw MonumentNotFoundException(id)
		val relatedPlaces = naturalMonumentRepository.findByRelatedAnimalsIdOrderByIdAsc(id)
		return MonumentDetailDto.from(animal, relatedPlaces)
	}
}
