package com.example.arplacement

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.arplacement.databinding.ActivityDrillDetailsBinding

class DrillDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDrillDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrillDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val drill = intent.getStringExtra("drill") ?: "Drill 1"
        binding.title.text = drill

        when (drill) {
            "Drill 1" -> {
                binding.description.text = "Drill 1: Basic placement drill. Ideal for beginners."
                binding.tips.text = "Tip: Align with flat ground for stable placement."
                binding.image.setImageResource(R.drawable.drill1)
            }
            "Drill 2" -> {
                binding.description.text = "Drill 2: Intermediate level with angled placement."
                binding.tips.text = "Tip: Use at a 45° angle to simulate wall drills."
                binding.image.setImageResource(R.drawable.drill1)
            }
            "Drill 3" -> {
                binding.description.text = "Drill 3: Advanced drill marker for high precision."
                binding.tips.text = "Tip: Use measuring tools before placing."
                binding.image.setImageResource(R.drawable.drill1)
            }
        }

        binding.startArBtn.setOnClickListener {
            val intent = Intent(this, ARActivity::class.java)
            intent.putExtra("drill", drill) // optional
            startActivity(intent)
        }
    }
}
