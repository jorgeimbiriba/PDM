package ExerciciosExcecoes

import java.io.IOException
import java.lang.NumberFormatException

fun lerIdade(){
    println("Por favor, digite a sua idade:")
    val inputIdade = readLine()

    try {
        val idade = inputIdade!!.toInt()
        println("Sua idade é: $idade anos.")

    }catch (e: IOException){
        println("Entrada de Dados inválida: ${e.message}")

    }catch (e: NumberFormatException){
        println("Erro: Nenhuma entrada foi fornecida.")
    }
}

fun main(){
    lerIdade()
}