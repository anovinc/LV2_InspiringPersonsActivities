package com.example.inspiringpersons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class InspiringPersonsAdapter(inspiringPerson: List<InspiringPerson>) : RecyclerView.Adapter<PersonsViewHolder>() {
    private val  inspiringPersons: MutableList<InspiringPerson> = mutableListOf()
    init{
        update(inspiringPersons)
    }

    private fun update(inspiringPersons : List<InspiringPerson>) {
        this.inspiringPersons.clear()
        this.inspiringPersons.addAll(inspiringPersons)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_inspiring_person, parent, false)
        return PersonsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonsViewHolder, position: Int) {
        val person = inspiringPersons[position]
        holder.bind(person)
        }


    override fun getItemCount(): Int {
        return inspiringPersons.size
    }

}