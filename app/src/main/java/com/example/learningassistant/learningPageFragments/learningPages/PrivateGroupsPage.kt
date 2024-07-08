package com.example.learningassistant.learningPageFragments.learningPages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learningassistant.data.dataClasses.learningPageModels.PrivateGroupModel
import com.example.learningassistant.learningPageFragments.learningPageResource.PageInterfaceForLearningPages
import com.example.learningassistant.learningPageFragments.learningPageResource.learningPageRows.PrivateGroupsRow
import com.example.learningassistant.ui.theme.backgroundColorClassic

private val privateGroupList = ArrayList<PrivateGroupModel>()

@Composable
fun PrivateGroup(navController: NavController, navControllerHost: NavController){
    addPrivateGroups()
    PageInterfaceForLearningPages(
        navController = navController, navControllerHost = navControllerHost, 2)
    {
        Spacer(modifier = Modifier.padding(75.dp))
        PrivateGroupList(privateGroupList = privateGroupList)
    }

}

@Composable
fun PrivateGroupList(privateGroupList: List<PrivateGroupModel>) {
    Surface(
        modifier = Modifier.padding(0.dp, 40.dp, 0.dp, 0.dp),
        color = backgroundColorClassic
    )
    {
        println("Size: "+privateGroupList.size)
        LazyColumn {
            items(privateGroupList.size)
            { index ->
                PrivateGroupsRow(data = privateGroupList[index])
            }
        }
    }
}

fun addPrivateGroups(){
    privateGroupList.add(PrivateGroupModel("Example 1", false))
    privateGroupList.add(PrivateGroupModel("Example 2", false))
    privateGroupList.add(PrivateGroupModel("Example 3", true))
    privateGroupList.add(PrivateGroupModel("Example 4", false))
    privateGroupList.add(PrivateGroupModel("Example 5", true))
//    privateGroupList.add(PrivateGroupModel("Example 6", true))
}