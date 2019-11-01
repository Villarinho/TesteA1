package com.example.testea1

import android.view.View
import android.webkit.WebView

object EnviaRotulo : View.OnClickListener {
    var ciclo: Int = 1
    var webView: WebView? = null

    override fun onClick(v: View?) {
        ciclo = if (ciclo == 3) 1 else (ciclo + 1)
        webView?.loadUrl("file:///android_asset/texto" + ciclo + ".html");

    }
}