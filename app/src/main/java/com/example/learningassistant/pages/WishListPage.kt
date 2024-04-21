package com.example.learningassistant.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learningassistant.BottomBar
import com.example.learningassistant.interfaceClasses.InformativeCourses
import com.example.learningassistant.R
import com.example.learningassistant.dataClasses.homePageModels.InformativeCourseGroupModel
import com.example.learningassistant.ui.theme.backgroundColorClassic

private val interfaceCreator = InterfaceCreator()
private val wishList = ArrayList<InformativeCourseGroupModel>()
@Composable
fun WishListPage(navController: NavController, navControllerHost: NavController ){
    getWishList()
    WishListPageInterface(navController = navController, navControllerHost = navControllerHost, pageNumber = 3) {
        Surface(modifier = Modifier.padding(0.dp, 50.dp)) {
            WishListCourses()
        }
    }
}

@Composable
fun WishListPageInterface(navController: NavController, navControllerHost: NavController, pageNumber: Int, operation: @Composable () -> Unit){
    PageInterfaceClassic(navControllerHost = navControllerHost, pageNumber = pageNumber)
    {
        interfaceCreator.MainInterface(

            navControllerHost = navControllerHost,
            pageNumber = pageNumber,

            bottomBar =
            {
                BottomBar(navController = navControllerHost, page = pageNumber)
            },

            topBar =
            {
                TopBarWishListPage(navController = navController)
            })

        {
            operation()
        }
    }
}

@Composable
fun TopBarWishListPage(navController: NavController) {
    val topBarCreator = TopBarCreator(navController, 70.dp, Alignment.CenterVertically, Arrangement.SpaceBetween,
        Modifier.fillMaxWidth().fillMaxHeight().padding(10.dp, 0.dp))
    topBarCreator.TopBarClassic("Wish List", R.drawable.entering_way_icon, 50)
}

@Composable
fun WishListCourses() {
    val informativeCourses = InformativeCourses()
    informativeCourses.InformativeCourseHolderColumn(
        backgroundColor = backgroundColorClassic,
        with = 360,
        upSpacerPadding = 10,
        bottomSpacerPadding = 10,
        suggestedCourseList = wishList,
        120.dp
    )
}


fun getWishList(){
    val wishCourse1 = InformativeCourseGroupModel("Example1", 12, 90, 10, 700)
    val wishCourse2 = InformativeCourseGroupModel("Example2", 15, 32, 23, 400)
    val wishCourse3 = InformativeCourseGroupModel("Example3", 17, 56, 35, 300)
    val wishCourse4 = InformativeCourseGroupModel("Example4", 8, 24, 27, 200)
    val wishCourse5 = InformativeCourseGroupModel("Example5", 10, 20, 48, 100)
    val wishCourse6 = InformativeCourseGroupModel("Example6", 5, 10, 40, 320)
    val wishCourse7 = InformativeCourseGroupModel("Example7", 11, 29, 18, 450)
    val wishCourse8 = InformativeCourseGroupModel("Example8", 2, 4, 30, 120)
    wishList.add(wishCourse1)
    wishList.add(wishCourse2)
    wishList.add(wishCourse3)
    wishList.add(wishCourse4)
    wishList.add(wishCourse5)
    wishList.add(wishCourse6)
    wishList.add(wishCourse7)
    wishList.add(wishCourse8)
}