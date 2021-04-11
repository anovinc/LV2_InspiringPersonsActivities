package com.example.inspiringpersons

import android.view.View
import com.squareup.picasso.Picasso
import androidx.recyclerview.widget.RecyclerView
import com.example.inspiringpersons.InspiringPerson
import com.example.inspiringpersons.databinding.ItemInspiringPersonBinding

class PersonsViewHolder(private val binding: ItemInspiringPersonBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(inspiringPerson: InspiringPerson){
        binding.tvNameInspiringPerson.text=inspiringPerson.name
        binding.tvLifetimeInspiringPerson.text=inspiringPerson.lifetime
        binding.tvDetailsInspiringPerson.text=inspiringPerson.details

        Picasso.get()
            .load(inspiringPerson.picture)
            .fit()
            .into(binding.ivInspiringPerson)
    }
}