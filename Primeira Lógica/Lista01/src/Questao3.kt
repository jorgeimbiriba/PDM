/**
 * Exercício 3.1: Escreva uma função comprimentoOuZero que:
 Recebe uma String?
 Retorna o tamanho da string ou 0 se for nula (use safe call e Elvis operator)
**/
fun comprimentoOuZero(palavra: String?): Int = palavra?.length ?: 0

/**
 * Exercício 3.2: Crie uma função descreveEndereco que:
 Recebe rua (String?), número (Int?), cidade (String?)
 Retorna uma string no formato &quot;Rua [rua], Nº [número], [cidade]&quot;
 Substitua qualquer valor nulo por &quot;Não informado&quot;
 **/
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