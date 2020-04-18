package br.com.fiap.aboutme

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        // Criando arquivo "aboutme" para as sharedPreferences
        val sharedPreferences: SharedPreferences = getSharedPreferences("aboutme", Context.MODE_PRIVATE)

        // Declarando componentes
        val editTextNome: EditText = findViewById(R.id.editTextNome)
        val editTextProfissao: EditText = findViewById(R.id.editTextProfissao)
        val editTextBiografia: EditText = findViewById(R.id.editTextBiografia)
        val buttonSalvar : Button = findViewById(R.id.buttonSalvar)

        //Recuperando dados para exibir
        val nome = sharedPreferences.getString("nome", "")
        val profissao = sharedPreferences.getString("profissao", "")
        val biografia = sharedPreferences.getString("biografia", "")
        editTextNome.setText(nome)
        editTextProfissao.setText(profissao)
        editTextBiografia.setText(biografia)

        // Salvando dados
        buttonSalvar.setOnClickListener {
            val editor = sharedPreferences.edit()

            editor.putString("nome", editTextNome.text.toString())
            editor.putString("profissao", editTextProfissao.text.toString())
            editor.putString("biografia", editTextBiografia.text.toString())

            editor.apply()
            toast("Dados salvos com sucesso!")
            finish()
        }
    }
}
