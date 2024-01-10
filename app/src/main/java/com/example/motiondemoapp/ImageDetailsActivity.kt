package com.example.motiondemoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import com.example.motiondemoapp.databinding.ActivityImageDetailsBinding
import kotlin.math.abs

class ImageDetailsActivity : AppCompatActivity() {

    private lateinit var gestureDetector: GestureDetector
    lateinit var binding:ActivityImageDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityImageDetailsBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        gestureDetector = GestureDetector(this, MyGestureListener())
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return gestureDetector.onTouchEvent(event!!) && super.onTouchEvent(event)
    }

    inner class MyGestureListener: GestureDetector.SimpleOnGestureListener(){
        override fun onFling(
            e1: MotionEvent,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            val swipeThreshold = 100 // Adjust this threshold as needed
            val swipeDistanceThreshold = 100 // Adjust this threshold as needed

            // Calculate the difference in Y coordinates
            val deltaY = e2.y - e1.y

            if (abs(deltaY) > swipeThreshold && abs(velocityY) > swipeDistanceThreshold) {
                if (deltaY > 0) {
                    val intent = Intent(this@ImageDetailsActivity, MainActivity::class.java)
                    val option: ActivityOptionsCompat =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(
                            this@ImageDetailsActivity, binding.imgMain,
                            ViewCompat.getTransitionName(binding.imgMain).toString()
                        )
                    startActivity(intent, option.toBundle())
                    return true
                }
            }
            return super.onFling(e1, e2, velocityX, velocityY)
        }
    }
}