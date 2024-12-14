package com.segnities007.nakama.ui.components.header

import android.util.Log
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.segnities007.nakama.data.model.drawer.DrawerViewModel
import com.segnities007.nakama.data.model.headers.Header

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(
    modifier: Modifier = Modifier,
    viewModel: DrawerViewModel,
    headerInfo: Header,
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState()),
){
    val shadow = 16

    CenterAlignedTopAppBar(
        title = {Text(headerInfo.title)},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        modifier = modifier.shadow(shadow.dp),
        navigationIcon = {
            Log.d("test", "push navigation Icon")
            if(headerInfo.navigationIcon != 0){

                Log.d("test", "success")
                IconButton(
                    onClick = {
                        viewModel.openDrawer()
                              },
                ){
                    Icon(painter = painterResource(headerInfo.navigationIcon), contentDescription = null)
                }
            }
        },
        actions = {
            if(headerInfo.actionIcon != 0) {
                IconButton(
                    onClick = {},
                ) {
                    Icon(
                        painter = painterResource(headerInfo.actionIcon),
                        contentDescription = null
                    )
                }
            }
        },
        scrollBehavior = scrollBehavior
    )
}