package ExemplosDaSala

import java.io.File
import java.io.FileOutputStream

fun main(){
    val dados = byteArrayOf(72, 101, 108, 111)
    File("dados.bin").writeBytes(dados)

    val bytesLidos = File("dados.bin").readBytes()
    println("Bytes lidos: ${bytesLidos.joinToString()}")

    FileOutputStream("dados2.bin").use{fos ->
        fos.write(dados)
    }
}