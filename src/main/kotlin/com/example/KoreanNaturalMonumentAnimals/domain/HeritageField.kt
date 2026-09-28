package com.example.KoreanNaturalMonumentAnimals.domain

/**
 * 분야 (the spreadsheet's "분야" column).
 * [isAnimal] is true when the monument is an animal itself, not a place.
 */
enum class HeritageField(val displayName: String, val isAnimal: Boolean) {
	WILD_ANIMAL("야생동물", true),
	LIVESTOCK("축양동물", true),
	HABITAT("서식지", false),
	BREEDING_GROUND("번식지", false),
	MIGRATION_SITE("도래지", false),
}
