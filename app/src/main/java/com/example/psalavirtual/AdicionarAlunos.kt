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

class AdicionarAlunos : AppCompatActivity() {
    private val alunos = mutableListOf<Aluno>()
    private var totalAlunos: Int = 0
    private var contador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_adicionar_alunos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        getSupportActionBar()?.hide()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        totalAlunos = intent.getIntExtra("EXTRA_QUANTIDADE", 0)
        val nomeField = findViewById<EditText>(R.id.editNome)
        val idadeField = findViewById<EditText>(R.id.editIdade)
        val adicionarButton = findViewById<AppCompatButton>(R.id.btnAdicionar)

        adicionarButton.setOnClickListener {
            val nome = nomeField.text.toString()
            val idade = idadeField.text.toString().toIntOrNull()

            if (nome.isNotEmpty() && idade != null) {
                alunos.add(Aluno(nome, idade))
                contador++

                if (contador == totalAlunos) {
                    val intent = Intent(this, SelecionarAluno::class.java).apply {
                        putParcelableArrayListExtra("EXTRA_ALUNOS", ArrayList(alunos))
                    }
                    startActivity(intent)
                } else {
                    nomeField.text.clear()
                    idadeField.text.clear()
                }
            } else {
                Toast.makeText(this, "Preencha todos os campos corretamente!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}