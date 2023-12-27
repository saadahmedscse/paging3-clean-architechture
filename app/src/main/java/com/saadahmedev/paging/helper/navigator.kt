package com.saadahmedev.paging.helper

import android.view.View
import androidx.navigation.Navigation

fun View.navigate(id: Int) {
    Navigation.findNavController(this).navigate(id)
}