package com.example.psalavirtual

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelecionarAluno : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_selecionar_aluno)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        getSupportActionBar()?.hide()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val alunos = intent.getParcelableArrayListExtra<Aluno>("EXTRA_ALUNOS") ?: emptyList()
        Log.d("SelecionarAluno", "Alunos recebidos: $alunos")

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewAlunos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AlunoAdapter(alunos) { alunoSelecionado ->
            val intent = Intent(this, Principal::class.java).apply {
                putExtra("EXTRA_NOME", alunoSelecionado.nome)
                putExtra("EXTRA_IDADE", alunoSelecionado.idade)
            }
            startActivity(intent)
        }
    }
}