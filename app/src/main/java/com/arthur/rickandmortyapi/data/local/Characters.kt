package com.arthur.rickandmortyapi.data.local

data class Characters (
        val info: Info? = null,
        val results: List<Character> = emptyList()
)

data class Character(
        val id: Int,
        val name: String,
        val status: String,
        val species: String,
        val type: String,
        val gender: String,
        val origin: Origin,
        val characterLocation: CharacterLocation,
        val image: String,
        val episode: List<String>,
        val url: String,
        val created: String
)

data class Origin(
        val name: String,
        val url: String
)

data class CharacterLocation(
        val name: String,
        val url: String
)