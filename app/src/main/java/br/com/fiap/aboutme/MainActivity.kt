package br.com.fiap.aboutme

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var buttonProfissao: Button
    lateinit var buttonEditar: Button
    lateinit var textViewNome: TextView
    lateinit var textViewProfissao: TextView
    lateinit var textViewBiografia: TextView
    lateinit var editTextNome: TextView
    lateinit var editTextProfissao: EditText
    //val buttonEditar: Button by lazy { findViewById<Button>(R.id.buttonProfissao) }

    override fun onPause() {
        super.onPause()
        toast("Tela em Pause")
    }

    override fun onResume() {
        super.onResume()
        toast("Tela em Resume")
        recuperarDados()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonProfissao = findViewById(R.id.buttonProfissao)
        buttonEditar = findViewById(R.id.buttonEditar)
        editTextProfissao = findViewById(R.id.editProfissao)
        textViewNome = findViewById(R.id.textViewNome)
        textViewProfissao = findViewById(R.id.textViewProfissao)
        textViewBiografia = findViewById(R.id.textViewBiografia)

        recuperarDados()

        buttonProfissao.setOnClickListener {
            val profissao = editTextProfissao.text.toString()

            if (profissao.isNotEmpty()) {
                textViewProfissao.text = profissao

                buttonProfissao.visibility = View.GONE
                editTextProfissao.visibility = View.GONE
            } else {
                editTextProfissao.error = "Campo não pode estar em branco!"
                toast("Digite uma profissão!")
            }
        }

        textViewProfissao.setOnClickListener {
            buttonProfissao.visibility = View.VISIBLE
            editTextProfissao.visibility = View.VISIBLE
        }

        buttonEditar.setOnClickListener {
            // Intent: tipo do android  que serve para comunicar com o sistema (browser, agenda telefonica), navegar entre as telas, o primeiro argumento é o contexto e o segundo é a tela de destino
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }
    }

    fun recuperarDados() {
        val sharedPreferences = getSharedPreferences("aboutme", Context.MODE_PRIVATE)

        val nome = sharedPreferences.getString("nome", "")
        val profissao = sharedPreferences.getString("profissao", "")
        val biografia = sharedPreferences.getString("biografia", "")

        textViewNome.text = nome
        textViewProfissao.text = profissao
        textViewBiografia.text = biografia
    }

    // Função que cria o menu superior direito
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Função que executa a funcionalidade da opção escolhida no menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_edit -> {
                val intent = Intent(this, EditActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return false
    }
}
