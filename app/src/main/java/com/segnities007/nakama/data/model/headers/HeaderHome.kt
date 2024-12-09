package com.segnities007.nakama.data.model.headers

import androidx.navigation.NavHostController
import com.segnities007.nakama.R

data class HeaderHome(
    override val navigationIcon: Int = R.drawable.baseline_menu_24,
    override val actionIcon: Int = 0,
    override val title: String = "Nakama",
): Header

data class HeaderChat(
    override val navigationIcon: Int = R.drawable.baseline_arrow_back_24,
    override val actionIcon: Int = 0,
    override val title: String = "Nakama",
): Header

