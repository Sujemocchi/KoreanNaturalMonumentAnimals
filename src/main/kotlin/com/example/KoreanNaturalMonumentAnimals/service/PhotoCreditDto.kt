package com.example.KoreanNaturalMonumentAnimals.service

import com.example.KoreanNaturalMonumentAnimals.domain.NaturalMonument

/** Attribution shown next to a photo, as the CC BY / CC BY-SA licenses require. */
data class PhotoCreditDto(
	val author: String,
	val license: String,
	val licenseUrl: String?,
	val sourceUrl: String?,
) {
	companion object {
		/** null when the monument has no photo (the placeholder needs no credit). */
		fun from(monument: NaturalMonument): PhotoCreditDto? {
			val author = monument.imageAuthor ?: return null
			val license = monument.imageLicense ?: return null
			return PhotoCreditDto(author, license, monument.imageLicenseUrl, monument.imageSourceUrl)
		}
	}
}
