//fun ehPar(numero: Int?): Boolean = if (numero % 2 == 0) true else false
fun ehPar(numero: Int?): Boolean = numero?.let { it % 2 == 0 } ?: false

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

    val minhaPalavra = "Kotlin"
    val resultPalavra = inverte(minhaPalavra)
    println("$resultPalavra")
}