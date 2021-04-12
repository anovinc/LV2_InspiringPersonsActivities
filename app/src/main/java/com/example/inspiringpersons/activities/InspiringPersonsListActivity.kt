package com.example.inspiringpersons.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inspiringpersons.data.InspiringPersonsRepository
import com.example.inspiringpersons.adapters.InspiringPersonsAdapter
import com.example.inspiringpersons.databinding.ActivityInspiringPersonsListBinding
import com.example.inspiringpersons.listeners.OnInspiringPersonSelected
import com.example.inspiringpersons.model.InspiringPerson

class InspiringPersonsListActivity : AppCompatActivity() , OnInspiringPersonSelected{

    private lateinit var inspiringPersonsBinding : ActivityInspiringPersonsListBinding
    private lateinit var listener:OnInspiringPersonSelected
    private var adapter = InspiringPersonsAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inspiringPersonsBinding = ActivityInspiringPersonsListBinding.inflate(layoutInflater)
        setContentView(inspiringPersonsBinding.root)
        setupRecycler()

    }


    private fun setupRecycler() {
        inspiringPersonsBinding.rvInspiringPersons.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        inspiringPersonsBinding.rvInspiringPersons.adapter=adapter
        adapter.update(InspiringPersonsRepository.getInspiringPersons())
        addNewPerson()

    }

    private fun addNewPerson(){
        inspiringPersonsBinding.btnNewInspiringPerson.setOnClickListener{
            val intent=Intent(this, NewInspiringPersonActivity::class.java).apply {  }
            startActivity(intent)
        }
    }

    override fun OnInspiringPersonClicked(inspiringPerson: InspiringPerson) {
        var random="\""+inspiringPerson.quotes.random().toString()+"\" - "+inspiringPerson.name.toString()
        Toast.makeText(this,random,Toast.LENGTH_LONG).show()

    }


}
