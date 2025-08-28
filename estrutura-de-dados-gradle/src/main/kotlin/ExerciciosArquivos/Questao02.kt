package ExerciciosArquivos

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
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
fun <T> salvarEmJson(nomeArquivo: String, objeto: T){
    val arquivo = File(nomeArquivo)
    try {
        val jsonString = Json.encodeToString(objeto)

        arquivo.writeText(jsonString)
        println("Objeto serializado e salvo com sucesso em '$nomeArquivo'.")
    }catch (e: IOException){
        println("Erro ao salvar o arquivo: ${e.message}")
    }
}


fun main(){
    //1. Serialização: objeto para string JSON
    val configuracao = ConfiguracaoUsuario("Jorge","pt-br","dracula")

    //2.Chamando a função para salvar o objeto no arquivo "config.json"
    salvarEmJson("config.json", configuracao)
}