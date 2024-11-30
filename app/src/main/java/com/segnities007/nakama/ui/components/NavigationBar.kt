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
import com.segnities007.nakama.data.model.Info

@Composable
fun NavigationBar(
    navigationViewModel: NavigationViewModel = NavigationViewModel(),
    info: Info
) {
    val currentIndex by navigationViewModel.index.collectAsState()

    NavigationBar {
        info.labels.forEachIndexed { index, label ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (currentIndex == index) {
                                info.selectedVectors[index]
                            } else {
                                info.noSelectedVectors[index]
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

    fun onItemSelected(newIndex: Int) {
        _index.value = newIndex
    }

}
