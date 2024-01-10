package com.example.motiondemoapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.motiondemoapp.adapter.ProfileAdapter
import com.example.motiondemoapp.data.ProfileData
import com.example.motiondemoapp.databinding.ActivityProfileBinding
import com.example.motiondemoapp.listener.ProfileClickListener

class ProfileActivity : AppCompatActivity(), ProfileClickListener {

    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProfileBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvProfile.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ProfileData>()

        for (i in 1..10) {
            data.add(ProfileData(R.drawable.img, "Item $i"))
        }

        val adapter = ProfileAdapter(data, this)

        binding.rvProfile.adapter = adapter
    }

    override fun profileItemClick(
        name: String,
        image: Int,
        txtName: TextView,
        imgImage: ImageView
    ) {
        val intent = Intent(this, ProfileDetailsActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("image", image)
        val transition1 = ViewCompat.getTransitionName(txtName).toString()
        val transition2 = ViewCompat.getTransitionName(imgImage).toString()

        val transition = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this@ProfileActivity, Pair(txtName,transition1), Pair(imgImage,transition2)
        ).toBundle()
        startActivity(intent,transition)
    }
}
