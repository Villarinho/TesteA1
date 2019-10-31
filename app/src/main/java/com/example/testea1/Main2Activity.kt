package com.example.testea1

import android.os.Bundle
import android.webkit.WebView
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
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val webView: WebView
        val content = "<h1>Heading 1</h1>\n" +
                "        <h2>Heading 2</h2>\n" +
                "        <p>This is some html. Look, here\\'s an <u>underline</u>.</p>\n" +
                "        <p>Look, this is <em>emphasized.</em> And here\\'s some <b>bold</b>.</p>\n" +
                "        <p>Here are UL list items:\n" +
                "        <ul>\n" +
                "        <li>One</li>\n" +
                "        <li>Two</li>\n" +
                "        <li>Three</li>\n" +
                "        </ul>\n" +
                "        <p>Here are OL list items:\n" +
                "        <ol>\n" +
                "        <li>One</li>\n" +
                "        <li>Two</li>\n" +
                "        <li>Three</li>\n" +
                "        </ol>"
        webView = findViewById(R.id.webView);
        // displaying text in WebView
        webView.loadDataWithBaseURL(null, content, "text/html", "utf-8", null);
    }

}
