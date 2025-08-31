package ExerciciosArquivos

import java.io.File
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun fazerBackup(pastaOrigem: File, pastaDestino: File): Boolean {
    if (!pastaOrigem.exists()) {
        println("Essa pasta não existe")
        return false
    }
    val formatoData = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")
    val nomePastaBackup = "backup_${LocalDateTime.now().format(formatoData)}"
    val pastaBackup = File(pastaDestino, nomePastaBackup)

    // Cria a nova pasta de backup
    if (!pastaBackup.mkdirs()) {
        println("Erro: Não foi possível criar a pasta de backup.")
        return false
    }

    try {
        // Copia cada arquivo da pasta de origem para a pasta de backup
        pastaOrigem.listFiles()?.forEach { arquivo ->
            if (arquivo.isFile) {
                // copyTo copia o arquivo para o novo destino. overwrite=true evita erros.
                arquivo.copyTo(File(pastaBackup, arquivo.name), overwrite = true)
            }
        }
        println("Backup realizado com sucesso para: ${pastaBackup.absolutePath}")
        return true
    } catch (e: IOException) {
        println("Erro ao copiar arquivos: ${e.message}")
        return false
    }
}

fun limparBackupsAntigos(pastaDestino: File) {
    if (!pastaDestino.exists() || !pastaDestino.isDirectory) {
        println("Erro: A pasta de destino não existe ou não é um diretório.")
        return
    }

    // Filtra para obter apenas as pastas de backup (que começam com "backup_")
    val pastasDeBackup = pastaDestino.listFiles()
        ?.filter { it.isDirectory && it.name.startsWith("backup_") }
        ?.sortedBy { it.lastModified() } // Ordena as pastas por data de modificação (mais antigas primeiro)

    if (pastasDeBackup == null || pastasDeBackup.size <= 5) {
        println("Não há backups suficientes para limpar. Total: ${pastasDeBackup?.size ?: 0}")
        return
    }

    // Exclui as pastas mais antigas até que restem apenas 5
    val paraExcluir = pastasDeBackup.take(pastasDeBackup.size - 5)

    println("Excluindo os seguintes backups antigos:")
    paraExcluir.forEach { pasta ->
        println("- ${pasta.name}")
        pasta.deleteRecursively() // Exclui a pasta e todo o seu conteúdo
    }

    println("Limpeza concluída. Total de backups restantes: 5")
}
fun main() {
    // Configura os caminhos para as pastas de origem e destino
    val pastaOrigem = File("tarefas.txt")
    val pastaDestino = File("backup/fotos")

    // Garante que a pasta de destino exista
    if (!pastaDestino.exists()) {
        pastaDestino.mkdirs()
    }

    println("Iniciando o sistema de backup...")

    // Executa o backup
    if (fazerBackup(pastaOrigem, pastaDestino)) {
        // Se o backup foi bem-sucedido, executa a limpeza
        limparBackupsAntigos(pastaDestino)
    } else {
        println("O backup falhou. A limpeza não será executada.")
    }
}
