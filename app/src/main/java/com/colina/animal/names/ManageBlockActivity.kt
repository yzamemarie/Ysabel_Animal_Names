package com.colina.animal.names

import adapters.BlockedAnimalAdapter
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.colina.animal.names.databinding.ActivityManageBlockBinding
import data_models.AnimalDetails

class ManageBlockActivity : AppCompatActivity() {
    private lateinit var binding: ActivityManageBlockBinding
    private val blockedListMap = mutableListOf<AnimalDetails>()
    private val animalList: List<AnimalDetails> = AnimalDetails.getAnimalList() //gets animal list from animal details


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManageBlockBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // initialize list of blocked animals from shared preferences
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

    //get animal name from animal details
    private fun getAnimal(animalName: String, animalList: List<AnimalDetails>): AnimalDetails? {
        for (animal in animalList) {
            if (animal.animalName == animalName) {
                return animal
            }
        }
        // Return a default AnimalDetails object when no match is found
        return AnimalDetails("Unicorn", "Animal does not exist like the Unicorn!")
    }
}
