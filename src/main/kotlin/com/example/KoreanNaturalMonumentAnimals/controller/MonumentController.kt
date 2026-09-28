package com.example.KoreanNaturalMonumentAnimals.controller

import com.example.KoreanNaturalMonumentAnimals.domain.AnimalCategory
import com.example.KoreanNaturalMonumentAnimals.service.NaturalMonumentService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/monuments")
class MonumentController(
	private val naturalMonumentService: NaturalMonumentService,
) {

	/** e.g. /monuments?category=BIRD&q=황 — both parameters are optional and can be combined. */
	@GetMapping
	fun list(
		@RequestParam category: AnimalCategory?,
		@RequestParam q: String?,
		model: Model,
	): String {
		model.addAttribute("result", naturalMonumentService.searchAnimals(category, q))
		return "monuments/list"
	}

	@GetMapping("/{id}")
	fun detail(@PathVariable id: Long, model: Model): String {
		model.addAttribute("monument", naturalMonumentService.getAnimalDetail(id))
		return "monuments/detail"
	}
}
