package ExerciciosArquivos

import java.io.File
import java.io.IOException

fun lerArquivoDeTexto (nomeArquivo: String): String?{
    val arquivo = File(nomeArquivo)

    if(!arquivo.exists()){
        println("Arquivo ${arquivo.absolutePath} não foi encontrado")
        return null
    }

    return try{
        arquivo.readText()
    }catch (e: IOException){
        println("Erro ao ler o arquivo: ${e.message}")
        null
    }
}

fun processarTextoDoArquivo(texto: String?): List<String>{
    if (texto == null) {
        return emptyList()
    }

    // 1. Converte para minúsculas
    val textoMinusculo = texto.lowercase()

    // 2. Remove pontuações e substitui por espaços
    val textoSemPontuacao = textoMinusculo.replace(Regex("[\\p{Punct}]"), " ")

    // 3. Divide o texto em palavras e remove entradas vazias
    val palavras = textoSemPontuacao.split(Regex("\\s+")).filter { it.isNotBlank() }

    return palavras
}

fun contarFrequenciaDePalavras(palavras: List<String>): Map<String, Int> {
    // Agrupa as palavras e conta a ocorrência de cada uma a partir do índice
    return palavras.groupingBy { it }.eachCount()
}

fun main(){
    val arquivoTeste = "texto_usuario.txt"

    val conteudo = lerArquivoDeTexto(arquivoTeste)

    val palavras = processarTextoDoArquivo(conteudo)

    val frequencia = contarFrequenciaDePalavras(palavras)

    println("Contagem de frequência de palavras:")
    frequencia.forEach { (palavra, contagem) ->
        println("'$palavra': $contagem")
    }
}