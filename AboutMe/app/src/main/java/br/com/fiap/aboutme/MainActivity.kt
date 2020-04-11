package br.com.fiap.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.buttonProfissao)
        val textViewProfissao: TextView = findViewById(R.id.textViewProfissao)
        val editTextProfissao: EditText = findViewById(R.id.editProfissao)

        button.setOnClickListener {
            val profissao = editTextProfissao.text.toString()

            if (profissao.isNotEmpty()) {
                textViewProfissao.text = profissao

                button.visibility = View.GONE
                editTextProfissao.visibility = View.GONE
            } else {
                editTextProfissao.error = "Campo não pode estar em branco!"
                toast("Digite uma profissão!")
            }
        }

        textViewProfissao.setOnClickListener {
            button.visibility = View.VISIBLE
            editTextProfissao.visibility = View.VISIBLE
        }
    }
}
