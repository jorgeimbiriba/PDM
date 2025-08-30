package ExerciciosArquivos

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

fun escreverArquivoBinario(caminhoArquivo: String, dados: ByteArray){
    try {
        FileOutputStream(caminhoArquivo).use{ outputStream ->
            outputStream.write(dados)
        }
        println("Dados escritos com sucesso em ${caminhoArquivo}")
    }catch (e: Exception){
        println("Erro ao escrever no arquivo binário ${e.message}")
    }
}

fun lerArquivoBinario(caminhoArquivo: String){
    try {
        val arquivo = File(caminhoArquivo)
        val tamanho = arquivo.length().toInt()
        val dados = ByteArray(tamanho)

        FileInputStream(arquivo).use{inputStream ->
            inputStream.read(dados)
        }
        println("Arquivo Lido com sucesso!")
    }catch (e: Exception){
        println("Erro ao ler o arquivo binário: ${e.message}")
    }
}

fun main(){
    val dadosParaArray = byteArrayOf(0x4B, 0x4F, 0x54, 0x4C, 0x4E)
    escreverArquivoBinario("app.dat",dadosParaArray)

    lerArquivoBinario("app.dat")
}