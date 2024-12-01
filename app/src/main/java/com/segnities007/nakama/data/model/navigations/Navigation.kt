package com.segnities007.nakama.data.model.navigations

interface Navigation {
    val labels: List<String>
    val selectedVectors: List<Int>
    val noSelectedVectors: List<Int>
}