package com.example.recyclerviewespresso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewespresso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {
        val lista = listOf(
            Pessoa("João"),
            Pessoa("Maria"),
            Pessoa("Carlos"),
            Pessoa("Juscelino"),
            Pessoa("Gabriela"),
            Pessoa("Aparecida")
        )

        val recyclerView = binding.rvNomes
        recyclerView.apply {
            adapter = PessoaAdapter(lista)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}