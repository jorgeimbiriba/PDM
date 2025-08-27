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

    //fazer as funções de remover e filtrar por tag
    fun removerTag(artigoId: Int, tag: String){
        val artigo = artigos.find {it.id == artigoId}
        if (artigo!=null){
            val removido = artigo.tags.remove(tag)
            println("Tag '$tag' removida do artigo '${artigo.titulo}'")
        }else{
            println("Erro: Artigo com ID $artigoId não encontrado.")
        }
    }


}