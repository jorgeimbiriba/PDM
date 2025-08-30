package ExerciciosArquivos

import java.io.File

fun verificarParaCriarDiretorio(caminho: String): File{
    val diretorio = File(caminho)

    if(!diretorio.exists()){
        val criado = diretorio.mkdirs()
        if (criado) {
            println("Diretório criado com sucesso: ${diretorio.absolutePath}")
        } else {
            println("Falha ao criar o diretório: ${diretorio.absolutePath}")
        }
    } else {
        println("O diretório já existe: ${diretorio.absolutePath}")
    }
    return diretorio
}

fun listarSubduretorios(diretorio: File){
    println("\nListando subdiretórios de '${diretorio.name}':")
    val subdiretorios = diretorio.listFiles()?.filter { it.isDirectory }

    if (subdiretorios.isNullOrEmpty()) {
        println("Nenhum subdiretório encontrado.")
    } else {
        subdiretorios.forEach { subdiretorio ->
            println("  - ${subdiretorio.name}")
        }
    }
}

fun criarArquivoParaDiretorio(diretorio: File, nomeArquivo: String){
    val arquivo = File(diretorio, nomeArquivo)

    try {
        if (arquivo.createNewFile()){
            println("Arquivo $nomeArquivo criado com sucesso em ${diretorio.absolutePath}")
        }else {
            println("Arquivo $nomeArquivo já existe")
        }
    }catch (e: Exception){
        println("Erro ao criar o arquivo ${e.message}")
    }
}

fun excluirDiretorios(diretorio: File){
    if (diretorio.exists()){
        if (diretorio.deleteRecursively()){
            println("Diretório ${diretorio.name} excluído")
        }else {
            println("Falha ao excluir o diretório '${diretorio.name}'.")
        }
    } else {
        println("O diretório '${diretorio.name}' não existe.")
    }
}
fun main(){
    //1. Criação direta do caminho de diretórios
    val estruturaDeDiretorios = verificarParaCriarDiretorio("backup/fotos/documentos")
    listarSubduretorios(estruturaDeDiretorios)

    //2. Adiciona o arquivo no diretório
    val arquivoTxt = criarArquivoParaDiretorio(estruturaDeDiretorios,"notas.txt")
    
}


