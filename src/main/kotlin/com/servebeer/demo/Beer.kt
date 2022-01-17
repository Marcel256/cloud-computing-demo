package com.servebeer.demo

import com.fasterxml.jackson.annotation.JsonProperty


class Beer{
    var name: String? = null
    @JsonProperty("name_breweries")
    var brewery: String? = null
    var country: String? = null
    var descript: String? = null
}

class BeerEntry {
    var fields: Beer? = null
}
