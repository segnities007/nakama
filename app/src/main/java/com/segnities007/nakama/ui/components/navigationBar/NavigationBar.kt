package com.segnities007.nakama.ui.components.navigationBar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.segnities007.nakama.data.model.navigations.Navigation
import com.segnities007.nakama.ui.screens.home.HomeViewModel

@Composable
fun NavigationBar(
//    navigationViewModel: NavigationViewModel = hiltViewModel(),
    navigation: Navigation,
    homeViewModel: HomeViewModel,
) {
    val currentIndex by homeViewModel.index.collectAsState()

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
                    homeViewModel.updateIndex(index)
                }
            )
        }
    }
}

