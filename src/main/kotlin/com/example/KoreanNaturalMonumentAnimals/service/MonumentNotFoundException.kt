package com.example.KoreanNaturalMonumentAnimals.service

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/** Rendered as the 404 page (templates/error/404.html). */
@ResponseStatus(HttpStatus.NOT_FOUND)
class MonumentNotFoundException(id: Long) : RuntimeException("천연기념물 동물을 찾을 수 없습니다: id=$id")
