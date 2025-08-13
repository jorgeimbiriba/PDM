fun comprimentoOuZero(palavra: String?): Int = palavra?.length ?: 0

fun descreveEndereco(rua: String?, numero: Int, cidade:String?): String{
    val ruaDescricao = rua ?: "Não informado"
    val numeroDescricao = numero?.toString() ?: "Não informado"
    val cidadeDescricao = cidade ?: "Não informado"

    return "Rua $ruaDescricao, Nº $numeroDescricao, $cidadeDescricao"
}

fun main(){
    val palavra = "Paralelepípedo"
    val resultado = comprimentoOuZero(palavra)
    println("$palavra")
    println("Nº de caracteres: $resultado")

    println("-----")
    val endereco1 = descreveEndereco("Barão do Rio Preto", 123, "Manaus")
    println(endereco1)
}