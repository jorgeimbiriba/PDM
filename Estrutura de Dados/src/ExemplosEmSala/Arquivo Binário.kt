package ExemplosDaSala

import java.io.File
import java.io.FileInputStream

fun lerArquivoBinario(caminhoArquivo: String){
    try {
        val arquivo = File(caminhoArquivo)
        val tamanho = arquivo.length().toInt()
        val dados = ByteArray(tamanho)

        FileInputStream(arquivo).use { inputStream ->
            inputStream.read(dados)
        }
        println("Arquivo lido com sucesso ${dados.size} bytes lidos")

        println("Primeiros 10 bytes: ${dados.take(10).joinToString(","){
            it.toInt().toString()}}")
    }catch(e:Exception){
        println("Erro ao ler a mensagem ${e.message}")
    }
}