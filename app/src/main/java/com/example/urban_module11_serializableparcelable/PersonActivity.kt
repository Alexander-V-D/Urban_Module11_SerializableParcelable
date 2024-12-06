package com.example.urban_module11_serializableparcelable

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PersonActivity : AppCompatActivity() {

    private lateinit var personTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)
        val person = intent.extras?.getParcelable<Person>(Person::class.java.simpleName)

        personTV = findViewById(R.id.personTV)

        val name = person?.name.toString()
        val surname = person?.surname.toString()
        val address = person?.address.toString()
        val telephone = person?.telephone.toString()

        personTV.text = getString(R.string.person_card_text, name, surname, address, telephone)
    }
}