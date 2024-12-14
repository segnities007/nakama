package com.segnities007.nakama.ui.components.navigationDrawer

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
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
import com.segnities007.nakama.data.model.navigations.Navigation
import androidx.compose.runtime.getValue
import com.segnities007.nakama.data.model.drawer.DrawerViewModel
@Composable
fun NavigationDrawer(
    viewModel: DrawerViewModel,
    navigation: Navigation,
    content: @Composable () -> Unit,
){
    val currentIndex by viewModel.index.collectAsState()
    val drawerState by viewModel.drawerState.collectAsState()
    val title = "title"

    ModalNavigationDrawer(
        gesturesEnabled = false,
        drawerState = DrawerState(drawerState),
        drawerContent = {
            ModalDrawerSheet {
                Text(title, modifier = Modifier.padding(16.dp))
                HorizontalDivider()
                navigation.labels.forEachIndexed { index, label ->
                    NavigationDrawerItem(
                        icon = { Icon(painter = painterResource(navigation.noSelectedVectors[index]), contentDescription = label) },
                        label = { Text(label) },
                        selected = currentIndex == index,
                        onClick = {
                            viewModel.updateIndex(index)
                            viewModel.closeDrawer()
                        }
                    )
                }
            }
        }
    ) {
        content()
    }
}