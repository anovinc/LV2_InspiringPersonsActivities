package com.example.inspiringpersons

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inspiringpersons.databinding.ActivityInspiringPersonsListBinding

class InspiringPersonsListActivity : AppCompatActivity() {

    private lateinit var inspiringPersonsBinding : ActivityInspiringPersonsListBinding
    private var adapter = InspiringPersonsAdapter()

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


    }


}
