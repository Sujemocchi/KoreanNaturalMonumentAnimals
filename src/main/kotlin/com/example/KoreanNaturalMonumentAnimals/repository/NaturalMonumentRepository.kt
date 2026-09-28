package com.example.KoreanNaturalMonumentAnimals.repository

import com.example.KoreanNaturalMonumentAnimals.domain.AnimalCategory
import com.example.KoreanNaturalMonumentAnimals.domain.HeritageField
import com.example.KoreanNaturalMonumentAnimals.domain.NaturalMonument
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface NaturalMonumentRepository : JpaRepository<NaturalMonument, Long> {

	fun findByHeritageFieldInOrderByIdAsc(fields: Collection<HeritageField>): List<NaturalMonument>

	/** Places (서식지·번식지·도래지) designated for the given animal. */
	fun findByRelatedAnimalsIdOrderByIdAsc(animalId: Long): List<NaturalMonument>

	/**
	 * Animals filtered by category and by a part of the species name.
	 * A null [category] or [keyword] means "no condition".
	 */
	@Query(
		"""
		select m from NaturalMonument m
		where m.heritageField in :fields
		  and (:category is null or m.category = :category)
		  and (:keyword is null or m.speciesName like concat('%', :keyword, '%'))
		order by m.id
		"""
	)
	fun searchAnimals(
		@Param("fields") fields: Collection<HeritageField>,
		@Param("category") category: AnimalCategory?,
		@Param("keyword") keyword: String?,
	): List<NaturalMonument>
}
