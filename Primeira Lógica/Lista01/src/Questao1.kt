fun main(){
    /**
     * Exercício 1.1 Crie um programa que:
     Declare uma variável imutável com seu nome
     Declare uma variável mutável com sua idade
     Imprima: Meu nome é [nome] e tenho [idade] anos&quot;
     Incremente a idade e imprima novamente
     **/
    val nome = "Jorge"
    var idade = 20

    println("Meu nome é $nome e tenho $idade anos")

    println("-----")
    idade +=1
    println("Ano que vem terei $idade anos")

     /**
     * Exercício 1.2: Escreva uma expressão que:
      Receba um número inteiro
      Retorne Positivo se for maior que zero, Negativo se for menor e Zero caso contrário
     **/

    println("-----")
    print("Digite um número:")
    val numInput = readLine()
    var num = numInput?.toIntOrNull()
    val resultado = when {
        num!! > 0 -> "Positivo"
        num < 0 -> "Negativo"
        else -> "Zero"
    }

    println("O número $num é $resultado")
}
