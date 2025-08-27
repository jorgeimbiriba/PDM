package ExemplosDaSala

import java.io.FileOutputStream

fun escreverArquivoBinario(caminhoArquivo: String, dados: ByteArray){
    try {
        FileOutputStream(caminhoArquivo).use{outputStream ->
            outputStream.write(dados)
        }
        println("Dados binários escritos com sucsso em $caminhoArquivo")
    }catch (e: Exception){
        println("Erro ao escrever no arquivo binário ${e.message}")
    }
}

fun main(){
    val dadosParaGravar = byteArrayOf(10,25,127,-50,100)
    escreverArquivoBinario("dados_aleatorios.bin", dadosParaGravar)
}
