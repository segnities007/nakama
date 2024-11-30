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
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.MutableStateFlow
import com.segnities007.nakama.R
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(
    title: String = "Nakama",
    modifier: Modifier = Modifier,
    headerViewModel: HeaderViewModel, //状態あまり変わらないと思うから不使用
    isArrowBack: Boolean = false,
    menuVector: Int = R.drawable.baseline_menu_24,
    backArrowVector: Int = R.drawable.baseline_arrow_back_24,
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState()),
){

    CenterAlignedTopAppBar(
        title = {Text(title)},
        modifier = modifier,
        navigationIcon = {
            if(isArrowBack) {
                IconButton(
                    onClick = { headerViewModel.backScreen() },
                ){
                    Icon(painter = painterResource(backArrowVector), contentDescription = null)
                }
            } else {
                IconButton(
                    onClick = {},
                ){
                    Icon(painter = painterResource(menuVector), contentDescription = null)
                }
            }
        },
        actions = {
            if(isArrowBack) {
                IconButton(
                    onClick = {},
                ){
                    Icon(painter = painterResource(menuVector), contentDescription = null)
                }
            } else { //TODO user icon
//                IconButton(
//                    onClick = {},
//                ){
//                    Icon(painter = painterResource(menuVector), contentDescription = null)
//                }
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@HiltViewModel
class HeaderViewModel @Inject constructor(
//    @ApplicationContext val context: Application,
    val navController: NavHostController,
): ViewModel(){

    fun backScreen(){
        navController.popBackStack()
    }

}