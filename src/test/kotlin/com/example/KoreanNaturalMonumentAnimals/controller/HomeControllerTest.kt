package com.example.KoreanNaturalMonumentAnimals.controller

import com.example.KoreanNaturalMonumentAnimals.controller.Dtos.credit
import com.example.KoreanNaturalMonumentAnimals.controller.Dtos.summary
import com.example.KoreanNaturalMonumentAnimals.domain.AnimalCategory
import com.example.KoreanNaturalMonumentAnimals.service.NaturalMonumentService
import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.not
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(HomeController::class)
class HomeControllerTest {

	@Autowired
	lateinit var mockMvc: MockMvc

	@MockitoBean
	lateinit var service: NaturalMonumentService

	@Test
	fun `home shows the random animal with its photo credit and a link to the list`() {
		given(service.findRandomAnimal()).willReturn(
			summary(68, "수달", AnimalCategory.MAMMAL, scientificName = "Lutra lutra", photoCredit = credit)
		)

		mockMvc.get("/").andExpect {
			status { isOk() }
			view { name("index") }
			content { string(containsString("href=\"/monuments/68\"")) }
			content { string(containsString("수달")) }
			content { string(containsString("Lutra lutra")) }
			content { string(containsString("src=\"/images/animals/68.jpg\"")) }
			content { string(containsString("Jane Doe")) }
			content { string(containsString("href=\"/monuments\"")) }
		}
	}

	@Test
	fun `home shows a message when there is no animal`() {
		given(service.findRandomAnimal()).willReturn(null)

		mockMvc.get("/").andExpect {
			status { isOk() }
			content { string(containsString("등록된 천연기념물 동물이 없습니다.")) }
			content { string(not(containsString("class=\"featured\" href"))) }
		}
	}

	@Test
	fun `credits page lists every photo with author and license`() {
		given(service.findAnimalsWithPhotoCredit()).willReturn(listOf(summary(68, "수달", photoCredit = credit)))

		mockMvc.get("/credits").andExpect {
			status { isOk() }
			view { name("credits") }
			content { string(containsString("수달")) }
			content { string(containsString("Jane Doe")) }
			content { string(containsString("https://creativecommons.org/licenses/by/4.0/")) }
			content { string(containsString("https://www.inaturalist.org/observations/1")) }
		}
	}
}
