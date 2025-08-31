package ExerciciosExcecoes

import java.lang.IllegalArgumentException

class SenhaInvalidaException(message: String): IllegalArgumentException(message)

fun validarSenha(senha: String): String? {
    try {
        // Regra 1: A senha deve ter pelo menos 8 caracteres.
        if (senha.length < 8) {
            throw SenhaInvalidaException("A senha deve ter pelo menos 8 caracteres.")
        }

        // Regra 2: A senha deve conter pelo menos um número.
        val contemNumero = senha.any { it.isDigit() }
        if (!contemNumero) {
            throw SenhaInvalidaException("A senha deve conter pelo menos um número.")
        }

        return "Senha Válida!"

    } catch (e: SenhaInvalidaException) {
        return e.message
    }
}

fun main(){
    val minhaSenha = "JorgeHenrique"
    val minhaOutraSenha = "J0rg3Henrique"

    val resultado1 = validarSenha(minhaSenha)
    println("Resultado para '$minhaSenha': $resultado1")

    println()

    val resultado2 = validarSenha(minhaOutraSenha)
    println("Resultado para '$minhaOutraSenha': $resultado2")
}