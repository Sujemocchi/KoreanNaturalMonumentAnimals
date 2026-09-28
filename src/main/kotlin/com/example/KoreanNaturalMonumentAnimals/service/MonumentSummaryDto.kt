package com.example.KoreanNaturalMonumentAnimals.service

import com.example.KoreanNaturalMonumentAnimals.domain.NaturalMonument
import java.time.format.DateTimeFormatter

/** An animal card on the home and list pages. */
data class MonumentSummaryDto(
	val id: Long,
	val speciesName: String,
	val categoryCode: String,
	val categoryName: String,
	val fieldCode: String,
	val fieldName: String,
	val region: String?,
	val designatedDate: String,
	val imageUrl: String,
	val scientificName: String?,
	val photoCredit: PhotoCreditDto?,
) {
	companion object {
		const val PLACEHOLDER_IMAGE = "/images/placeholder.svg"
		val DATE_FORMAT: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")

		fun from(monument: NaturalMonument): MonumentSummaryDto {
			val category = requireNotNull(monument.category) { "Animal without a category: ${monument.name}" }
			return MonumentSummaryDto(
				id = requireNotNull(monument.id),
				speciesName = monument.speciesName ?: monument.name,
				categoryCode = category.name,
				categoryName = category.displayName,
				fieldCode = monument.heritageField.name,
				fieldName = monument.heritageField.displayName,
				region = monument.region,
				designatedDate = monument.designatedDate.format(DATE_FORMAT),
				imageUrl = monument.imageUrl ?: PLACEHOLDER_IMAGE,
				scientificName = monument.scientificName,
				photoCredit = PhotoCreditDto.from(monument),
			)
		}
	}
}
