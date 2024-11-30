package com.segnities007.nakama.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.segnities007.nakama.R

@Composable
fun NavigationBar(
    navigationViewModel: NavigationViewModel = NavigationViewModel()
) {
    val currentIndex by navigationViewModel.index.collectAsState()

    NavigationBar {
        navigationViewModel.labels.forEachIndexed { index, label ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (currentIndex == index) {
                                navigationViewModel.selectedVectors[index]
                            } else {
                                navigationViewModel.noSelectedVectors[index]
                            }
                        ),
                        contentDescription = label
                    )
                },
                label = { Text(label) },
                selected = currentIndex == index,
                onClick = {
                    navigationViewModel.onItemSelected(index)
                }
            )
        }
    }
}

class NavigationViewModel : ViewModel() {
    private val _index = MutableStateFlow(0)
    val index: StateFlow<Int> = _index

    val labels = listOf(
        "Nakama",
        "Nikki",
        "Search",
        "Notify",
        "Setting"
    )

    val selectedVectors = listOf(
        R.drawable.baseline_group_24,
        R.drawable.baseline_menu_book_24,
        R.drawable.baseline_search_24,
        R.drawable.baseline_notifications_24,
        R.drawable.baseline_settings_24
    )

    val noSelectedVectors = listOf(
        R.drawable.outline_group_24,
        R.drawable.outline_menu_book_24,
        R.drawable.outline_search_24,
        R.drawable.outline_notifications_24,
        R.drawable.outline_settings_24
    )

    fun onItemSelected(newIndex: Int) {
        _index.value = newIndex
    }
}
