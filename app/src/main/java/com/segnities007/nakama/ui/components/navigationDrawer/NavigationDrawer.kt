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
import androidx.compose.runtime.rememberCoroutineScope
import com.segnities007.nakama.ui.screens.home.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun NavigationDrawer(
//    navigationDrawerViewModel: NavigationDrawerViewModel = hiltViewModel(),
    homeViewModel: HomeViewModel,
    content: @Composable () -> Unit,
    navigation: Navigation
){
    val currentIndex by homeViewModel.index.collectAsState()
    val drawerState by homeViewModel.drawerState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val title = "title"

    ModalNavigationDrawer(
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
                            homeViewModel.updateIndex(index)
                            coroutineScope.launch{
                                //TODO move other screen
                                homeViewModel.updateIndex(index)
                                homeViewModel.closeDrawer()
                            }
                        }
                    )
                }
            }
        }
    ) {
        content()
    }
}