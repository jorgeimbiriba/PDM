package ExerciciosArquivos

import java.io.File
import java.io.IOException

fun entradaViaTerminal(): List<String>{
    val linhasDeTexto = mutableListOf<String>()
    println("Digite seu texto. Ao terminar, digite 'fim' em uma nova linha")

    var linha: String?
    do {
        print("-> ")
        linha = readLine()
        if (linha != null && linha.lowercase() != "fim") {
            linhasDeTexto.add(linha)
        }
    } while (linha != null && linha.lowercase() != "fim")

    return linhasDeTexto
}

fun salvarTextoEmArquivo(nomeArquivo: String, linhas: List<String>){
    val arquivo = File(nomeArquivo)

    try {
        val textoEmLinhas = linhas.joinToString(separator = "\n") //quebra de linhas
        arquivo.writeText(textoEmLinhas)

        println("Texto salvo em ${arquivo.absolutePath}")
    }catch (e: IOException){
        println("Erro ao salvar o arquivo: ${e.message}")
    }
}

fun lerTextoNoArquivo(nomeArquivo: String): List<String>?{
    val arquivo = File(nomeArquivo)

    if(!arquivo.exists()){
        println("O arquivo $nomeArquivo não existe")
        return null
    }
    return try {
        arquivo.readLines()
    }catch (e: IOException){
        println("Erro ao exibir o arquivo: ${e.message}")
        null
    }
}


fun main(){
    val arquivo = "texto_usuario.txt"

    // 1. Coletar o texto do usuário
    val linhasDoUsuario = entradaViaTerminal()

    // 2. Salvar o texto no arquivo
    salvarTextoEmArquivo(arquivo, linhasDoUsuario)

    // 4. Ler e exibir o conteúdo do arquivo
    val linhasLidas = lerTextoNoArquivo(arquivo)
    if (linhasLidas != null) {
        println("\nConteúdo do arquivo lido:")
        linhasLidas.forEachIndexed { index, s ->
            println("${index + 1}: $s")
        }
    }
}