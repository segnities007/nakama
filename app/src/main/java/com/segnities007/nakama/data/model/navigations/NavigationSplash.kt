package com.segnities007.nakama.data.model.navigations

//多分いらない
data class NavigationSplash(
    override val labels: List<String> = listOf(),
    override val selectedVectors: List<Int> = listOf(),
    override val noSelectedVectors: List<Int> = listOf(),
): Navigation