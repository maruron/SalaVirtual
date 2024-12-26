package com.example.psalavirtual

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlunoAdapter (
    private val alunos: List<Aluno>,
    private val onItemClick: (Aluno) -> Unit
) : RecyclerView.Adapter<AlunoAdapter.AlunoViewHolder>() {

    class AlunoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nomeTextView: TextView = view.findViewById(R.id.textNome)
        val idadeTextView: TextView = view.findViewById(R.id.textIdade)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_aluno, parent, false)
        return AlunoViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        val aluno = alunos[position]
        holder.nomeTextView.text = aluno.nome
        holder.idadeTextView.text = "Idade: ${aluno.idade}"


        holder.itemView.setOnClickListener {
            onItemClick(aluno)
        }
    }

    override fun getItemCount(): Int = alunos.size
}