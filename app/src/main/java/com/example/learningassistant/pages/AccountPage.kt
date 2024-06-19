package com.example.learningassistant.pages

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.learningassistant.accountPageDataClasses.Instructor
import com.example.learningassistant.accountPageDataClasses.LimitedString
import com.example.learningassistant.dataClasses.homePageModels.InformativeCourseGroupModel
import com.example.learningassistant.viewModels.AccountPageViewModel

@Composable
fun AccountPage(navController: NavController, navControllerHost: NavController){
    val viewModel: AccountPageViewModel = viewModel()
    
    viewModel.getInformativeCoursesForAccountPage()
    PageInterfaceClassic(navControllerHost = navControllerHost, pageNumber = 4) {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 10.dp))
        {
            viewModel.getInstructorObject()?.ShowThePage()
        }
    }
}
