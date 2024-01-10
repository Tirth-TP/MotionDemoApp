package com.example.motiondemoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.motiondemoapp.R
import com.example.motiondemoapp.data.ProfileData
import com.example.motiondemoapp.listener.ProfileClickListener

/**
 * Created by Tirth Patel.
 */
class ProfileAdapter(
    private val profileList: ArrayList<ProfileData>,
    private val profileItemClickListener: ProfileClickListener,
) : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    inner class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView = itemView.findViewById(R.id.img_profile_image)
        val profileText: TextView = itemView.findViewById(R.id.txt_profile_name)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = profileList[position]
                    profileItemClickListener.profileItemClick(item.name, item.image,profileText, profileImage)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val v: View =
             LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return ProfileViewHolder(v)
    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.profileImage.setImageResource(profileList[position].image)
        holder.profileText.text = profileList[position].name
    }
}