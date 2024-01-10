package com.example.motiondemoapp

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.motiondemoapp.databinding.ActivityProfileDetailsBinding

class ProfileDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProfileDetailsBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")

        binding.txtProfileName.text = name

        val slideUpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        val slideUpAnimation2 = AnimationUtils.loadAnimation(this, R.anim.slide_up2)
        val slideUpAnimation3 = AnimationUtils.loadAnimation(this, R.anim.slide_up3)
        binding.imgHome.startAnimation(slideUpAnimation)
        binding.txtAddress.startAnimation(slideUpAnimation)
        binding.viewLine1.startAnimation(slideUpAnimation)

        binding.imgPhone.startAnimation(slideUpAnimation2)
        binding.txtPhone.startAnimation(slideUpAnimation2)
        binding.viewLine2.startAnimation(slideUpAnimation2)

        binding.imgMail.startAnimation(slideUpAnimation3)
        binding.txtMail.startAnimation(slideUpAnimation3)
        binding.viewLine3.startAnimation(slideUpAnimation3)

        slideUpAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {}

            override fun onAnimationRepeat(animation: Animation?) {}

        })
    }
}