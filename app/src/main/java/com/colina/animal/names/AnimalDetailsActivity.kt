package com.colina.animal.names

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import adapters.BlockedAnimalAdapter
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import data_models.AnimalDetails
import com.colina.animal.names.databinding.ActivityAnimalDetailsBinding

class AnimalDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimalDetailsBinding;
    private lateinit var shared: SharedPreferences
    private val blockedSet: MutableSet<String> = mutableSetOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animalDetails: AnimalDetails = intent.getParcelableExtra("animalDetails")!!

        binding.animalName.text = animalDetails.animalName
        binding.animalDesc.text = animalDetails.animalDesc

        if (animalDetails != null) {
            binding.animalName.text = animalDetails?.animalName
            binding.animalDesc.text = animalDetails?.animalDesc
            shared = PreferenceManager.getDefaultSharedPreferences(this)

            blockedSet.addAll(shared.getStringSet("blockedAnimals", setOf())!!) //get blocked animals from shared preferences

            binding.blockButton.setOnClickListener {
                blockedSet.add(animalDetails.animalName) //add animal to block list
                shared.edit().putStringSet("blockedAnimals", blockedSet).apply() //update shared preferences

                Toast.makeText(this, "This animal has been blocked!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, AnimalNamesActivity::class.java)
                startActivity(intent)
                finish()
            }
        } else {
            Toast.makeText(this, "Error: Animal is empty", Toast.LENGTH_SHORT).show()
        }
    }
}