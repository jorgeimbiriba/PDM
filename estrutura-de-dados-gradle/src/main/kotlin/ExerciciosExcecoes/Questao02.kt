package ExerciciosExcecoes

import java.lang.IllegalArgumentException

fun calcularMedia(notas: List<Int>){
    if (notas.isEmpty()) {
        println("Não há notas para calcular a média")

    }
    val soma = notas.sum()
    val quantidadeDeNotas = notas.size

    try {
        val media = soma.toDouble() / quantidadeDeNotas
        println("As notas são: $notas")
        println("A média das notas é: $media")

    } catch (e: IllegalArgumentException){
        println("Erro: ${e.message}")
    }
}

fun main(){
    val minhasNotas = listOf(8, 7, 9, 10, 6, 8)
    calcularMedia(minhasNotas)

    val listaVazia = emptyList<Int>()
    calcularMedia(listaVazia)
}