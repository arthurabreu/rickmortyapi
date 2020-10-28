package com.arthur.rickandmortyapi.episode.model

import com.arthur.rickandmortyapi.data.local.Episodes
import com.arthur.rickandmortyapi.data.local.Info
import com.arthur.rickandmortyapi.data.local.Result

fun getEpisodes() : Episodes{
    return Episodes(
            getInfo(),
            listOf(getResult())
    )
}

fun getResult() : Result{
    return Result(
            0,
            "",
            "",
            "",
            listOf("", ""),
            "",
            ""
    )
}

fun getInfo() : Info{
    return Info(
            0,
            0,
            "",
            ""
    )
}