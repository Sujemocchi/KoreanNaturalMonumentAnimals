package com.example.KoreanNaturalMonumentAnimals.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import java.time.LocalDate

@Entity
class NaturalMonument(
	/** 국가유산명 (official name), e.g. "진도의 진도개", "광릉 크낙새 서식지". */
	@Column(nullable = false)
	val name: String,

	/** Species name without the place qualifier, e.g. "진도개". Set only for animals; null for places. */
	val speciesName: String? = null,

	/** 분류 (포유류·조류 …). Set only for animals; null for places. */
	@Enumerated(EnumType.STRING)
	val category: AnimalCategory? = null,

	@Column(nullable = false)
	val designatedDate: LocalDate,

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	val heritageField: HeritageField,

	/** 소재시도. null when the monument is designated as a species, not a specific place. */
	val region: String? = null,

	val scientificName: String? = null,

	@Column(length = 4000)
	val description: String? = null,

	/** Local path of a freely licensed photo, e.g. "/images/animals/4.jpg". null → placeholder. */
	val imageUrl: String? = null,

	/** Photo credit, required by the CC BY / CC BY-SA licenses. */
	val imageAuthor: String? = null,

	/** e.g. "CC BY 4.0", "CC0 1.0". */
	val imageLicense: String? = null,

	val imageLicenseUrl: String? = null,

	/** Page the photo was taken from (iNaturalist observation or Wikimedia Commons file). */
	val imageSourceUrl: String? = null,

	val sourceUrl: String? = null,

	/** For a place (서식지·번식지·도래지): the designated animals it is designated for. Empty for animals. */
	@ManyToMany
	@JoinTable(
		name = "monument_related_animal",
		joinColumns = [JoinColumn(name = "place_id")],
		inverseJoinColumns = [JoinColumn(name = "animal_id")],
	)
	val relatedAnimals: MutableSet<NaturalMonument> = mutableSetOf(),

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long? = null,
)
