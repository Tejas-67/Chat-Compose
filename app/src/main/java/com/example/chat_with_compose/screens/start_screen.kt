package com.example.chat_with_compose.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.chat_with_compose.R
import com.example.chat_with_compose.component.ButtonComponent
import com.example.chat_with_compose.component.IconComponenetImageVector
import com.example.chat_with_compose.component.SpacerHeight
import com.example.chat_with_compose.component.SpacerWidth
import com.example.chat_with_compose.ui.theme.Aqua


@Composable
fun StartScreen(
    navHostController: NavHostController,
    context: Context
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ){
            Image(
                painter = painterResource(id = R.drawable.image_home_screen),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.5f)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.7f)
                    .padding(bottom = 10.dp)
                    .background(Color.Black)
            ){
                Column(modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(start = 20.dp, end = 20.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.stay_connected_with_your_friends_and_family),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 36.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                    )
                    SpacerHeight(16.dp)
                    CustomCheckBox()
                }
            }

        ButtonComponent(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.CenterHorizontally)
        ){
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun CustomCheckBox(){
  Row(
      modifier = Modifier.fillMaxWidth()
  ) {
      Box(
          modifier = Modifier
              .clip(
                  RoundedCornerShape(
                      topStart = 10.dp,
                      topEnd = 10.dp,
                      bottomStart = 0.dp,
                      bottomEnd = 0.dp
                  )
              )
              .background(Aqua)
              .size(24.dp),
          contentAlignment = Alignment.Center
      ){
          IconComponenetImageVector(icon = Icons.Default.Check, size =15.dp, tint = Color.Black)
      }
      SpacerWidth()
      Text(text = "Secure, Private messaging", style = TextStyle(
          color = Color.White,
          fontSize = 20.sp,
          fontWeight = FontWeight.Bold
      )
      )
  }
}