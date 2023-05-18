package com.example.recyclerviewespresso

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewespresso.databinding.ItemPessoaBinding

class PessoaAdapter(val pessoas: List<Pessoa>) : RecyclerView.Adapter<PessoaAdapter.PessoaViewHolder>(){

    inner class PessoaViewHolder(binding: ItemPessoaBinding): RecyclerView.ViewHolder(binding.root){
        val tvNome = binding.tvNome
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        val binding = ItemPessoaBinding.inflate(LayoutInflater.from(parent.context))
        binding.root.setOnClickListener {
            binding.tvNome.text = binding.tvNome.text.toString().reversed()
        }
        return PessoaViewHolder(binding)
    }

    override fun getItemCount() = pessoas.size

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        holder.tvNome.text = "$position - ${pessoas[position].nome}"
    }

}