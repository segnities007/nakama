package com.segnities007.nakama.data.model.headers

import com.segnities007.nakama.R

data class HeaderLogin(
    override val navigationIcon: Int = R.drawable.baseline_menu_24,
    override val actionIcon: Int = 0,
    override val title: String = "Nakama",
): Header