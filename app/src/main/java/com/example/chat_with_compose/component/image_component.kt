package com.example.chat_with_compose.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

@Composable
fun ImageFromDrawable(@DrawableRes icon: Int, size: Dp){

    Image(
        painter = painterResource(id = icon),
        contentDescription = null,
        modifier = Modifier.size(size = size),
        contentScale = ContentScale.FillBounds
    )

}