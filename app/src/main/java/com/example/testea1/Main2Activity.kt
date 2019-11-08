package com.example.testea1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main2.*
import org.json.JSONObject
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        // Get the Intent that started this activity and extract the string
        val message = this.intent.getStringExtra("EXTRA_MESSAGE")
        // TODO Processar a EXTRA_MESSAGE que indica qual busca foi selecionada
        //      Por enquanto coloca o texto na barra de título
        this.title = message

        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Obrigado", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //TODO Pega nova anotação do web service e exibe o HTML
        //  Por enquanto pega um arquivo json nos assets
        //webView.loadUrl("file:///android_asset/texto3.html")
  //      val file_name = "db.json"
  //      val json_string :String = application.assets.open(file_name).bufferedReader().use{
  //          it.readText()}
  //      val html = JSONObject(JSONObject(json_string).getString("resposta")).getString("html")

        val url ="https://my-json-server.typicode.com/Villarinho/fakeServer/db"
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                Log.i("JSON" ,response.substring(0, 400))
                val html = JSONObject(JSONObject(response).getString("resposta")).getString("html")
                webView.loadData(html, "text/html", null)
                Log.i("JSON",html)

            },
            Response.ErrorListener { Log.i("VOL", "That didn't work!" )})

        // Add the request to the RequestQueue.
        queue.add(stringRequest)




        val enviaRotulo: EnviaRotulo = EnviaRotulo(webView)

        // Propriedades dos botões
        val botaoSim: Button = button4
        val botaoDuvida: Button = button6
        val botaoNao: Button = button5
        botaoSim.tag = 1
        botaoDuvida.tag = 0
        botaoNao.tag = -1
        botaoSim.setOnClickListener(enviaRotulo)
        botaoDuvida.setOnClickListener(enviaRotulo)
        botaoNao.setOnClickListener(enviaRotulo)
    }
}
