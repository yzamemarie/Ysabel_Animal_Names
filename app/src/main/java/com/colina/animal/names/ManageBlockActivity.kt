package com.colina.animal.names

import adapters.BlockedAnimalAdapter
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.colina.animal.names.databinding.ActivityManageBlockBinding
import data_models.AnimalDetails

class ManageBlockActivity : AppCompatActivity(), BlockedAnimalAdapter.UnblockClickListener {
    private lateinit var binding: ActivityManageBlockBinding
    private val blockedListMap = mutableListOf<AnimalDetails>()
    private val animalList: List<AnimalDetails> = AnimalDetails.getAnimalList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManageBlockBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initialize blocked animals from shared preferences
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val blockedSet = sharedPreferences.getStringSet("blockedAnimals", setOf())!!

        //populate list of blocked animals
        for (animalName in blockedSet) {
            val animalDetails = getAnimal(animalName, animalList)
            if (animalDetails != null) {
                blockedListMap.add(animalDetails)
            }
        }

        val adapter = BlockedAnimalAdapter(blockedListMap, this)
        binding.blockedListView.adapter = adapter
    }

    private fun getAnimal(animalName: String, animalList: List<AnimalDetails>): AnimalDetails? {
        for (animal in animalList) {
            if (animal.animalName == animalName) {
                return animal
            }
        }
        return null
    }

    override fun onUnblockClick(animal: AnimalDetails) {
        val shared = PreferenceManager.getDefaultSharedPreferences(this)
        val blockedAnimals = HashSet(shared.getStringSet("blockedAnimals", emptySet()))

        if (blockedAnimals.contains(animal.animalName)) {
            blockedAnimals.remove(animal.animalName) //removes animal from blockedAnimals set
            shared.edit().putStringSet("blockedAnimals", blockedAnimals).apply() //updates shared preferences

            AnimalDetails.addAnimal(animal) //adds animal back to the animal list
            blockedListMap.remove(animal) //removes from block list
            (binding.blockedListView.adapter as BlockedAnimalAdapter).notifyDataSetChanged()

            Toast.makeText(this, "${animal.animalName} unblocked!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, AnimalNamesActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Error: Animal not found!", Toast.LENGTH_SHORT).show()
        }
    }

}