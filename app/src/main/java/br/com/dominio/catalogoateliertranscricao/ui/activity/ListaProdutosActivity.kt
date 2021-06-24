package br.com.dominio.catalogoateliertranscricao.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.dominio.catalogoateliertranscricao.R
import br.com.dominio.catalogoateliertranscricao.dao.ProdutosDao
import br.com.dominio.catalogoateliertranscricao.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {

    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(
        context = this,
        produtos = dao.buscaTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(
            this,
            "Bem vindo(a) ao Atelier Graça Lima!",
            Toast.LENGTH_SHORT
        ).show()

        configuraRecyclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualizaLista(dao.buscaTodos())

    }

    private fun configuraFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_lista_produto_fab)
        fab.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configuraRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_lista_produto_reciclerview)
        Log.i("ListaProdutosActivity", "onCreate: ${dao.buscaTodos()}")
        recyclerView.adapter = adapter
    }
}