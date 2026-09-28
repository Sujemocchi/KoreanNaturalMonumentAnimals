package com.example.KoreanNaturalMonumentAnimals.service

import com.example.KoreanNaturalMonumentAnimals.domain.NaturalMonument
import com.example.KoreanNaturalMonumentAnimals.service.MonumentSummaryDto.Companion.DATE_FORMAT
import com.example.KoreanNaturalMonumentAnimals.service.MonumentSummaryDto.Companion.PLACEHOLDER_IMAGE

/** The detail page of one animal. Nullable fields are shown as "준비 중" on the page. */
data class MonumentDetailDto(
	val id: Long,
	val speciesName: String,
	val officialName: String,
	val categoryCode: String,
	val categoryName: String,
	val fieldCode: String,
	val fieldName: String,
	val region: String?,
	val designatedDate: String,
	val scientificName: String?,
	val description: String?,
	val imageUrl: String,
	val photoCredit: PhotoCreditDto?,
	val sourceUrl: String?,
	val relatedPlaces: List<RelatedPlaceDto>,
) {
	companion object {
		fun from(monument: NaturalMonument, relatedPlaces: List<NaturalMonument>): MonumentDetailDto {
			val category = requireNotNull(monument.category) { "Animal without a category: ${monument.name}" }
			return MonumentDetailDto(
				id = requireNotNull(monument.id),
				speciesName = monument.speciesName ?: monument.name,
				officialName = monument.name,
				categoryCode = category.name,
				categoryName = category.displayName,
				fieldCode = monument.heritageField.name,
				fieldName = monument.heritageField.displayName,
				region = monument.region,
				designatedDate = monument.designatedDate.format(DATE_FORMAT),
				scientificName = monument.scientificName,
				description = monument.description,
				imageUrl = monument.imageUrl ?: PLACEHOLDER_IMAGE,
				photoCredit = PhotoCreditDto.from(monument),
				sourceUrl = monument.sourceUrl,
				relatedPlaces = relatedPlaces.map { RelatedPlaceDto.from(it) },
			)
		}
	}
}

/** A place (서식지·번식지·도래지) designated for the animal. */
data class RelatedPlaceDto(
	val name: String,
	val fieldCode: String,
	val fieldName: String,
	val region: String?,
	val designatedDate: String,
) {
	companion object {
		fun from(place: NaturalMonument) = RelatedPlaceDto(
			name = place.name,
			fieldCode = place.heritageField.name,
			fieldName = place.heritageField.displayName,
			region = place.region,
			designatedDate = place.designatedDate.format(DATE_FORMAT),
		)
	}
}
