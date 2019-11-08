package com.example.testea1

import org.junit.Test
import java.io.IOException
import java.io.InputStream
import java.io.File
import org.json.JSONObject




/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun testeCiclo() {
        var ciclo = 1
        for (i in 1..10) {
            ciclo = if (ciclo == 3) 1 else (ciclo + 1)
            println(ciclo)
        }

    }

    fun readFileDirectlyAsText(fileName: String): String
            = File(fileName).readText(Charsets.UTF_8)

    @Test
    fun parseJson() {
   //     val path = System.getProperty("user.dir")+"\\src\\main\\assets\\db.json"

        val json:String = readFileDirectlyAsText("//android_asset/db.json")

     //   val jObject = JSONObject(json)
    //    val aJsonString = jObject.getString("resposta.html")
        println(json)

    }

    

 }
