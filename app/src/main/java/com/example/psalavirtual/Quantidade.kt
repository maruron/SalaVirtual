package com.example.psalavirtual

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Quantidade : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quantidade)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        getSupportActionBar()?.hide()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val quantidadeField = findViewById<EditText>(R.id.editQuantidade)
        val continuarButton = findViewById<AppCompatButton>(R.id.btnContinuar)

        continuarButton.setOnClickListener {
            val quantidadeText = quantidadeField.text.toString()
            val quantidade = quantidadeText.toIntOrNull()

            if (quantidade != null && quantidade > 0) {
                val intent = Intent(this, AdicionarAlunos::class.java).apply {
                    putExtra("EXTRA_QUANTIDADE", quantidade)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Informe uma quantidade válida!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}