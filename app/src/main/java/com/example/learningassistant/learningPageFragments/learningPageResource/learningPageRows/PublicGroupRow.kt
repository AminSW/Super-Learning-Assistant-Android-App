package com.example.learningassistant.learningPageFragments.learningPageResource.learningPageRows

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningassistant.R
import com.example.learningassistant.dataClasses.learningPageModels.PublicGroupModel
import com.example.learningassistant.learningPageFragments.learningPageResource.TextIconVertical
import com.example.learningassistant.learningPageFragments.learningPageResource.mainColor
import com.example.learningassistant.learningPageFragments.learningPageResource.notNotificationColor
import com.example.learningassistant.ui.theme.containerColor


@Composable
fun PublicGroupsRow(data: PublicGroupModel){
    val title = data.groupName
    val message = data.lastMessage
    val color = if(data.notification) mainColor else notNotificationColor
    Surface(modifier = Modifier
        .height(130.dp)
        .padding(10.dp)
        .fillMaxWidth(),
        color = containerColor,
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 3.dp
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween)
        {
            Surface(modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(15.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null)
            }


            Column(modifier = Modifier.height(100.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround) {

                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center)
                {
                    Text(text = title, fontSize = 25.sp)
                }
                Text(text = message)
            }

            Column(modifier = Modifier
                .fillMaxHeight()
                .width(80.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                TextIconVertical(size = 45,
                    padding = 8,
                    address = R.drawable.notification_icon,
                    iconColor = color,
                    containerColor, null, "", "")
            }
        }

    }
}
