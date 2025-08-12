class Aluno (var nome: String){
    fun apresentarEstudos(){
        println("Olá $nome, você acaba de começar seus estudos em Kotlin")
    }
}

fun main() {
    val aluno = Aluno("Jorge")
    aluno.apresentarEstudos()
}