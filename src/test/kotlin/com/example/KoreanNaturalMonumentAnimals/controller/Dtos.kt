package com.example.KoreanNaturalMonumentAnimals.controller

import com.example.KoreanNaturalMonumentAnimals.domain.AnimalCategory
import com.example.KoreanNaturalMonumentAnimals.service.MonumentDetailDto
import com.example.KoreanNaturalMonumentAnimals.service.MonumentSummaryDto
import com.example.KoreanNaturalMonumentAnimals.service.PhotoCreditDto
import com.example.KoreanNaturalMonumentAnimals.service.RelatedPlaceDto

/** DTOs the mocked service returns in the web layer tests. */
object Dtos {

	val credit = PhotoCreditDto(
		author = "Jane Doe",
		license = "CC BY 4.0",
		licenseUrl = "https://creativecommons.org/licenses/by/4.0/",
		sourceUrl = "https://www.inaturalist.org/observations/1",
	)

	fun summary(
		id: Long,
		speciesName: String,
		category: AnimalCategory = AnimalCategory.BIRD,
		scientificName: String? = null,
		photoCredit: PhotoCreditDto? = null,
	) = MonumentSummaryDto(
		id = id,
		speciesName = speciesName,
		categoryCode = category.name,
		categoryName = category.displayName,
		fieldCode = "WILD_ANIMAL",
		fieldName = "야생동물",
		region = null,
		designatedDate = "1968.05.31",
		imageUrl = if (photoCredit != null) "/images/animals/$id.jpg" else MonumentSummaryDto.PLACEHOLDER_IMAGE,
		scientificName = scientificName,
		photoCredit = photoCredit,
	)

	fun detail(
		id: Long,
		speciesName: String,
		officialName: String = speciesName,
		scientificName: String? = null,
		region: String? = null,
		relatedPlaces: List<RelatedPlaceDto> = emptyList(),
		photoCredit: PhotoCreditDto? = null,
	) = MonumentDetailDto(
		id = id,
		speciesName = speciesName,
		officialName = officialName,
		categoryCode = "BIRD",
		categoryName = "조류",
		fieldCode = "WILD_ANIMAL",
		fieldName = "야생동물",
		region = region,
		designatedDate = "1968.05.31",
		scientificName = scientificName,
		description = null,
		imageUrl = MonumentSummaryDto.PLACEHOLDER_IMAGE,
		photoCredit = photoCredit,
		sourceUrl = null,
		relatedPlaces = relatedPlaces,
	)
}
