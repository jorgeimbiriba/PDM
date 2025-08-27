package ExeciciosComplementares
import kotlin.random.Random
import kotlin.math.roundToInt //Arredondamento

// --- Funções de extensão necessárias para geração randomica ---
private fun Double.pow(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result *= this
    }
    return result
}

fun Double.roundTo(numFractionDigits: Int): Double {
    val factor = 10.0.pow(numFractionDigits)
    return (this * factor).roundToInt() / factor
}

//Constantes para salvar
const val NOTA_MINIMA_APROVACAO = 60.0
const val AULAS_MINIMAS_PRESENCA = 40

class Aluno (val matricula: Int, val notas: List<Double>,val aulasPresentes: Int)
fun Aluno.calcularMedia(): Double {
    if (notas.isEmpty()) {
        return 0.0
    }
    return notas.average()
}

fun Aluno.verificarSituacao(): String{
    return if (this.calcularMedia() >= NOTA_MINIMA_APROVACAO && this.aulasPresentes >= AULAS_MINIMAS_PRESENCA) {
        "Aprovado"
    } else {
        "Reprovado"
    }
}

fun Aluno.reprovadoPorInfrequencia(): Boolean {
    return this.aulasPresentes < AULAS_MINIMAS_PRESENCA
}

fun Aluno.reprovadoPorNota(): Boolean {
    return this.calcularMedia() < NOTA_MINIMA_APROVACAO
}

fun main(){
    // a) Geração de 100 alunos com dados aleatórios para simular a entrada
    val listaDeAlunos = (1..100).map { matricula ->
        val notas = (1..3).map {
            Random.nextDouble(0.0, 100.0).roundTo(2)
        }
        val aulasPresentes = Random.nextInt(20, 60)
        Aluno(matricula, notas, aulasPresentes)
    }

    // b) e c) Processamento da lista de alunos
    println("--- Resultados Individuais dos Alunos ---")
    println("Matrícula | Frequência | Nota Final | Situação")
    println("-------------------------------------------------")


    val notasFinais = mutableListOf<Double>()

    // Contadores e listas para os cálculos
    var totalAlunosReprovados = 0
    var alunosReprovadosPorInfrequencia = 0

    listaDeAlunos.forEach { aluno ->
        val notaFinal = aluno.calcularMedia()
        val situacao = aluno.verificarSituacao()

        notasFinais.add(notaFinal)

        if (situacao == "Reprovado") {
            totalAlunosReprovados++
            if (aluno.reprovadoPorInfrequencia()) {
                alunosReprovadosPorInfrequencia++
            }
        }

        println("${aluno.matricula.toString().padEnd(9)}| ${aluno.aulasPresentes.toString().padEnd(11)}| ${"%.2f".format(notaFinal).padEnd(10)}| $situacao")
    }

    // --- Exibindo os Resultados Coletivos ---
    println("\n--- Resumo Geral da Turma ---")
    println("Número de alunos processados: 100")
    println("Nota mínima para aprovação: $NOTA_MINIMA_APROVACAO")
    println("Presença mínima para aprovação: $AULAS_MINIMAS_PRESENCA aulas\n")

    // ii. Maior e menor nota da turma
    val maiorNota = notasFinais.maxOrNull() ?: 0.0
    val menorNota = notasFinais.minOrNull() ?: 0.0
    println("Maior nota da turma: %.2f".format(maiorNota))
    println("Menor nota da turma: %.2f".format(menorNota))

    // iii. Nota média da turma
    val notaMediaDaTurma = notasFinais.average()
    println("Nota média da turma: %.2f".format(notaMediaDaTurma))

    // iv. Total de alunos reprovados
    println("Total de alunos reprovados: $totalAlunosReprovados")

    // v. Porcentagem de alunos reprovados por infrequência
    val porcentagemReprovadosPorInfrequencia = (alunosReprovadosPorInfrequencia.toDouble() / 100) * 100
    println("Porcentagem de alunos reprovados por infrequência: %.2f%%".format(porcentagemReprovadosPorInfrequencia))
}

