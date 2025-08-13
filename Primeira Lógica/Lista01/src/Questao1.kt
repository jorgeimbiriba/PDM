fun main(){
    val nome = "Jorge"
    var idade = 20

    println("Meu nome é $nome e tenho $idade anos")

    println("-----")
    idade +=1
    println("Ano que vem terei $idade anos")

    println("Digite um número:")
    val numInput = readLine()
    var num = numInput?.toIntOrNull()
    val resultado = when {
        num!! > 0 -> "Positivo"
        num < 0 -> "Negativo"
        else -> "Zero"
    }

    println("O número $num é $resultado")
}
