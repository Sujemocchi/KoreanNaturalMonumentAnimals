package com.example.KoreanNaturalMonumentAnimals.controller

import com.example.KoreanNaturalMonumentAnimals.service.NaturalMonumentService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController(
	private val naturalMonumentService: NaturalMonumentService,
) {

	@GetMapping("/")
	fun home(model: Model): String {
		model.addAttribute("featured", naturalMonumentService.findRandomAnimal())
		return "index"
	}

	/** Photo attributions, required by the CC BY / CC BY-SA licenses of the photos. */
	@GetMapping("/credits")
	fun credits(model: Model): String {
		model.addAttribute("animals", naturalMonumentService.findAnimalsWithPhotoCredit())
		return "credits"
	}
}
