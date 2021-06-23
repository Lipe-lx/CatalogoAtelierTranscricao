package br.com.dominio.catalogoateliertranscricao.model

import java.math.BigDecimal

data class Produto(
    val nome: String,
    val colecao: String,
    val dimensao: String,
    val valor: BigDecimal

)