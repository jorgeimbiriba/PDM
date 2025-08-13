package ExeciciosComplementares

import java.awt.List

class Televisores(val marca: String, val modelo: String,val tipo: String, val preco: Double)

class Empregado(val nome: String, val vendas: List <Televisores>, val salario: Double, val inss: Double, val salarioMinino: Double = 1516.60){

    fun calcularComissao() : Double{
        val vendasPorTipo = vendas.groupBy {it.tipo}

        val comissaoTotal = 0.0

        val vendasCor = vendasPorTipo["A cores"] ?: emptyList()
        if (vendasCor.isNotEmpty()){
            val totalPreco = vendasCor.sumOf {it.preco}
            val porcentagemComissao = if(vendasCor.size >= 10) 0.14 else 0.13
            comissaoTotal += totalPreco * porcentagemComissao
        }

        val vendasPB = vendasPorTipo["Preto e branco"] ?: emptyList()
        if (vendasPB.isNotEmpty()) {
            val totalPreco = vendasPB.sumOf { it.preco }
            val porcentagemComissao = if (vendasPB.size >= 20) 0.13 else 0.12
            comissaoTotal += totalPreco * porcentagemComissao
        }

        return comissaoTotal
    }

    fun salarioTotal(): Double{
        val comissao = calcularComissao()
        return salarioMinino + comissao - inss
    }
}

