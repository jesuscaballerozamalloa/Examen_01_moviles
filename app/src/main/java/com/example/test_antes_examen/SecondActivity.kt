package com.example.test_antes_examen

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.examenFinal)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val message = intent.getStringExtra("EXTRA_MESSAGE")

        val numeroRecibido: Double? = message?.toDoubleOrNull()
        //val numeroRecibido = intent.getIntExtra("EXTRA_MESSAGE", 0)

        // Validar si el número es mayor que 11
        println("Numero  $numeroRecibido RECIBIDOOOOOO ")
        if (numeroRecibido != null) {
        if (numeroRecibido >= 11) {
            // El número es mayor que 11
            val textView2 = findViewById<TextView>(R.id.textView2).apply {
                text = "aprobado"

            }
            textView2.setTextColor(Color.BLUE)
        } else {
            // El número no es mayor que 11
            val textView2 = findViewById<TextView>(R.id.textView2).apply {
                text = "desaaprobado"

            }
            textView2.setTextColor(Color.BLUE)
        }}else{
            val textView2 = findViewById<TextView>(R.id.textView2).apply {
                text = "numero nulo"

            }
        }


        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message

        }


    }
}