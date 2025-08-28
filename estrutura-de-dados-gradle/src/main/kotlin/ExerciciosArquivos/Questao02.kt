package ExerciciosArquivos

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.Json
import java.io.File
import java.io.IOException

@Serializable
data class ConfiguracaoUsuario (
    @SerialName("nome_de_usuario")
    val nome: String,
    val idioma: String,
    val tema: String
)

/*T é um recurso de abstração, no qual declara a função como genérica
informa ao compilador que a função aceitará um tipo que será definido
no momento em que a função for chamada.*/
fun <T> salvarEmJson(nomeArquivo: String, objeto: T, serializer: KSerializer<T>) {
    val arquivo = File(nomeArquivo)

    try {
        val jsonString = Json.encodeToString(serializer, objeto)
        arquivo.writeText(jsonString)
    } catch (e: IOException) {
        println("Erro ao carregar o arquivo: ${e.message}")
    }
}

fun <T> carregarDeJson(nomeArquivo: String, serializer: KSerializer<T>): T? {
    val arquivo = File(nomeArquivo)
    if (!arquivo.exists()) {
        println("O arquivo '$nomeArquivo' não foi encontrado.")
        return null
    }

    try {
        val jsonString = arquivo.readText()
        return Json.decodeFromString(serializer, jsonString)
    } catch (e: IOException) {
        println("Erro ao carregar o arquivo: ${e.message}")
        return null
    }
}

fun main(){
    //1. Serialização: objeto para string JSON
    val config = ConfiguracaoUsuario("Jorge","pt-br","dracula")

    //2.Chamando a função para salvar o objeto no arquivo "config.json"
    salvarEmJson("config.json",config, ConfiguracaoUsuario.serializer())

    // Carrega o objeto do arquivo
    val configLida = carregarDeJson("config.json", ConfiguracaoUsuario.serializer())

    if (configLida != null) {
        println("Configuração lida do arquivo: ${configLida.nome}")
    }
}