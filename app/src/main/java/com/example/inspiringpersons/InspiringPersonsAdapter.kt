package com.example.inspiringpersons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.inspiringpersons.databinding.ItemInspiringPersonBinding

class InspiringPersonsAdapter : RecyclerView.Adapter<PersonsViewHolder>() {
    private val  inspiringPersons: MutableList<InspiringPerson> = mutableListOf()
    init{
        update(inspiringPersons)
    }

     fun update(inspiringPersons : List<InspiringPerson>) {
        this.inspiringPersons.clear()
        this.inspiringPersons.addAll(inspiringPersons)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonsViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val itemInspiringPersonBinding=ItemInspiringPersonBinding.inflate(inflater)
        return PersonsViewHolder(itemInspiringPersonBinding)
    }

    override fun onBindViewHolder(holder: PersonsViewHolder, position: Int) {
        val person = inspiringPersons[position]
        holder.bind(person)
        }


    override fun getItemCount(): Int {
        return inspiringPersons.size
    }

}