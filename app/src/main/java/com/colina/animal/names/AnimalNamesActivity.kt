package com.colina.animal.names

import adapters.AnimalAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import com.colina.animal.names.databinding.ActivityAnimalNamesBinding
import data_models.AnimalDetails

class AnimalNamesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimalNamesBinding
    private val animalList: List<AnimalDetails> = AnimalDetails.getAnimalList() //gets animal list from animal details

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalNamesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Animal names from A to Z"

        val adapter = AnimalAdapter(animalList)
        binding.animalListView.adapter = adapter

        binding.animalListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selected = animalList[position]
            startActivity(
                Intent(this, AnimalDetailsActivity::class.java).apply {
                    putExtra("animalDetails", selected)
                }
            )
        }

        binding.manageButton.setOnClickListener {
            val intent = Intent(this, ManageBlockActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}