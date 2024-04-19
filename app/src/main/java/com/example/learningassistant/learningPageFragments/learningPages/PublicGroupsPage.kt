package com.example.learningassistant.learningPageFragments.learningPages

import com.example.learningassistant.dataClasses.LearningPageModels.PublicGroupModel
import com.example.learningassistant.ui.theme.backgroundColorClassic
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mylearningasistant4.LearningPageFragments.LearningPageResource.LearningPageRows.PublicGroupsRow
import com.example.mylearningasistant4.LearningPageFragments.LearningPageResource.PageInterfaceForLearningPages

private val publicGroupList = ArrayList<PublicGroupModel>()

@Composable
fun PublicGroup(navController: NavController, navControllerHost: NavController) {
    addPublicGroups()
    PageInterfaceForLearningPages(
        navController = navController, navControllerHost = navControllerHost, 2)
    {
        Spacer(modifier = Modifier.padding(35.dp))
        PublicGroupList(publicGroupList = publicGroupList)
    }
}

@Composable
fun PublicGroupList(publicGroupList : ArrayList<PublicGroupModel>) {
    Surface(
        modifier = Modifier.padding(0.dp, 40.dp, 0.dp, 0.dp),
        color = backgroundColorClassic
    )
    {
        LazyColumn {
            items(publicGroupList.size)
            {index ->
                PublicGroupsRow(data = publicGroupList[index])
            }
        }
    }
}

fun addPublicGroups(){
    publicGroupList.add(PublicGroupModel("Example 1", false, "last message ..."))
    publicGroupList.add(PublicGroupModel("Example 2", false, "last message ..."))
    publicGroupList.add(PublicGroupModel("Example 3", true, "last message ..."))
    publicGroupList.add(PublicGroupModel("Example 4", false, "last message ..."))
    publicGroupList.add(PublicGroupModel("Example 5", true, "last message ..."))
    publicGroupList.add(PublicGroupModel("Example 6", true, "last message ..."))
}