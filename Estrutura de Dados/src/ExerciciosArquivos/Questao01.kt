package ExerciciosArquivos

import java.io.File
import java.io.IOException

fun salvarTarefasEmArquivo(tarefas: List<String>){
    val arquivo = File("tarefas.txt")
    //Tratamento com try catch
    try {
        val textoParaSalvar = tarefas.joinToString(separator ="\n" )

        arquivo.writeText(textoParaSalvar)
        println("Tarefas foram salvas com sucesso!")
    }catch (e: IOException){
        println("Erro ao salvar o arquivo: ${e.message}")
    }
}

fun exibirTarefas(){
    val arquivo = File("tarefas.txt")

    if (!arquivo.exists()) {
        println("O arquivo 'tarefas.txt' não foi encontrado.")
        return
    }

    try {
        println("--- Lista de Tarefas ---")
        val tarefas = arquivo.readLines()
        if (tarefas.isEmpty()) {
            println("O arquivo está vazio.")
        } else {
            tarefas.forEachIndexed { index, tarefa ->
                // O forEachIndexed fornece o índice e o valor - útil dms
                println("${index + 1}. $tarefa")
            }
        }
    } catch (e: IOException) {
        println("Erro ao ler o arquivo: ${e.message}")
    }
}

fun adicionarTarefaNoArquivo(novaTarefa: String){
    val arquivo = File("tarefas.txt")

    try {
        arquivo.appendText("\n$novaTarefa")
        println("Tarefa '$novaTarefa' adicionada com sucesso")
    }catch (e: IOException){
        println("Erro ao adicionar a tarefa: ${e.message}")
    }
}

fun main(){
    val tarefas = listOf("Estudar Kotlin", "Fazer a Lista")
    File("tarefas.txt").writeText(tarefas.joinToString (separator = "\n"))

    exibirTarefas()

    adicionarTarefaNoArquivo("Adicionar ao Github")

    exibirTarefas()
}