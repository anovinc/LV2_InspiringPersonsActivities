package com.example.inspiringpersons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.inspiringpersons.databinding.ActivityNewInspiringPersonBinding
import kotlinx.android.synthetic.main.activity_new_inspiring_person.*

class NewInspiringPersonActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNewInspiringPersonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityNewInspiringPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btSaveNewInspiringPerson.setOnClickListener { saveNewInspiringPerson() }
    }


    private fun createInspiringPerson(): InspiringPerson? {
        val personName = et_new_inspiring_person_name.text.toString()
        val personLifetime = et_new_inspiring_person_lifetime.text.toString()
        val personDetails = et_new_inspiring_person_details.text.toString()
        val personPhoto = et_new_inspiring_person_picture.text.toString()
        val personQuotes = listOf(et_new_inspiring_person_quote1.text.toString(),et_new_inspiring_person_quote2.text.toString(),et_new_inspiring_person_quote3.text.toString())

        var newInspiringPerson:InspiringPerson? = null
        if(personName.isEmpty() || personLifetime.isEmpty() || personDetails.isEmpty() || personPhoto.isEmpty() || personQuotes.size!=3){
            return newInspiringPerson

        }
        else{

            return InspiringPerson(personName,personPhoto,personLifetime,personDetails,personQuotes)

            }
    }



    private fun startInspiringPersonsList(){
        val intent=Intent(this,InspiringPersonsListActivity::class.java).apply {  }
        startActivity(intent)
        finish()
    }

    private fun saveNewInspiringPerson() {
        val newInspiringPerson = createInspiringPerson()


        if (newInspiringPerson != null) {
            InspiringPersonsRepository.insert(newInspiringPerson)
            startInspiringPersonsList()
            Toast.makeText(this, "Successfully saved!", Toast.LENGTH_SHORT).show()
        }

        else{
            Toast.makeText(this,"You have to enter all information.",Toast.LENGTH_SHORT).show()
        }



    }
}
