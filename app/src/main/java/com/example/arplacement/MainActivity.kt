package com.example.arplacement

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.arplacement.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val drills = listOf("Drill 1", "Drill 2", "Drill 3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, drills)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter

        binding.btnDetails.setOnClickListener {
            val selectedDrill = binding.spinner.selectedItem.toString()
            val intent = Intent(this, DrillDetailsActivity::class.java)
            intent.putExtra("drill", selectedDrill)
            startActivity(intent)
        }
    }
}

