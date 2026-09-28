package com.example.KoreanNaturalMonumentAnimals.service

import com.example.KoreanNaturalMonumentAnimals.domain.AnimalCategory

/** The list page: matching animals plus the conditions that produced them. */
data class AnimalSearchResultDto(
	val animals: List<MonumentSummaryDto>,
	/** null means "전체". */
	val selectedCategory: AnimalCategory?,
	/** Trimmed search keyword; null when there is none. */
	val q: String?,
	val categories: List<AnimalCategory> = AnimalCategory.entries,
)
