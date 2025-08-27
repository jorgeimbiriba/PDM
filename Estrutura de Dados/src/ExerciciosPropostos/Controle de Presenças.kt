package ExerciciosPropostos

data class Aluno(val nome:String, val matricula: String)

class ControlePresenca{
    private val presentesHoje = mutableSetOf<String>()
    private val todasFaltas = mutableSetOf<String>()

    fun marcarPresenca(matricula: String){
        presentesHoje.add(matricula)
        todasFaltas.remove(matricula)
    }

    fun marcarFalta(matricula: String){
        presentesHoje.remove(matricula)
        todasFaltas.add(matricula)
    }

    fun verificarPresenca(matricula: String): Boolean{
        return matricula in presentesHoje
    }

    fun obterEstatisticas(): String{
        return "Presentes: ${presentesHoje.size}. Total com Faltas ${todasFaltas.size}"
    }

    fun alunosQueNuncaFaltaram(todasMatriculas: Set<String>): Set<String>{
        return todasMatriculas subtract todasMatriculas
    }
}

fun main(){
    val controle = ControlePresenca()

    controle.marcarPresenca("2024004")
    controle.marcarPresenca("2024005")
    controle.marcarFalta("2024006")

    println(controle.obterEstatisticas())

    val todasMatriculas = setOf("2024004","2024005","2024006")
    val semFaltas = controle.alunosQueNuncaFaltaram(todasMatriculas)
    println("Alunos sem faltas: $semFaltas")

}