package ExemplosDaSala

import java.io.File

fun main() {
    File("dados.txt").writeText("Olá, mundo Kotlin!\n")

    File("dados.txt").appendText("Esta é a segunda linha\n")

    val conteudo = File("dados.txt").readText()
    println("Conteúdo completo:\n$conteudo")

    println("\nLinhas do arquivo:")
    File("dados.txt").forEachLine { println(">$it") }

    val linhas = File("dados.txt").readLines()
    println("\nLista de Linhas: $linhas")
}