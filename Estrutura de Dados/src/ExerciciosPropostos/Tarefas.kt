package ExerciciosPropostos

data class Tarefa(var id: Int, var descricao: String, var concluida: Boolean = false)

class ControleDeTarefas{
    private val tarefas = mutableListOf<Tarefa>()

    // Variável para incremento de id
    private var proximoId = 1

    fun adicionarTarefa(descricao: String){
        val novaTarefa = Tarefa(id = proximoId ++, descricao = descricao)
        tarefas.add(novaTarefa)
        println("ExerciciosPropostos.Tarefa '${novaTarefa.descricao}' adicionada com sucesso.")
    }

    fun listarTarefas(){
        //Verificação caso esteja nula
        if (tarefas.isEmpty()) {
            println("Nenhuma tarefa encontrada.")
            return
        }
        tarefas.forEach{tarefa ->
            val status = if (tarefa.concluida) "Concluída" else "Pendente"
            println("[${tarefa.id}] - ${tarefa.descricao} ($status)")
        }
    }

    fun marcarComoConcluida(id: Int){
        //Função find para busca dentro do objeto
        val tarefa = tarefas.find { it.id == id }
        if (tarefa != null ){
            tarefa.concluida = true
            println("ExerciciosPropostos.Tarefa de ID $id marcada como concluída.")
        } else {
            println("Erro: ExerciciosPropostos.Tarefa com ID $id não encontrada.")
        }
    }

    fun removerTarefa(id: Int){
        // Função 'removeIf' para remover pelo id
        val removida = tarefas.removeIf { it.id == id }
        if (removida) {
            println("ExerciciosPropostos.Tarefa de ID $id removida com sucesso.")
        } else {
            println("Erro: ExerciciosPropostos.Tarefa com ID $id não encontrada.")
        }
    }

    //Utiliza sobreescrição na String
    fun editarTarefa(id: Int, novaDescricao: String){
        val tarefa = tarefas.find { it.id == id }
        if (tarefa != null){
            tarefa.descricao = novaDescricao
            println("ExerciciosPropostos.Tarefa de ID $id editada com sucesso.")
        } else {
            println("Erro: ExerciciosPropostos.Tarefa com ID $id não encontrada.")
        }
    }

    fun filtrarTarefas(concluidas: Boolean) {
        val tarefasFiltradas = tarefas.filter { it.concluida == concluidas }
        if (tarefasFiltradas.isEmpty()) {
            println("Nenhuma tarefa neste status.")
            return
        }
        println("--- Tarefas ${if (concluidas) "Concluídas" else "Pendentes"} ---")
        tarefasFiltradas.forEach { tarefa -> println("[${tarefa.id}] - ${tarefa.descricao}") }
    }
}

fun main() {
    val gerenciador = ControleDeTarefas()

    gerenciador.adicionarTarefa("Estudar POO")
    gerenciador.adicionarTarefa("Fazer o exercício")
    gerenciador.adicionarTarefa("Praticar listas")

    println("--------")
    gerenciador.listarTarefas()
    println("--------")

    gerenciador.marcarComoConcluida(2) // Marca a tarefa com id 2
    gerenciador.editarTarefa(1, "Estudar mais Kotlin")

    println("--------")
    gerenciador.listarTarefas()

    println("--------")

    gerenciador.filtrarTarefas(concluidas = true) // Mostra a tarefa com id 2

    println("--------")

    gerenciador.removerTarefa(3)

    println("--------")
    gerenciador.listarTarefas()

}