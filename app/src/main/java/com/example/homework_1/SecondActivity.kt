package com.example.homework_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val text = intent.getStringExtra(MainActivity.KEY)
        binding.editTextInAsM.setText(text)
        binding.btnSend.setOnClickListener {
        transitionAnotherActivity()
        }

    }
    private fun transitionAnotherActivity() {
            if (binding.editTextInAsM.text.toString().isEmpty()) {
                Toast.makeText(this, "Введите что-нибудь!", Toast.LENGTH_SHORT).show()
            } else {
                val data = Intent()
                data.putExtra(MainActivity.KEY,binding.editTextInAsM.text.toString())
                setResult(Activity.RESULT_OK,data)
                finish()
            }
    }
}