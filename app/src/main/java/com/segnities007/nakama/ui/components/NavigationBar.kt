package com.segnities007.nakama.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.segnities007.nakama.data.model.navigations.Navigation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@Composable
fun NavigationBar(
    navigationViewModel: NavigationViewModel = hiltViewModel(),
    navigation: Navigation
) {
    val currentIndex by navigationViewModel.index.collectAsState()

    NavigationBar {
        navigation.labels.forEachIndexed { index, label ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (currentIndex == index) {
                                navigation.selectedVectors[index]
                            } else {
                                navigation.noSelectedVectors[index]
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

@HiltViewModel
class NavigationViewModel@Inject constructor(

): ViewModel() {
    private val _index = MutableStateFlow(0)
    val index: StateFlow<Int> = _index

    fun onItemSelected(newIndex: Int) {
        _index.value = newIndex
    }

}
