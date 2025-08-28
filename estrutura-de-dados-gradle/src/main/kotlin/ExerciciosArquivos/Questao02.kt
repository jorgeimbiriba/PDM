package ExerciciosArquivos

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

@Serializable
data class ConfiguracaoUsuario (
    @SerialName
    val nome: String,
    val idioma: String,
    val tema: String
)