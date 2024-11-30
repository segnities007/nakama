package com.segnities007.nakama.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.segnities007.nakama.R
import com.segnities007.nakama.data.model.HomeInfo
import com.segnities007.nakama.data.model.Info
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.compose.runtime.getValue
import javax.inject.Inject

@Composable
fun NavigationDrawer(
    navigationDrawerViewModel: NavigationDrawerViewModel,
    content: @Composable (Int) -> Unit,
    info: Info
){
    val currentIndex by navigationDrawerViewModel.index.collectAsState()
    ModalNavigationDrawer(
        drawerContent = {
            info.labels.forEachIndexed { index, label ->
                ModalDrawerSheet {
                    Text("Drawer title", modifier = Modifier.padding(16.dp))
                    HorizontalDivider()
                    NavigationDrawerItem(
                        icon = {Icon(painter = painterResource(info.noSelectedVectors[index]), contentDescription = label)},
                        label = { Text(label) },
                        selected = false,
                        onClick = {
                            navigationDrawerViewModel.onItemSelected(index)
                        }
                    )
                }
            }
        }
    ) {
        content(currentIndex)
    }
}

@HiltViewModel
class NavigationDrawerViewModel @Inject constructor(

): ViewModel(){
    private val _index = MutableStateFlow(0)
    val index: StateFlow<Int> = _index

    fun onItemSelected(newIndex: Int) {
        _index.value = newIndex
    }
}