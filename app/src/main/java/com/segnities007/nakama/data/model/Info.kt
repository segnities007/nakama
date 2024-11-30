package com.segnities007.nakama.data.model

interface Info {
    val labels: List<String>
    val selectedVectors: List<Int>
    val noSelectedVectors: List<Int>
}