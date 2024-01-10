package com.example.motiondemoapp

import android.content.Intent
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import com.example.motiondemoapp.databinding.ActivityMainBinding
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var gestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Initialize the gesture detector
        gestureDetector = GestureDetector(this, MyGestureListener())

        /*   binding.imgClick.setOnClickListener {
               val intent = Intent(this, ImageDetailsActivity::class.java)
               val option: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                   this, binding.imgClick,
                   ViewCompat.getTransitionName(binding.imgClick).toString()
               )
               startActivity(intent, option.toBundle())
           }*/

        binding.btnProfileActivity.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        binding.btnApiCall.setOnClickListener {
            val intent = Intent(this, PostListActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return gestureDetector.onTouchEvent(event!!) || super.onTouchEvent(event)
    }

    inner class MyGestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onFling(
            e1: MotionEvent,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float,
        ): Boolean {
            val swipeThreshold = 100 // Adjust this threshold as needed
            val swipeDistanceThreshold = 100 // Adjust this threshold as needed

            // Calculate the difference in Y coordinates
            val deltaY = e2.y - e1.y

            if (abs(deltaY) > swipeThreshold && abs(velocityY) > swipeDistanceThreshold) {

                val intent = Intent(this@MainActivity, ImageDetailsActivity::class.java)
                val option: ActivityOptionsCompat =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this@MainActivity, binding.imgClick,
                        ViewCompat.getTransitionName(binding.imgClick).toString()
                    )
                startActivity(intent, option.toBundle())
                return true
            }

            return super.onFling(e1, e2, velocityX, velocityY)
        }
    }
}