package com.example.KoreanNaturalMonumentAnimals

import com.example.KoreanNaturalMonumentAnimals.domain.AnimalCategory
import com.example.KoreanNaturalMonumentAnimals.domain.HeritageField
import com.example.KoreanNaturalMonumentAnimals.domain.NaturalMonument
import java.time.LocalDate

/** Small builders for test data, so each test only spells out the fields it cares about. */
object Fixtures {

	fun animal(
		speciesName: String,
		category: AnimalCategory = AnimalCategory.BIRD,
		name: String = speciesName,
		field: HeritageField = HeritageField.WILD_ANIMAL,
		region: String? = null,
		scientificName: String? = null,
		imageUrl: String? = null,
		imageAuthor: String? = null,
		imageLicense: String? = null,
		id: Long? = null,
	) = NaturalMonument(
		name = name,
		speciesName = speciesName,
		category = category,
		designatedDate = LocalDate.of(1968, 5, 31),
		heritageField = field,
		region = region,
		scientificName = scientificName,
		imageUrl = imageUrl,
		imageAuthor = imageAuthor,
		imageLicense = imageLicense,
		imageLicenseUrl = imageLicense?.let { "https://creativecommons.org/licenses/by/4.0/" },
		imageSourceUrl = imageAuthor?.let { "https://www.inaturalist.org/observations/1" },
		id = id,
	)

	fun place(
		name: String,
		field: HeritageField = HeritageField.HABITAT,
		region: String? = "경기도",
		relatedAnimals: Collection<NaturalMonument> = emptyList(),
		id: Long? = null,
	) = NaturalMonument(
		name = name,
		designatedDate = LocalDate.of(1962, 12, 7),
		heritageField = field,
		region = region,
		relatedAnimals = relatedAnimals.toMutableSet(),
		id = id,
	)
}
