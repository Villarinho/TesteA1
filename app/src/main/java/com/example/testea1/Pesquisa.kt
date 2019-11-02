package com.example.testea1

data class Pesquisa(val id: Int, val name: String, val texto_busca: String) {
    companion object {
        val lista = mutableListOf<Pesquisa>()

        fun add(id: Int, name: String, texto_busca: String): Pesquisa {
            val pesquisa = Pesquisa(id, name, texto_busca)
            lista.add(pesquisa)
            return pesquisa
        }

        fun getSize(): Int {
            return lista.size
        }

        /**
         * Baixa a lista de pesquisas do web service
         * TODO Acesso ao web service lista de pesquisas
         *  Por enquanto retorna uma lista falsa
         */
        fun downloadListaPesquisa(usuario: String) {
            Pesquisa.add(1, "lagosta", "lagosta")
            Pesquisa.add(2, "camarão", "camarão")
            Pesquisa.add(3, "siri", "siri")
            Pesquisa.add(4, "ágata", "ágata")
            Pesquisa.add(5, "topázio", "topázio")
            Pesquisa.add(6, "turmalina", "turmalina")
            Pesquisa.add(7, "certidão", "certidão")
            Pesquisa.add(8, "minha tipologia", "palavra")

            for (i: Int in 9..12) {
                Pesquisa.add(i, "tipologia  $i", "siri $i")
            }
        }

    }
}

