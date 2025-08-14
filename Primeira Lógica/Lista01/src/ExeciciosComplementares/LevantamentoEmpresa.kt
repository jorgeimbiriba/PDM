package ExeciciosComplementares

class Candidato (val nome: String, val numeroDeInscricao: Int, val idade: Int, val sexo: Char, val experiencia: String)

fun contarCandidatosPorSexo(lista: List<Candidato>): Map<Char, Int> {
    // mapValues converte a lista de candidatos em um tamanho
    return lista.groupBy { it.sexo }.mapValues { it.value.size }
}

fun calcularMediaIdadeHomensExperientes(lista: List<Candidato>): Double {
    val homensComExperiencia = lista.filter {
        it.sexo == 'M' && it.experiencia.equals("sim", ignoreCase = true)
    }

    return if (homensComExperiencia.isNotEmpty()) {
        homensComExperiencia.map { it.idade.toDouble() }.average()
    } else {
        0.0
    }
}

fun calcularPorcentagemHomensComMaisDe45(lista: List<Candidato>): Double {
    val totalDeHomens = lista.count { it.sexo == 'M' }
    val homensComMaisDe45 = lista.count { it.sexo == 'M' && it.idade > 45 }

    return if (totalDeHomens > 0) {
        (homensComMaisDe45.toDouble() / totalDeHomens.toDouble()) * 100
    } else {
        0.0
    }
}

fun numeroMulheresIdadeInferior35Experientes(lista: List<Candidato>): Int{
    val mulheresComMaisDe35 = lista.count() {
        it.sexo == 'F' && it.idade <35 && it.experiencia.equals("sim", ignoreCase = true)
    }
    return mulheresComMaisDe35
}

fun menorIdadeEntreMulheresExperientes(lista: List<Candidato>): Int{
    val mulheresExperientes = lista.filter {
        it.sexo == 'F' && it.experiencia.equals("sim", ignoreCase = true)
    }

    return mulheresExperientes.minOfOrNull { it.idade } ?: 0
}

fun main() {
    val listaDeCandidatos = listOf(
        Candidato("Maria", 1, 25, 'F', "Sim"),
        Candidato("João", 2, 30, 'M', "Não"),
        Candidato("Ana", 3, 22, 'F', "Sim"),
        Candidato("Carlos", 4, 35, 'M', "Sim"),
        Candidato("Lucia", 5, 28, 'F', "Não"),
        Candidato("Pedro", 6, 45, 'M', "Sim"),
        Candidato("Isabela", 7, 31, 'F', "Sim"),
        Candidato("Fernando", 8, 48, 'M', "Sim"),
        Candidato("Juliana", 9, 29, 'F', "Não"),
        Candidato("Rafael", 10, 50, 'M', "Não"),
        Candidato("Camila", 11, 34, 'F', "Sim"),
        Candidato("Gustavo", 12, 20, 'M', "Sim"),
        Candidato("Patrícia", 13, 40, 'F', "Não"),
        Candidato("Ricardo", 14, 55, 'M', "Sim"),
        Candidato("Bianca", 15, 26, 'F', "Sim"),
        Candidato("Alexandre", 16, 60, 'M', "Não"),
        Candidato("Daniela", 17, 33, 'F', "Sim"),
        Candidato("Eduardo", 18, 38, 'M', "Sim"),
        Candidato("Carolina", 19, 24, 'F', "Não"),
        Candidato("Felipe", 20, 27, 'M', "Sim")
    )

    println("-----")
    val contagem = contarCandidatosPorSexo(listaDeCandidatos)
    println("Contagem por sexo:")
    println("Masculino (M): ${contagem['M'] ?: 0}")
    println("Feminino (F): ${contagem['F'] ?: 0}")

    println("-----")
    val mediaIdade = calcularMediaIdadeHomensExperientes(listaDeCandidatos)
    println("A idade média dos homens com experiência é: %.2f".format(mediaIdade))

    println("-----")
    val porcentagem = calcularPorcentagemHomensComMaisDe45(listaDeCandidatos)
    println("Porcentagem de homens com mais de 45 anos: %.2f%%".format(porcentagem))

    println("-----")
    val numeroDeMulheres = numeroMulheresIdadeInferior35Experientes(listaDeCandidatos)
    println("O número de mulheres com menos de 35 anos e experiência é: $numeroDeMulheres")
    println("-----")
    val idadeMulheresExperientes = menorIdadeEntreMulheresExperientes(listaDeCandidatos)
    println("Menor idade entre as mulheres que possuem experiência: $idadeMulheresExperientes")

}