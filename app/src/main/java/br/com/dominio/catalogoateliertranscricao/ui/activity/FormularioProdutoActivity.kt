package br.com.dominio.catalogoateliertranscricao.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.dominio.catalogoateliertranscricao.R
import br.com.dominio.catalogoateliertranscricao.dao.ProdutosDao
import br.com.dominio.catalogoateliertranscricao.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_produto_botao_salvar)
        val dao = ProdutosDao()
        botaoSalvar.setOnClickListener {
            val produtoNovo = criaProduto()
            Log.i("FormularioProduto", "onCreate: $produtoNovo ")
            dao.adiciona(produtoNovo)
            Log.i("FormularioProduto", "onCreate: ${dao.buscaTodos()} ")
            finish()
        }
    }

    private fun criaProduto(): Produto {
        val campoNome = findViewById<EditText>(R.id.activitu_formulario_produto_nome)
        val nome = campoNome.text.toString()

        val campoColecao = findViewById<EditText>(R.id.activitu_formulario_produto_colecao)
        val colecao = campoColecao.text.toString()

        val campoDimensao = findViewById<EditText>(R.id.activitu_formulario_produto_dimensao)
        val dimensao = campoDimensao.text.toString()

        val campoValor = findViewById<EditText>(R.id.activitu_formulario_produto_valor)
        val valorEmTexto = campoValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Produto(
            nome = nome,
            colecao = colecao,
            dimensao = dimensao,
            valor = valor
        )
    }
}