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
    private val inspiringPersons = InspiringPersonsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inspiringPersonsBinding = ActivityInspiringPersonsListBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_inspiring_persons_list)
        setupRecycler()


    }


    private fun setupRecycler() {
        inspiringPersonsBinding.rvInspiringPersons.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        inspiringPersonsBinding.rvInspiringPersons.adapter=InspiringPersonsAdapter(inspiringPersons.getInspiringPersons())
        inspiringPersons.insert(InspiringPerson("per","hghahga","111","gasa", listOf("aa","aa","asggsa")))
    }


}
