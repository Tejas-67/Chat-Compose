package com.example.chat_with_compose.data

data class Chat(
    val id: Int,
    val message: String,
    val time: String,
    val left: Boolean
)

val chatList = listOf(
    Chat(
        1,
        "message1",
        "11:01 PM",
        true
    ),
    Chat(
        2,
        "message2",
        "11:02 PM",
        false
    ),
    Chat(
        3,
        "message3",
        "11:03 PM",
        true
    ),
    Chat(
        4,
        "message4",
        "11:04 PM",
        false
    ),
    Chat(
        5,
        "message5",
        "11:05 PM",
        true
    ),
    Chat(
        6,
        "message6",
        "11:06 PM",
        false
    ),
    Chat(
        7,
        "message7",
        "11:07 PM",
        false
    ),
    Chat(
        8,
        "message8",
        "11:08 PM",
        true
    ),
    Chat(
        9,
        "message9",
        "11:09 PM",
        false
    ),
    Chat(
        10,
        "message10",
        "11:10 PM",
        true
    ),
    Chat(
        11,
        "message11",
        "11:11 PM",
        false
    ),
    Chat(
        12,
        "message12",
        "11:12 PM",
        true
    ),
    Chat(
        13,
        "message13",
        "11:13 PM",
        false
    ),
    Chat(
        14,
        "message14",
        "11:14 PM",
        true
    ),
    Chat(
        15,
        "message15",
        "11:15 PM",
        false
    ),
    Chat(
        16,
        "message16",
        "11:16 PM",
        true
    )
)
