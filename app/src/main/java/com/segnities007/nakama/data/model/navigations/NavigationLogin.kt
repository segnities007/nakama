package com.segnities007.nakama.data.model.navigations

import com.segnities007.nakama.R

data class NavigationLogin(
    override val labels: List<String> = listOf(
        "Sigh in",
        "Sign up",
    ),
    override val selectedVectors: List<Int> = listOf(
        R.drawable.baseline_login_24,
        R.drawable.baseline_person_add_24
    ),
    override val noSelectedVectors: List<Int> = listOf(
        R.drawable.baseline_login_24,
        R.drawable.outline_person_add_24
    ),
): Navigation