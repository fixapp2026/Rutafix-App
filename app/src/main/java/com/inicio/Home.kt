package com.inicio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.rutafix.Login
import com.example.rutafix.R
import com.example.rutafix.Registro

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home)
        
        val botonComienza = findViewById<Button>(R.id.BotonComienza)
        botonComienza?.setOnClickListener {
            val intent = Intent(this, Splash::class.java)
            startActivity(intent)
        }

        val textoRegistrate = findViewById<TextView>(R.id.textRegistrate)
        textoRegistrate?.setOnClickListener {
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }
    }
}