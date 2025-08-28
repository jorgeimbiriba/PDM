package ExemplosEmSala

data class Artigo(val id: Int, val titulo: String, val tags: MutableSet<String> = mutableSetOf())

class GerenciadorDeArtigos {
    private val artigos = mutableSetOf<Artigo>()
    private var proximoId = 1

    fun adicionarArtigo(titulo: String): Artigo {
        val novoArtigo = Artigo(id = proximoId++, titulo = titulo)
        artigos.add(novoArtigo)
        return novoArtigo
    }

    fun adicionarTag(artigoId: Int, tag: String){
        val artigo = artigos.find {it.id == artigoId}
        if (artigo!=null){
          val adicionado = artigo.tags.add(tag)
          if (adicionado){
              println("Tag '$tag' adicionada ao artigo '${artigo.titulo}'")
          }else{
              println("Tag '$tag' já pertence ao artigo '${artigo.titulo}'")
          }
        }else{
            println("Erro: Artigo com ID $artigoId não encontrado.")
        }
    }

    fun removerTag(artigoId: Int, tag: String){
        val artigo = artigos.find {it.id == artigoId}
        if (artigo!=null){
            val removido = artigo.tags.remove(tag)
            println("Tag '$tag' removida do artigo '${artigo.titulo}'")
        }else{
            println("Erro: Artigo com ID $artigoId não encontrado.")
        }
    }

    fun filtrarArtigosPorTag(tag: String){
        val artigosFiltrados = artigos.filter {it.tags.contains(tag)}
        if (artigosFiltrados.isNotEmpty()) {
            println("Artigos com a tag '$tag':")
            artigosFiltrados.forEach { artigo ->
                println("- [${artigo.id}] ${artigo.titulo}")
            }
        } else {
            println("Nenhum artigo encontrado com a tag '$tag'")
        }
    }

    fun listarArtigos(){
        if(artigos.isEmpty()){
            println("Nenhum Artigo encontrado")
            return
        }
        println("--- Lista de Artigos ---")
        artigos.forEach {artigo ->
            println("[${artigo.id}] - ${artigo.titulo} ")
            println("Tags: ${if (artigo.tags.isEmpty()) "Nenhuma" else artigo.tags.joinToString(", ")}")
        }
    }
}

fun main(){
    val gerenciador = GerenciadorDeArtigos()

    println("Adicionando artigos iniciais...")
    val artigo1 = gerenciador.adicionarArtigo("Propriedade Intelectual e Inteligência Artificial")
    val artigo2 = gerenciador.adicionarArtigo("Ortodontia e IA")
    val artigo3 = gerenciador.adicionarArtigo("Mulheres na área da Programação")

    println("\nAdicionando tags...")
    gerenciador.adicionarTag(artigo1.id, "Direito")
    gerenciador.adicionarTag(artigo1.id, "Inteligência Artificial")
    gerenciador.adicionarTag(artigo2.id, "Medicina")
    gerenciador.adicionarTag(artigo2.id, "Inteligência Artificial")
    gerenciador.adicionarTag(artigo3.id, "Programação")
    gerenciador.adicionarTag(artigo3.id, "Sociedade")
    gerenciador.adicionarTag(artigo3.id, "Mulheres")

    println("\nListando todos os artigos:")
    gerenciador.listarArtigos()

    println("\nFiltrando por tag 'Inteligência Artificial':")
    gerenciador.filtrarArtigosPorTag("Inteligência Artificial")

    println("\nRemovendo uma tag e tentando remover uma inexistente:")
    gerenciador.removerTag(artigo1.id, "Direito")
    gerenciador.removerTag(artigo1.id, "TagInexistente")

    println("\nListando artigos após a remoção:")
    gerenciador.listarArtigos()
}