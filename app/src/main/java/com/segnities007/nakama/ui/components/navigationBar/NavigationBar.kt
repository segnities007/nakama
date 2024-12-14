package com.segnities007.nakama.ui.components.navigationBar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.segnities007.nakama.data.model.drawer.DrawerViewModel
import com.segnities007.nakama.data.model.navigations.Navigation

@Composable
fun NavigationBar(
    modifier: Modifier = Modifier,
    navigation: Navigation,
    viewModel: DrawerViewModel,
) {
    val currentIndex by viewModel.index.collectAsState()

    NavigationBar {
        navigation.labels.forEachIndexed { index, label ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (currentIndex == index) navigation.selectedVectors[index] else navigation.noSelectedVectors[index]
                        ),
                        contentDescription = label
                    )
                },
                label = { Text(label) },
                selected = currentIndex == index,
                onClick = { viewModel.updateIndex(index) }
            )
        }
    }
}

