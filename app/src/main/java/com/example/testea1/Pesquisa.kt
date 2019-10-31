package com.example.testea1

data class Pesquisa(val name: String, val texto_busca: String) {
    companion object {
        val lista = mutableListOf<Pesquisa>()


        fun add(name: String, texto_busca: String): Pesquisa {
            val pesquisa = Pesquisa(name, texto_busca)
            lista.add(pesquisa)
            return pesquisa
        }

        /**
         * Baixa a lista de pesquisas do web service
         * TODO Acesso ao web service lista de pesquisas
         */
        fun downloadListaPesquisa(usuario: String) {
            Pesquisa.add("tipologia 1","lagosta")
            Pesquisa.add("tipologia 2","camarão")
            Pesquisa.add("tipologia 3","polvo")
            Pesquisa.add("tipologia 4","siri")
            for (i:Int  in 5..20 ){
                Pesquisa.add("tipologia  $i " ,"siri $i")
            }

        }
    }
}

