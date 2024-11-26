// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario) // Adiciona o usuário à lista de inscritos
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }
}

fun main() {
    // Criando alguns conteúdos educacionais
    val kotlinBasico = ConteudoEducacional("Introdução ao Kotlin", 120)
    val kotlinIntermediario = ConteudoEducacional("Kotlin Avançado", 180)
    val kotlinProjetos = ConteudoEducacional("Projetos Práticos com Kotlin", 240)

    // Criando uma formação
    val formacaoKotlin = Formacao(
        nome = "Formação Kotlin",
        conteudos = listOf(kotlinBasico, kotlinIntermediario, kotlinProjetos),
        nivel = Nivel.INTERMEDIARIO
    )

    // Criando usuários
    val usuario1 = Usuario("Winston")
    val usuario2 = Usuario("Leonardo")

    // Matriculando usuários
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    // Exibindo informações da formação
    println("Formação: ${formacaoKotlin.nome} (${formacaoKotlin.nivel})")
    println("Conteúdos:")
    formacaoKotlin.conteudos.forEach { 
        println("- ${it.nome} (Duração: ${it.duracao} minutos)") 
    }

    println("Inscritos:")
    formacaoKotlin.inscritos.forEach { 
        println("- ${it.nome}") 
    }
}

