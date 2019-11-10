package com.example.testea1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main2.*
import org.json.JSONObject

const val TAG_LOG = "AGATA"
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
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //TODO Conectar ao web service
        // Por enquanto acessa um servidor fake
        val url ="https://my-json-server.typicode.com/Villarinho/fakeServer/resposta"
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Log the first characters of the response string.
                Log.i(TAG_LOG ,response.substring(0, 400))
            val html = JSONObject(response).getString("html")
                webView.loadData(html, "text/html", null)
                Log.i(TAG_LOG,html)
            },
            Response.ErrorListener { Log.i(TAG_LOG, "That didn't work!" )})

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
