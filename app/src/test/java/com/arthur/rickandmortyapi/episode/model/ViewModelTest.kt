package com.arthur.rickandmortyapi.episode.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.junit.rules.TestRule

open class ViewModelTest {
    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()
}