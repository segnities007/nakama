package com.segnities007.nakama.data.model

import com.segnities007.nakama.R

data class HomeInfo(
    override val labels: List<String> = listOf(
        "Nakama",
        "Nikki",
        "Search",
        "Notify",
        "Setting",
    ),
    override val selectedVectors: List<Int> = listOf(
        R.drawable.baseline_group_24,
        R.drawable.baseline_menu_book_24,
        R.drawable.baseline_search_24,
        R.drawable.baseline_notifications_24,
        R.drawable.baseline_settings_24,
    ),
    override val noSelectedVectors: List<Int> = listOf(
        R.drawable.outline_group_24,
        R.drawable.outline_menu_book_24,
        R.drawable.outline_search_24,
        R.drawable.outline_notifications_24,
        R.drawable.outline_settings_24,
    ),
): Info

