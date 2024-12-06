package com.example.urban_module11_serializableparcelable

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nameET: EditText
    private lateinit var surnameET: EditText
    private lateinit var addressET: EditText
    private lateinit var telephoneET: EditText

    private lateinit var saveBTN: Button

    private lateinit var personsLV: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameET = findViewById(R.id.nameET)
        surnameET = findViewById(R.id.surnameET)
        addressET = findViewById(R.id.addressET)
        telephoneET = findViewById(R.id.telephoneET)

        saveBTN = findViewById(R.id.saveBTN)

        personsLV = findViewById(R.id.personsLV)

        val persons = mutableListOf<Person>()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, persons)
        personsLV.adapter = adapter

        saveBTN.setOnClickListener {
            persons.add(
                Person(
                    nameET.text.toString(),
                    surnameET.text.toString(),
                    addressET.text.toString(),
                    telephoneET.text.toString()
                )
            )
            adapter.notifyDataSetChanged()
            nameET.text.clear()
            surnameET.text.clear()
            addressET.text.clear()
            telephoneET.text.clear()
        }
        personsLV.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, position, id ->
                val person = adapter.getItem(position)
                val intent = Intent(this, PersonActivity::class.java)
                intent.putExtra(Person::class.java.simpleName, person)
                startActivity(intent)
            }
    }
}