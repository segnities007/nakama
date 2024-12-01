package com.segnities007.nakama.ui.components

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.MutableStateFlow
import com.segnities007.nakama.R
import com.segnities007.nakama.data.model.headers.Header
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(
    modifier: Modifier = Modifier,
    headerViewModel: HeaderViewModel = hiltViewModel(),
    headerHome: Header,
    navController: NavHostController,
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState()),
){

    CenterAlignedTopAppBar(
        title = {Text(headerHome.title)},
        modifier = modifier,
        navigationIcon = {
            if(headerHome.navigationIcon != 0){
                IconButton(
                    onClick = { headerHome.navigationHandler(navController) },
                ){
                    Icon(painter = painterResource(headerHome.navigationIcon), contentDescription = null)
                }
            }
        },
        actions = {
            if(headerHome.actionIcon != 0)
                IconButton(
                    onClick = {},
                ){
                    Icon(painter = painterResource(headerHome.actionIcon), contentDescription = null)
                }
        },
        scrollBehavior = scrollBehavior
    )
}

@HiltViewModel
class HeaderViewModel @Inject constructor(
//    @ApplicationContext val context: Application,
): ViewModel(){

}