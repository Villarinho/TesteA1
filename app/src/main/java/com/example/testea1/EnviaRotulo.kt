package com.example.testea1

import android.view.View
import android.webkit.WebView
import com.google.android.material.snackbar.Snackbar

class EnviaRotulo(webView: WebView) : View.OnClickListener {
    var ciclo: Int = 1
    var wv: WebView = webView

    override fun onClick(v: View?) {
        /*
        TODO Enviar rótulo ao web service
            Por enquanto escreve uma mensagem numa Snackbar
        */
        Snackbar.make(
            v!!,
            if (v.tag == 0) "Vamos tentar outra" else "Obrigado",
            Snackbar.LENGTH_SHORT
        )
            .setAction("Action", null).show()
        /*
        TODO Receber do web service novo objeto a rotular
            Por enquanto circula entre os arquivos texto_.html nos assets
        */
        ciclo = if (ciclo == 3) 1 else (ciclo + 1)
        wv.loadUrl("file:///android_asset/texto${ciclo}.html");

    }
}