package com.example.testea1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.view.Gravity
import android.graphics.Color.parseColor

import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.*
import android.widget.LinearLayout

import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.TextView
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listarPesquisas()

        setSupportActionBar(toolbar)


//Mensagem aquando clica no botão ao pé da página
        fab.setOnClickListener { view ->
            Snackbar.make(view, getString(R.string.aviso_snackbar), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, Main2Activity::class.java).apply {
            putExtra("EXTRA_MESSAGE", "Teste")
        }
        startActivity(intent)

    }

    fun listarPesquisas() {
        var linearLayoutVertical: LinearLayout = findViewById(R.id.layoutHolder)
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
        ) //Layout params for Button
        layoutHolder.removeAllViews()//Remove all views from Layout before placing new view
        //Array for holding refrences
        val buttonHolder: Array<Button?>

        buttonHolder = arrayOfNulls<Button>(20)//Setting size of Button Array
        Pesquisa.get_listaPesquisa()
        //Loop for items
        for (i in 0..19) {
            val button = Button(this)//Creating Button
            button.setId(i)//Setting Id for using in future
            button.setText(Pesquisa.lista.get(i).name)//Setting text
            button.setPadding(5, 5, 5, 5)//paading
            button.setLayoutParams(params)//Setting Layout Params
            button.setTextColor(parseColor("#000000"))//Text Colort
            button.setGravity(Gravity.CENTER)//Gravity of Text
            button.setOnClickListener(this)
            buttonHolder[i] = button//Setting button reference in array for future use
            layoutHolder.orientation = LinearLayout.VERTICAL//Setting Layout orientation
            layoutHolder.addView(button)//Finally adding view
        }
    }
}
