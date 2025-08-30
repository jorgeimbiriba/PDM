package ExerciciosArquivos

import java.io.File

fun verificarParaCriarDiretorio(): File{
    val diretorioBackup = File("backup")

    val diretorioFotos = File(diretorioBackup,"fotos")
    val diretorioDocumentos = File(diretorioBackup,"documentos")

    if(diretorioFotos.mkdirs() && diretorioDocumentos.mkdirs()){
        println("Estrutura de diretórios criada com sucesso:")
        println("  -> ${diretorioFotos.absolutePath}")
        println("  -> ${diretorioDocumentos.absolutePath}")
    } else {
        println("A estrutura de diretórios já existe ou ocorreu erro")
    }
    return diretorioBackup
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
    val estruturaDeDiretorios = verificarParaCriarDiretorio()
    listarSubduretorios(estruturaDeDiretorios)

    //2. Adição do objeto File do diretório documentos
    val diretorioDocumentos = File(estruturaDeDiretorios, "documentos")

    // Cria o arquivo no diretório 'documentos' e remove a atribuição desnecessária
    criarArquivoParaDiretorio(diretorioDocumentos, "notas.txt")

    //3. Exluindo diretórios - ao descomentar funciona, eu garanto
    //excluirDiretorios(estruturaDeDiretorios)
}


