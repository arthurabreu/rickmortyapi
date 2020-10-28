package com.arthur.rickandmortyapi.data.local

data class Episodes(
    val info: Info? = null,
    val results: List<Result> = emptyList()
)

data class Result(
    val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
    val characters: List<String>,
    val url: String,
    val created: String
)