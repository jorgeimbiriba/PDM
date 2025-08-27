package ExeciciosComplementares

class Televisores(val marca: String, val modelo: String,val tipo: String, val preco: Double)

class Empregado(val nome: String, val vendas: List<Televisores>, val inss: Double, val salarioMinino: Double = 1516.60){

    fun calcularComissao() : Double{
        val vendasPorTipo = vendas.groupBy {it.tipo}

        var comissaoTotal = 0.0

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

fun main(){

    val vendasDoMes = listOf(
    Televisores("Samsung", "QLED", "A cores",3200.0),
    Televisores("LG", "L-OLED", "A cores", 4500.0),
    Televisores("Samsung", "S-LED ", "A cores", 2500.0),
    Televisores("LG", "L-OLED ", "A cores", 4500.0),
    Televisores("Samsung", "S-LED ", "A cores", 2500.0),
    Televisores("LG", "L-OLED ", "A cores", 4500.0),
    Televisores("Samsung", "S-LED", "A cores", 2500.0),
    Televisores("LG", "L-OLED ", "A cores", 4500.0), // 10 televisores a cores
    Televisores("Philco", "P-PB", "Preto e branco", 800.0),
    Televisores("Philco", "P-PB", "Preto e branco", 800.0) // 2 televisores preto e branco
    )


    val empregado = Empregado("Jorge",vendas = vendasDoMes, inss = 100.0)

    val comissao = empregado.calcularComissao()
    val salarioFinal = empregado.salarioTotal()

    println("Nome: ${empregado.nome}")
    println("Comissão: R$ %.2f".format(comissao))
    println("Salário Final: R$ %.2f".format(salarioFinal))
}
