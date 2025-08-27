package ExerciciosPropostos

data class Produto (val nome: String, val categoria: String, val preco: Double)

class SistemaInventario{
    private val estoque = mutableMapOf<String, Int>()
    private val produtos = mutableMapOf<String, Produto>()

    fun adicionarProduto(codigo: String, produto: Produto, quantidade: Int = 0){
        produtos[codigo] = produto
        estoque[codigo] = quantidade
    }

    fun atualizarEstoque(codigo: String, quantidade: Int) {
        if (codigo in produtos) {
            estoque[codigo] = quantidade
        }
    }

    fun venderProduto(codigo: String, quantidade: Int): Boolean{
        val estoqueAtual = estoque[codigo] ?: 0
        return if(estoqueAtual >= estoqueAtual - quantidade){
            estoque[codigo] = estoqueAtual - quantidade
            true
        }else{
            false
        }
    }

    fun produtosPorCategoria(categoria: String): Map<String, Produto>{
        return produtos.filter { it.value.categoria == categoria }
    }

    fun produtosEmBaixoEstoque(limite: Int = 5): List<String>{
        return estoque.filter { it.value <= limite }.keys.toList()
    }

    /*fun valorTotalEstoque(): Double{
        return estoque.entries.sumOf { (codigo, quantidade) ->
            val produto = produtos[codigo]
            if (produto != null) quantidade "" produto.preco else 0.0
        }
    }*/
}