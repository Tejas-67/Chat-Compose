package com.example.chat_with_compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.chat_with_compose.R
import com.example.chat_with_compose.component.IconComponenetImageVector
import com.example.chat_with_compose.component.ImageFromDrawable
import com.example.chat_with_compose.component.SpacerHeight
import com.example.chat_with_compose.component.SpacerWidth
import com.example.chat_with_compose.data.Person
import com.example.chat_with_compose.data.personList
import com.example.chat_with_compose.navigation.Chat

@Composable
fun HomeScreen(
    navHostController: NavHostController
){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ){
            SpacerHeight(12.dp)
            HeadingText(name = "Tejas")
            SpacerHeight(12.dp)
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                SpacerWidth(12.dp)
                AddStoryLayout()
                SpacerWidth(12.dp)
                UserStoryHorizontalItemList(persons = personList)
                SpacerWidth(12.dp)
            }
            SpacerHeight(20.dp)

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                    )
            ){
                Column{

                    BottomSheetSwipe(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    SpacerHeight(12.dp)

                    LazyColumn{
                        items(personList){
                            UserMessageLayout(person = it) {
                                navHostController.currentBackStackEntry?.savedStateHandle?.set("data", it)
                                navHostController.navigate(Chat)
                            }
                        }
                    }
                }

            }
            

        }

    }
}

@Composable
fun UserMessageLayout(
    person: Person,
    onClick: () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(horizontal = 4.dp, vertical = 4.dp)
            .clickable { onClick }
    ){
        Column{
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(70.dp)
                ){
                    ImageFromDrawable(icon = person.icon, size = 70.dp)
                }

                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(start = 6.dp, top = 4.dp, bottom = 6.dp, end = 6.dp)
                        .height(50.dp)
                ){
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Text(
                            text = person.name,
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = "5:24 PM",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.W300
                            )
                        )
                    }
                    Text(
                        text = "Hello",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W400
                        )
                    )
                }
            }
            SpacerHeight(4.dp)
            ChatEndBottomLine()
        }
    }
}
@Composable
fun UserStoryHorizontalItemList(persons: List<Person>){
    LazyRow{
        items(persons){ person ->
            UserStoryLayout(person = person)
        }
    }
}

@Composable
fun UserStoryLayout(person: Person){
    Column(
        modifier = Modifier
            .padding(end = 4.dp)
    ){
        Box(modifier = Modifier
            .clip(CircleShape)
            .border(
                2.dp, color = Color.Yellow, shape = CircleShape
            )
            .background(
                color = Color.Unspecified, shape = CircleShape
            )
            .size(
                70.dp
            ),
            contentAlignment = Alignment.Center
        ){
            ImageFromDrawable(icon = person.icon, size = 65.dp)
        }
        SpacerHeight(10.dp)
        Text(
            text = person.name,
            style = TextStyle(
                fontSize = 13.sp,
                color = Color.White
            ),
            modifier = Modifier.align(CenterHorizontally)
        )
    }
}

@Composable
fun AddStoryLayout(){

    Column {
        Box(
            modifier = Modifier
                .border(
                    2.dp, color = Color.DarkGray, shape = CircleShape
                )
                .background(
                    color = Color.Yellow, shape = CircleShape
                )
                .size(70.dp),
            contentAlignment = Alignment.Center
        ){
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Black)
                    .size(20.dp),
                contentAlignment = Alignment.Center
            ){
                IconComponenetImageVector(icon = Icons.Default.Add, size = 12.dp, tint = Color.Yellow)
            }
        }
        SpacerHeight(10.dp)
        Text(
            text = "Add Story",
            style = TextStyle(
                fontSize = 13.sp,
                color = Color.White
            ),
            modifier = Modifier.align(CenterHorizontally)
        )
    }

}

@Composable
fun HeadingText(name: String){
    val text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.W300
            )
        ){
            append(stringResource(R.string.welcome))
        }
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontSize =  20.sp,
                fontWeight = FontWeight.Bold
            )
        ){
            append(name)
        }
    }

    Text(
        text = text,
        modifier = Modifier.padding(start = 12.dp, end = 12.dp)
    )
}

@Composable
fun ChatEndBottomLine(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .height(1.dp)
            .background(Color.LightGray)
    )
}
@Composable
fun BottomSheetSwipe(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .clip(
                RoundedCornerShape(90.dp)
            )
            .width(90.dp)
            .height(5.dp)
            .background(Color.Gray)
    )
}