package com.example.KoreanNaturalMonumentAnimals.controller

import com.example.KoreanNaturalMonumentAnimals.controller.Dtos.credit
import com.example.KoreanNaturalMonumentAnimals.controller.Dtos.detail
import com.example.KoreanNaturalMonumentAnimals.controller.Dtos.summary
import com.example.KoreanNaturalMonumentAnimals.domain.AnimalCategory
import com.example.KoreanNaturalMonumentAnimals.service.AnimalSearchResultDto
import com.example.KoreanNaturalMonumentAnimals.service.MonumentNotFoundException
import com.example.KoreanNaturalMonumentAnimals.service.NaturalMonumentService
import com.example.KoreanNaturalMonumentAnimals.service.RelatedPlaceDto
import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.not
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoInteractions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

/** Web layer only: the service is a mock, so these tests check routing, parameters and the rendered HTML. */
@WebMvcTest(MonumentController::class)
class MonumentControllerTest {

	@Autowired
	lateinit var mockMvc: MockMvc

	@MockitoBean
	lateinit var service: NaturalMonumentService

	@Nested
	inner class ListPage {

		@Test
		fun `shows every animal as a card linked to its detail page`() {
			given(service.searchAnimals(null, null)).willReturn(
				AnimalSearchResultDto(
					animals = listOf(summary(13, "황새", scientificName = "Ciconia boyciana"), summary(68, "수달", AnimalCategory.MAMMAL)),
					selectedCategory = null,
					q = null,
				)
			)

			mockMvc.get("/monuments").andExpect {
				status { isOk() }
				view { name("monuments/list") }
				content { string(containsString("2건")) }
				content { string(containsString("href=\"/monuments/13\"")) }
				content { string(containsString("href=\"/monuments/68\"")) }
				content { string(containsString("Ciconia boyciana")) }
				content { string(containsString("badge-MAMMAL")) }
				// the "전체" tab is active
				content { string(containsString("class=\"tab active\" href=\"/monuments\"")) }
			}
		}

		@Test
		fun `passes category and keyword to the service and keeps them on the page`() {
			given(service.searchAnimals(AnimalCategory.BIRD, "황")).willReturn(
				AnimalSearchResultDto(listOf(summary(13, "황새")), AnimalCategory.BIRD, "황")
			)

			mockMvc.get("/monuments") {
				param("category", "BIRD")
				param("q", "황")
			}.andExpect {
				status { isOk() }
				content { string(containsString("class=\"tab active\" href=\"/monuments?category=BIRD&amp;q=")) }
				content { string(containsString("value=\"황\"")) }
				content { string(containsString("name=\"category\" value=\"BIRD\"")) }
			}

			verify(service).searchAnimals(AnimalCategory.BIRD, "황")
		}

		@Test
		fun `shows a message when nothing matches`() {
			given(service.searchAnimals(null, "호랑이")).willReturn(AnimalSearchResultDto(emptyList(), null, "호랑이"))

			mockMvc.get("/monuments") { param("q", "호랑이") }.andExpect {
				status { isOk() }
				content { string(containsString("“호랑이”에 해당하는 천연기념물 동물이 없습니다.")) }
				content { string(not(containsString("class=\"card\""))) }
			}
		}

		@Test
		fun `shows a message for an empty category`() {
			given(service.searchAnimals(AnimalCategory.CORAL, null)).willReturn(AnimalSearchResultDto(emptyList(), AnimalCategory.CORAL, null))

			mockMvc.get("/monuments") { param("category", "CORAL") }.andExpect {
				status { isOk() }
				content { string(containsString("해당 분류의 천연기념물 동물이 없습니다.")) }
			}
		}

		@Test
		fun `unknown category is a bad request`() {
			mockMvc.get("/monuments") { param("category", "DRAGON") }.andExpect {
				status { isBadRequest() }
			}

			verifyNoInteractions(service)
		}
	}

	@Nested
	inner class DetailPage {

		@Test
		fun `shows the animal, its official name, related places and photo credit`() {
			given(service.getAnimalDetail(11)).willReturn(
				detail(
					11, "크낙새", scientificName = "Dryocopus javensis richardsi",
					relatedPlaces = listOf(RelatedPlaceDto("광릉 크낙새 서식지", "HABITAT", "서식지", "경기도", "1962.12.07")),
					photoCredit = credit,
				)
			)

			mockMvc.get("/monuments/11").andExpect {
				status { isOk() }
				view { name("monuments/detail") }
				content { string(containsString("<h1 class=\"detail-title\">크낙새</h1>")) }
				content { string(containsString("Dryocopus javensis richardsi")) }
				content { string(containsString("광릉 크낙새 서식지")) }
				content { string(containsString("경기도 · ")) }
				content { string(containsString("Jane Doe")) }
				content { string(containsString("CC BY 4.0")) }
			}
		}

		@Test
		fun `shows the official name when it differs from the species name`() {
			given(service.getAnimalDetail(4)).willReturn(detail(4, "진도개", officialName = "진도의 진도개", region = "전라남도"))

			mockMvc.get("/monuments/4").andExpect {
				status { isOk() }
				content { string(containsString("진도의 진도개")) }
				content { string(containsString("전라남도")) }
			}
		}

		@Test
		fun `shows placeholders for missing information`() {
			given(service.getAnimalDetail(46)).willReturn(detail(46, "반딧불이"))

			mockMvc.get("/monuments/46").andExpect {
				status { isOk() }
				content { string(containsString("특정 지역 없음 (종 자체가 지정됨)")) }
				content { string(containsString("정보 준비 중")) }
				content { string(containsString("소개 글 준비 중입니다.")) }
				content { string(not(containsString("관련 지정 장소"))) }
				content { string(not(containsString("class=\"photo-credit\""))) }
			}
		}

		@Test
		fun `missing animal is 404`() {
			given(service.getAnimalDetail(9999)).willThrow(MonumentNotFoundException(9999))

			mockMvc.get("/monuments/9999").andExpect {
				status { isNotFound() }
			}
		}

		@Test
		fun `non-numeric id is a bad request`() {
			mockMvc.get("/monuments/abc").andExpect {
				status { isBadRequest() }
			}
		}
	}
}
