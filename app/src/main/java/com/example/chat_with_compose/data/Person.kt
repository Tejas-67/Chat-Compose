package com.example.chat_with_compose.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.example.chat_with_compose.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    val id: Int,
    val name: String,
    @DrawableRes val icon: Int = R.drawable.img1
): Parcelable

val personList = listOf(
    Person(
        1,
        "Person 1",
        R.drawable.img1
    ),
    Person(
        2,
        "Person 2",
        R.drawable.img2
    ),
    Person(
        3,
        "Person 3",
        R.drawable.img1
    ),
    Person(
        4,
        "Person 4",
        R.drawable.img4
    ),
    Person(
        5,
        "Person 5",
        R.drawable.img2
    ),
    Person(
        6,
        "Person 6",
        R.drawable.img4
    ),
    Person(
        7,
        "Person 7",
        R.drawable.img5
    ),
    Person(
        8,
        "Person 8",
        R.drawable.img6
    ),
    Person(
        9,
        "Person 9",
        R.drawable.img7
    ),
    Person(
        10,
        "Person 10",
        R.drawable.img3
    )
)

