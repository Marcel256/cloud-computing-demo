package com.servebeer.demo

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import org.springframework.boot.convert.ApplicationConversionService.configure
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.io.File

@RestController()
class BeerController {

    val beers: Array<BeerEntry>
    init {
        val beerDB = ClassPathResource("open-beer-database.json").file
        val objectMapper = ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        beers = objectMapper.readValue(beerDB)
    }

    @GetMapping("/api/beer", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun loadBeer(): Beer? {
        return beers.random().fields
    }
}
