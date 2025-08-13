/**Exercício 4.1: Crie uma data class Aluno com:
 nome (String)
 matricula (String)
 notas (List&lt;Double&gt;)
 Adicione uma função que calcula a média
 **/
data class Aluno (val nome:String, val matricula: String, val notas: List <Double>)
fun media(notas: List<Double>): Double{
    if (notas.isEmpty()){
        return 0.0
    }
    return notas.average()
}

/**Exercício 4.2: Crie uma classe Retangulo com:

 largura e altura (Double no construtor)
 Função que calcula área
 Função que calcula perímetro
 Função que retorna &quot;Quadrado&quot; se largura == altura, &quot;Retângulo&quot; caso
contrário**/
class Retangulo (val largura: Double, val altura: Double){

    fun perimetro(): Double{
        return 2 * (largura + altura)
    }

    fun area (): Double{
        return (largura * altura)
    }

    fun forma (): String{
        if (largura == altura){
            return "Quadrado"
        }
        return "Retângulo"
    }
}

fun main(){
    println("-----")
    val aluno1 = Aluno("João", "2024004875", notas = listOf(8.5,7.0,9.0))
    val mediaAluno1 = media(aluno1.notas)
    println("A média do aluno ${aluno1.nome} é: %.2f".format(mediaAluno1)) //format para alocação de função

    println("-----")
    val retangulo = Retangulo(10.0,5.0)
    println("Forma: ${retangulo.forma()}")
    println("Área: ${retangulo.area()}")
    println("Perímetro: ${retangulo.perimetro()}")

    println("-----")
    val quadrado = Retangulo( 7.0, 7.0)
    println("Forma: ${quadrado.forma()}")
    println("Área: ${quadrado.area()}")
    println("Perímetro: ${quadrado.perimetro()}")

}


