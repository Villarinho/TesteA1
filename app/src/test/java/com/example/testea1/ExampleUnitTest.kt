package com.example.testea1

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun testeCiclo() {
        var ciclo: Int = 1
        for (i in 1..10) {
            ciclo = if (ciclo == 3) 1 else (ciclo + 1)
            println(ciclo)
        }

    }

}
