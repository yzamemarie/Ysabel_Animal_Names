package com.colina.animal.names

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.colina.animal.names.databinding.ActivityAnimalNamesBinding

class AnimalNamesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimalNamesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalNamesBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}