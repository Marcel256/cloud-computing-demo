package com.servebeer.demo

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File

@RestController()
class BeerController {

    val beers: Array<BeerEntry>
    init {
        val beerDB = File("open-beer-database.json")
        val objectMapper = ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        beers = objectMapper.readValue(beerDB)
    }

    @GetMapping("/api/beer", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun loadBeer(): Beer? {
        return beers.random().fields
    }
}
