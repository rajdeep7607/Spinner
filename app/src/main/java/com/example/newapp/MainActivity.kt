package com.example.newapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val countries = resources.getStringArray(R.array.country)
        val sp_sel_country = findViewById<Spinner>(R.id.sel_country)


        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp_sel_country.adapter = adapter

        sp_sel_country.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity, "You are from: ${countries[position]}", Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing or provide a default action
            }
        }

        val regions = arrayOf("Select Region", "ODISHA", "KOLKATA", "DELHI", "MUMBAI")
        val sp_region = findViewById<Spinner>(R.id.spinner)

        val adapter_reg = ArrayAdapter(this, android.R.layout.simple_spinner_item, regions)
        adapter_reg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp_region.adapter = adapter_reg

        sp_region.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "You selected: ${regions[position]}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

//        Autocommplete
        val at_search = findViewById<AutoCompleteTextView>(R.id.atv_Search)
        val adapter3 =ArrayAdapter(this , android.R.layout.simple_list_item_1, countries)
        at_search.setAdapter(adapter3)

//        jabsnkjfdnasgit add .
//git commit -m "Initial commit"
        val button = findViewById<View>(R.id.submit_btn)
        button.setOnClickListener{
            Toast.makeText(this@MainActivity, "You are searching for "+at_search.text , Toast.LENGTH_SHORT).show()
        }

    }
}
