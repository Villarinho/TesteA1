package com.example.testea1

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main2.*

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
        //  Por enquanto pega um arquivo HTML nos assets
        webView.loadUrl("file:///android_asset/texto3.html")

        var enviaRotulo: EnviaRotulo = EnviaRotulo(webView)

        // Propriedades dos botões
        var botaoSim: Button = button4
        var botaoDuvida: Button = button6
        var botaoNao: Button = button5
        botaoSim.tag = 1
        botaoDuvida.tag = 0
        botaoNao.tag = -1
        botaoSim.setOnClickListener(enviaRotulo)
        botaoDuvida.setOnClickListener(enviaRotulo)
        botaoNao.setOnClickListener(enviaRotulo)
    }
}
