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
        title = message

        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Obrigado", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        EnviaRotulo.webView = findViewById(R.id.webView)

        val webView: WebView
        webView = findViewById(R.id.webView);
        // displaying text in WebView
        webView.loadUrl("file:///android_asset/sample.html")

        var button4: Button = findViewById(R.id.button4)
        var button5: Button = findViewById(R.id.button5)
        var button6: Button = findViewById(R.id.button6)
        button4.setOnClickListener(EnviaRotulo)
        button5.setOnClickListener(EnviaRotulo)
        button6.setOnClickListener(EnviaRotulo)
    }


}
