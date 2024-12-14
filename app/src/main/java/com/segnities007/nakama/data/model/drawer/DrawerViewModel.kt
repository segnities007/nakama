package com.segnities007.nakama.data.model.drawer

import androidx.compose.material3.DrawerValue
import kotlinx.coroutines.flow.StateFlow

interface DrawerViewModel {
    val index: StateFlow<Int>
    val drawerState: StateFlow<DrawerValue>

    fun openDrawer()
    fun closeDrawer()
    fun updateIndex(index: Int)
}

