fun exibirResultado(imc: Double) {
    val classificacao = when {
        imc < 18.5 -> "Abaixo do peso"
        imc < 24.9 -> "Peso normal"
        imc < 29.9 -> "Sobrepeso"
        imc < 34.9 -> "Obesidade grau I"
        imc < 39.9 -> "Obesidade grau II"
        else -> "Obesidade grau III (mórbida)"
    }

    println("---")
    println("Seu IMC é: %.2f".format(imc))
    println("Classificação: $classificacao")
    println("---")
}

fun main(){
    println("Digite seu Peso:")
    val pesoInput = readLine()
    val peso = pesoInput?.replace(',', '.')?.toDoubleOrNull()


    println("Digite sua Altura:")
    val alturaInput = readLine()
    val altura = alturaInput?.replace(',', '.')?.toDoubleOrNull()

    // Verificação e Cálculo
    if (peso != null && altura != null && altura > 0) {
        val imc = peso / (altura * altura)
        exibirResultado(imc)
    } else {
        println("Entrada inválida. Por favor, digite valores numéricos válidos e positivos.")
    }
}