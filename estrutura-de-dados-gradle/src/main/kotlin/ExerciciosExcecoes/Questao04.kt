package ExerciciosExcecoes

import java.io.File

fun lerDadosDoArquivo(caminho: String): Map<String, String>? {
    return runCatching {
        File(caminho).readLines()
            .map { linha ->
                val (chave, valor) = linha.split(":", limit = 2)
                chave to valor
            }
            .toMap()
    }.getOrNull() // retorna null caso haja qualquer exceção
}

fun main() {
    // Caminho válido (ajuste para o local correto do seu arquivo)
    val caminhoValido = "dados.txt"
    val resultadoValido = lerDadosDoArquivo(caminhoValido)
    println("Resultado com caminho válido: $resultadoValido")

    // Caminho inválido
    val caminhoInvalido = "qualquer.txt"
    val resultadoInvalido = lerDadosDoArquivo(caminhoInvalido)
    println("Resultado com caminho inválido: $resultadoInvalido")
}
