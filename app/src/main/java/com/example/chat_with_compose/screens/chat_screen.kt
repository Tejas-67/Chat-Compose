package com.example.chat_with_compose.screens

import android.widget.Space
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.chat_with_compose.R
import com.example.chat_with_compose.component.IconComponenetImageVector
import com.example.chat_with_compose.component.IconComponentDrawable
import com.example.chat_with_compose.component.ImageFromDrawable
import com.example.chat_with_compose.component.SpacerHeight
import com.example.chat_with_compose.component.SpacerWidth
import com.example.chat_with_compose.data.Person
import com.example.chat_with_compose.data.personList

@Composable
fun ChatScreen(navHostController: NavHostController){
    val person = navHostController.previousBackStackEntry?.savedStateHandle?.get<Person>("data")!!

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            UserEachRow(person = person)
        }
    }
}

@Preview
@Composable
fun Preview() {
    Column {
        UserEachRow(person = personList[0])
        Box(
            modifier = Modifier
                .padding(12.dp)
        ){
            CustomTextField(text = "helo", onValueChange = {})
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    text: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = text, onValueChange = { onValueChange(it) },
        placeholder = {
            Text(
                text = stringResource(R.string.type_message),
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Black
                ),
                textAlign = TextAlign.Center
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Gray,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        leadingIcon = { CommonIconButton(imageVector = Icons.Default.Add) },
        trailingIcon = { CommonIconButtonDrawable(R.drawable.mic) },
        modifier = modifier.fillMaxWidth(),
        shape = CircleShape
    )

}

@Composable
fun CommonIconButton(
    imageVector: ImageVector
) {

    Box(
        modifier = Modifier
            .background(Color.Yellow, CircleShape)
            .size(33.dp), contentAlignment = Alignment.Center
    ) {
        IconComponenetImageVector(icon = imageVector, size = 15.dp, tint = Color.Black)
    }

}

@Composable
fun CommonIconButtonDrawable(
    @DrawableRes icon: Int
) {
    Box(
        modifier = Modifier
            .background(Color.Yellow, CircleShape)
            .size(33.dp), contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = icon), contentDescription = "",
            tint = Color.Black,
            modifier = Modifier.size(15.dp)
        )
    }

}

@Composable
fun UserEachRow(
    modifier: Modifier = Modifier,
    person: Person
){
    Box(
        modifier = Modifier
            .background(color = Color.Black)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 6.dp, bottom = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            ){
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                ){
                    ImageFromDrawable(icon = person.icon, size = 52.dp)
                }
                SpacerWidth(10.dp)
                Column(
                    modifier = Modifier
                        .height(52.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ){
                    Text(
                        text = person.name,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "Online",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }
            }
            IconComponenetImageVector(icon = Icons.Default.MoreVert, size = 24.dp, tint = Color.White)
        }
    }
}

@Composable
fun MessageView(text: String, time: String, isLeft: Boolean){
    val alignment: Alignment =
        if(isLeft) Alignment.BottomStart
        else Alignment.BottomEnd
    val color: Color =
        if(isLeft) Color.Yellow
        else Color.Red

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ){
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .align(alignment)
        ){
            Box(
                modifier = Modifier
                    .background(
                        color = color,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clip(RoundedCornerShape(24.dp)),
                contentAlignment = alignment
            ){
                Text(
                    text = text,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W400
                    ),
                    modifier = Modifier
                        .padding(
                            start = 12.dp, end = 12.dp,
                            top = 6.dp, bottom = 6.dp
                        )
                )
            }
            SpacerHeight(2.dp)
            Text(
                text = time,
                modifier = Modifier
                    .padding(start = 2.dp, end = 2.dp)
            )
        }
    }
}