package com.example.inspiringpersons

import android.view.View
import com.squareup.picasso.Picasso
import androidx.recyclerview.widget.RecyclerView
import com.example.inspiringpersons.InspiringPerson
import com.example.inspiringpersons.databinding.ItemInspiringPersonBinding

class PersonsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    fun bind(inspiringPerson: InspiringPerson){
        val itemBinding= ItemInspiringPersonBinding.bind(itemView)
        itemBinding.tvNameInspiringPerson.text=inspiringPerson.name
        itemBinding.tvLifetimeInspiringPerson.text=inspiringPerson.lifetime
        itemBinding.tvDetailsInspiringPerson.text=inspiringPerson.details

        Picasso.get()
            .load(inspiringPerson.picture)
            .fit()
            .into(itemBinding.ivInspiringPerson)
    }
}