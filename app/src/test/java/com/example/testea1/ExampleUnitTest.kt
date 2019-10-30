package com.example.testea1

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun cria_listaPesquisa() {
        Pesquisa.add("tipologia 1","lagosta")
        Pesquisa.add("tipologia 2","camarão")
        Pesquisa.add("tipologia 3","polvo")
        Pesquisa.add("tipologia 4","siri")
    }
    @Test
    fun teste_listaPesquisa() {
        cria_listaPesquisa()
        for (pesquisa :Pesquisa in Pesquisa.lista) {
            println(pesquisa.name + "  " + pesquisa.texto_busca)
        }
        print(Pesquisa.lista.get(19).name)

}}
