package com.example.testea1

import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main2.*


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        // Get the Intent that started this activity and extract the string
        val message = this.intent.getStringExtra("EXTRA_MESSAGE")
        this.title = message

        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Obrigado", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //TODO Pega nova anotação do web service e exibe o HTML
        //  Por enquanto pega um arquivo HTML nos assets
        val webView: WebView = findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/texto3.html")

        var enviaRotulo: EnviaRotulo = EnviaRotulo(findViewById(R.id.webView))
        var botaoSim: Button = findViewById(R.id.button4)
        var botaoDuvida: Button = findViewById(R.id.button6)
        var botaoNao: Button = findViewById(R.id.button5)
        botaoSim.tag = 1
        botaoDuvida.tag = 0
        botaoNao.tag = -1
        botaoSim.setOnClickListener(enviaRotulo)
        botaoDuvida.setOnClickListener(enviaRotulo)
        botaoNao.setOnClickListener(enviaRotulo)
    }


}
