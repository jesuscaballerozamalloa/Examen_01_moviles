package com.example.test_antes_examen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.examenFinal)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val secondActbutton = findViewById<Button>(R.id.ventana2)
        secondActbutton.setOnClickListener{
            //val Intent = Intent(this, SecondActivity::class.java)
            //startActivity(Intent)
            callActivity()
        }

    }

    private fun callActivity() {
        val editText = findViewById<EditText>(R.id.eParcial)
        val editText1 = findViewById<EditText>(R.id.eFinal)
        val editText2 = findViewById<EditText>(R.id.eEvaPromedio)

        // Obtener los valores ingresados en los EditText
        val valorParcial = editText.text.toString().toDoubleOrNull() ?: 0.0
        val valorFinal = editText1.text.toString().toDoubleOrNull() ?: 0.0
        val valorPromedio = editText2.text.toString().toDoubleOrNull() ?: 0.0
        val suma = valorParcial * 0.2 + valorFinal* 0.20 + valorPromedio * 0.60

        //editTextPromedio.setText(suma.toString())
        //val message = editText.text.toString()
        val message = suma.toString()

        val intent= Intent(this, SecondActivity::class.java).also {
            it.putExtra("EXTRA_MESSAGE",message)
            startActivity(it)
        }

    }
}