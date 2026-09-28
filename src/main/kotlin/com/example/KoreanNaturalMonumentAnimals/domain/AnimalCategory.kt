package com.example.KoreanNaturalMonumentAnimals.domain

/** 분류: the biological class of an animal. Only classes that appear in the data are listed. */
enum class AnimalCategory(val displayName: String) {
	MAMMAL("포유류"),
	BIRD("조류"),
	REPTILE("파충류"),
	FISH("어류"),
	INSECT("곤충"),
	CORAL("산호"),
}
