/**Exercício 2.1: Crie uma função chamada ehPar que:
 Recebe um Int
 Retorna true se for par, false caso contrário (usando expressão única)
**/
//fun ehPar(numero: Int?): Boolean = if (numero % 2 == 0) true else false
fun ehPar(numero: Int?): Boolean = numero?.let { it % 2 == 0 } ?: false

/**
 * Exercício 2.2: Crie uma função de extensão para String chamada inverte que:
 Retorna a string invertida
Exemplo: Kotlin.inverte() → niltok;
 **/
fun inverte(palavra: String): String = palavra.reversed()

fun main(){
    print("Digite um número inteiro:")
    val numInput = readLine()
    var num = numInput?.toIntOrNull()
    val resultado = ehPar(num)
    println("$resultado")

    /*print("Digite uma palavra:")
    val pInput = readLine()
    val reverse = inverte(pInput ?: "")
    println("$reverse")*/

    println("-----")
    val minhaPalavra = "Kotlin"
    val resultPalavra = inverte(minhaPalavra)
    println("$resultPalavra")
}