package ExerciciosArquivos

import java.io.File
import java.io.IOException

data class Pessoa (val nome: String, val email: String, val idade: Int )

fun criarArquivoCSV(nomeArquivo: String, pessoa: Pessoa){
    val arquivo = File(nomeArquivo)

    try {
        if (!arquivo.exists()){
            arquivo.writeText("nome,email,idade\n")
        }

        val linhaCSV = "${pessoa.nome}, ${pessoa.email}, ${pessoa.idade}\n"

        arquivo.appendText(linhaCSV)

        println("'${pessoa.nome}' adicionado com sucesso ao arquivo '$nomeArquivo'.")
    }catch (e: IOException){
        println("Erro ao adicionar a pessoa: ${e.message}")
    }
}

fun main(){
    val arquivoNome = "dados_pessoais.csv"


    val pessoa1 = Pessoa("Ana", "ana@email.com", 25)
    criarArquivoCSV(arquivoNome, pessoa1)


    val pessoa2 = Pessoa("Carlos", "carlos@email.com", 30)
    criarArquivoCSV(arquivoNome, pessoa2)


    println("\nConteúdo do arquivo '$arquivoNome':")
    File(arquivoNome).readLines().forEach { println(it) }
}