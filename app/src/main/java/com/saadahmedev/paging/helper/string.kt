package com.saadahmedev.paging.helper

import java.util.*

fun getRandomString(length: Int): String {
    val ALLOWED_CHARACTERS = "0123456789qwertyuiopasdfghjklzxcvbnm"
    val random = Random()
    val sb = StringBuilder(length)
    for (i in 0 until length) sb.append(
        ALLOWED_CHARACTERS[random.nextInt(
            ALLOWED_CHARACTERS.length
        )]
    )
    return sb.toString()
}