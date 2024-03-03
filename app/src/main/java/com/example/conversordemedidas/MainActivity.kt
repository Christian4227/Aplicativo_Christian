package com.example.conversordemedidas

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Spinner(this)
        ImageView(this)
        TextView(this)
        val spnlista = findViewById<Spinner>(R.id.spinner)
        val image = findViewById<ImageView>(R.id.imageView2)
        val txtmedida = findViewById<TextView>(R.id.txtInforma)
        val textMedida1 = findViewById<TextView>(R.id.textView)
        val textMedida2 = findViewById<TextView>(R.id.textView2)
        spnlista.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> {
                        image.setImageResource(R.drawable.imagem_sistemas_medidas)
                        textMedida1.text = ""
                        textMedida2.text = ""
                    }
                    1 -> {
                        image.setImageResource(R.drawable.polegada)
                        textMedida1.setText(R.string.polegada)
                        textMedida2.setText(R.string.centimetro)
                    }
                    2 -> {
                        image.setImageResource(R.drawable.medida_altura)
                        textMedida1.setText(R.string.pes)
                        textMedida2.setText(R.string.metros)
                    }
                    3 -> {
                        image.setImageResource(R.drawable.quilometragem)
                        txtmedida.setText(R.string.milha)
                        textMedida1.setText(R.string.milha)
                        textMedida2.setText(R.string.quilometro)
                    }
                    4 -> {
                        image.setImageResource(R.drawable.temperatura_calor_capa)
                        textMedida1.setText(R.string.celsius)
                        textMedida2.setText(R.string.farenheint)
                    }
                    5 -> {
                        image.setImageResource(R.drawable.nos)
                        textMedida1.setText(R.string.nos)
                        textMedida2.setText(R.string.km_h)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    fun btnLimpar(view: View?) {
        val valor = findViewById<EditText>(R.id.editText1)
        val txtmedida = findViewById<TextView>(R.id.txtInforma)
        valor.setText("")
        txtmedida.setText(R.string.valor_vazio)
    }

    fun btnTrocar(view: View?) {
        val valor = findViewById<EditText>(R.id.editText1)
        val textMedida1 = findViewById<TextView>(R.id.textView)
        val textMedida2 = findViewById<TextView>(R.id.textView2)
        val med1 = textMedida1.text.toString()
        val med2 = textMedida2.text.toString()
        textMedida1.text = med2
        textMedida2.text = med1
        val entrada = valor.text.toString()
        conversao(entrada)
    }

    fun btnCalcular(view: View?) {
        val valor = findViewById<EditText>(R.id.editText1)
        val entrada = valor.text.toString()
        conversao(entrada)
    }

    fun conversao(entrada: String) {
        val txtmedida = findViewById<TextView>(R.id.txtInforma)
        val textMedida1 = findViewById<TextView>(R.id.textView)
        if (entrada == "") txtmedida.setText(R.string.valor_vazio) else {
            var numero = entrada.toFloat()
            if (textMedida1.text.toString() == "Polegada") {
                val resultado = numero * 2.54
                val formatado = DecimalFormat("0.00")
                val textResultado =
                    formatado.format(resultado) + " Centímetros" + "\n Unidade de Medida - SI"
                txtmedida.text = textResultado
            } else if (textMedida1.text.toString() == "Centímetro") {
                val resultado = numero * 0.39
                val formatado = DecimalFormat("0.00")
                val textResultado =
                    formatado.format(resultado) + " Polegadas" + "\n Unidade de Medida - EUA"
                txtmedida.text = textResultado
            } else if (textMedida1.text.toString() == "Pés") {
                val resultado = numero * 0.3
                val formatado = DecimalFormat("0.00")
                val textResultado =
                    formatado.format(resultado) + " Metros" + "\n Unidade de Medida - SI"
                txtmedida.text = textResultado
            } else if (textMedida1.text.toString() == "Metros") {
                val resultado = numero * 3.28
                val formatado = DecimalFormat("0.00")
                val textResultado = formatado.format(resultado) + " Pés" + "\n SI Antiga - EUA"
                txtmedida.text = textResultado
            } else if (textMedida1.text.toString() == "Milha") {
                val resultado = numero * 1.6
                val formatado = DecimalFormat("0.00")
                val textResultado =
                    formatado.format(resultado) + " Quilometros" + "\n Unidade de Medida SI"
                txtmedida.text = textResultado
            } else if (textMedida1.text.toString() == "Quilometros") {
                val resultado = numero * 0.62
                val formatado = DecimalFormat("0.00")
                val textResultado = formatado.format(resultado) + " Milhas" + "\n SI Antiga - EUA"
                txtmedida.text = textResultado
            } else if (textMedida1.text.toString() == "Celsius") {
                val resultado = numero * 1.8 + 32
                val formatado = DecimalFormat("0.00")
                val textResultado = formatado.format(resultado) + "ºF" + "\n SI Antiga - EUA"
                txtmedida.text = textResultado
            } else if (textMedida1.text.toString() == "Farenheint") {
                val resultado = ((numero - 32) * 5 / 9).toDouble()
                val formatado = DecimalFormat("0.00")
                val textResultado = formatado.format(resultado) + "ºC" + "\n Unidade de Medida - SI"
                txtmedida.text = textResultado
            } else if (textMedida1.text.toString() == "Nós") {
                val resultado = numero * 1.8
                val formatado = DecimalFormat("0.00")
                val textResultado =
                    formatado.format(resultado) + " Km/h" + "\n Unidade de Medida - SI"
                txtmedida.text = textResultado
            } else if (textMedida1.text.toString() == "Km/h") {
                val resultado = numero * 0.5
                val formatado = DecimalFormat("0.00")
                val textResultado = formatado.format(resultado) + " Nós" + "\n SI Antiga - EUA"
                txtmedida.text = textResultado
            }
        }
    }

    fun btnEnviaWhatsapp(view: View?) {
        val valor = findViewById<EditText>(R.id.editText1)
        val txtmedida = findViewById<TextView>(R.id.txtInforma)
        val num = valor.text.toString()
        if (num != "") {
            val pm = packageManager
            try {
                val intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_TEXT, txtmedida!!.text.toString())
                intent.setPackage("com.whatsapp")
                startActivity(intent)
            } catch (e: PackageManager.NameNotFoundException) {
                Toast.makeText(this, "Não foi possível enviar a mensagem", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Digite algum valor na caixa de texto", Toast.LENGTH_SHORT).show()
        }
    }

    fun btnEnviaGoogleDocs(view: View?) {
        val valor = findViewById<EditText>(R.id.editText1)
        val txtmedida = findViewById<TextView>(R.id.txtInforma)
        val num = valor.text.toString()
        if (num != "") {
            val pm = packageManager
            try {
                val intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_TEXT, txtmedida!!.text.toString())
                intent.putExtra(Intent.EXTRA_SUBJECT, "Nota da atividade Intents - ILP 506")
                intent.setPackage("com.google.android.apps.docs")
                startActivity(intent)
            } catch (e: PackageManager.NameNotFoundException) {
                Toast.makeText(this, "Não foi possível enviar a mensagem", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Digite algum valor na caixa de texto", Toast.LENGTH_SHORT).show()
        }
    }

    fun btnEnviaGmail(view: View?) {
        val valor = findViewById<EditText>(R.id.editText1)
        val txtmedida = findViewById<TextView>(R.id.txtInforma)
        val num = valor.text.toString()
        if (num != "") {
            val pm = packageManager
            try {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("chriscubo@gmail.com"))
                intent.putExtra(Intent.EXTRA_SUBJECT, "Nota da atividade Intents - Matéria ILP 506")
                intent.putExtra(Intent.EXTRA_TEXT, txtmedida?.text.toString())
                intent.setPackage("com.google.android.gm")
                startActivity(Intent.createChooser(intent, "Send Email"))
            } catch (e: PackageManager.NameNotFoundException) {
                Toast.makeText(this, "Não foi possível enviar a mensagem", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Digite algum valor na caixa de texto", Toast.LENGTH_SHORT).show()
        }
    }
}
