package com.example.motiondemoapp.listener

import android.widget.ImageView
import android.widget.TextView

/**
 * Created by Tirth Patel.
 */
interface ProfileClickListener {

    fun profileItemClick(name: String, image: Int, txtName: TextView, imgImage: ImageView)
}