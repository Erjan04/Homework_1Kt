package com.example.homework_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK && result.data !=null) {
            val intent = result.data?.getStringExtra(KEY)
            binding.editTextInAcM.setText(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSend.setOnClickListener {
            transitionAnotherActivity()
        }
    }

    private fun transitionAnotherActivity() {
        if (binding.editTextInAcM.text.toString().isEmpty()) {
            Toast.makeText(this, "Введите что-нибудь!", Toast.LENGTH_SHORT).show()
        } else {
            val init = Intent(this,SecondActivity::class.java)
            init.putExtra(KEY,binding.editTextInAcM.text.toString())
            resultLauncher.launch(init)
        }
    }

    companion object {
        const val KEY = "key"
    }
}