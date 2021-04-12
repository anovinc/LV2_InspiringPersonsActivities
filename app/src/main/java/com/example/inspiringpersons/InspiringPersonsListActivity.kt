package com.example.inspiringpersons

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inspiringpersons.databinding.ActivityInspiringPersonsListBinding
import java.io.Console

class InspiringPersonsListActivity : AppCompatActivity() {

    private lateinit var inspiringPersonsBinding : ActivityInspiringPersonsListBinding
    private var adapter = InspiringPersonsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inspiringPersonsBinding = ActivityInspiringPersonsListBinding.inflate(layoutInflater)
        setContentView(inspiringPersonsBinding.root)
        setupRecycler()
        addNewPerson()


    }


    private fun setupRecycler() {
        inspiringPersonsBinding.rvInspiringPersons.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        inspiringPersonsBinding.rvInspiringPersons.adapter=adapter
        adapter.update(InspiringPersonsRepository.getInspiringPersons())

    }

    private fun addNewPerson(){
        inspiringPersonsBinding.btnNewInspiringPerson.setOnClickListener{
            val intent=Intent(this,NewInspiringPersonActivity::class.java).apply {  }
            startActivity(intent)
        }
    }




}
