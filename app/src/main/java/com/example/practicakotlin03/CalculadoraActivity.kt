package com.example.practicakotlin03

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class CalculadoraActivity : AppCompatActivity() {
    // Declaración de las variables
    private var btnSumar: Button? = null
    private var btnRestar: Button? = null
    private var btnMultiplicar: Button? = null
    private var btnDividir: Button? = null
    private var btnLimpiar: Button? = null
    private var btnRegresar: Button? = null
    private var lblUsuario: TextView? = null
    private var lblResultado: TextView? = null
    private var txtUno: EditText? = null
    private var txtDos: EditText? = null

    // Declarar el Objeto Calculadora
    private var calculadora: Calculadora? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
        iniciarComponentes()

        // Obtener los datos del MainActivity
        val datos = intent.extras
        val usuario = datos!!.getString("usuario")
        lblUsuario!!.text = usuario
        btnSumar!!.setOnClickListener { btnSumar() }
        btnRestar!!.setOnClickListener { btnRestar() }
        btnMultiplicar!!.setOnClickListener { btnMultiplicar() }
        btnDividir!!.setOnClickListener { btnDividir() }
        btnLimpiar!!.setOnClickListener { btnLimpiar() }
        btnRegresar!!.setOnClickListener { btnRegresar() }
    }

    private fun iniciarComponentes() {
        // Botones
        btnSumar = findViewById(R.id.btnSumar)
        btnRestar = findViewById(R.id.btnRestar)
        btnMultiplicar = findViewById(R.id.btnMultiplicar)
        btnDividir = findViewById(R.id.btnDividir)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnRegresar = findViewById(R.id.btnRegresar)

        // Etiquetas
        lblUsuario = findViewById(R.id.lblUsuario)
        lblResultado = findViewById(R.id.lblResultado)

        // Cajas de texto
        txtUno = findViewById(R.id.txtNum1)
        txtDos = findViewById(R.id.txtNum2)

        // Objeto Calculadora
        calculadora = Calculadora(0, 0)
    }

    private fun btnSumar() {
        val num1Text = txtUno!!.text.toString()
        val num2Text = txtDos!!.text.toString()
        if (num1Text.isEmpty() || num2Text.isEmpty()) {
            Toast.makeText(applicationContext, "Rellena todos los campos", Toast.LENGTH_SHORT)
                .show()
        } else {
            calculadora!!.num1 = txtUno!!.text.toString().toFloat().toInt()
            calculadora!!.num2 = txtDos!!.text.toString().toFloat().toInt()
            val total = calculadora!!.suma().toFloat()
            lblResultado!!.text = total.toString()
        }
    }

    private fun btnRestar() {
        val num1Text = txtUno!!.text.toString()
        val num2Text = txtDos!!.text.toString()
        if (num1Text.isEmpty() || num2Text.isEmpty()) {
            Toast.makeText(this.applicationContext, "Rellena todos los campos", Toast.LENGTH_SHORT)
                .show()
        } else {
            calculadora!!.num1 = txtUno!!.text.toString().toFloat().toInt()
            calculadora!!.num2 = txtDos!!.text.toString().toFloat().toInt()
            val total = calculadora!!.resta().toFloat()
            lblResultado!!.text = total.toString()
        }
    }

    private fun btnMultiplicar() {
        val num1Text = txtUno!!.text.toString()
        val num2Text = txtDos!!.text.toString()
        if (num1Text.isEmpty() || num2Text.isEmpty()) {
            Toast.makeText(this.applicationContext, "Rellena todos los campos", Toast.LENGTH_SHORT)
                .show()
        } else {
            calculadora!!.num1 = txtUno!!.text.toString().toFloat().toInt()
            calculadora!!.num2 = txtDos!!.text.toString().toFloat().toInt()
            val total = calculadora!!.multiplicacion().toFloat()
            lblResultado!!.text = total.toString()
        }
    }

    private fun btnDividir() {
        val num1Text = txtUno!!.text.toString()
        val num2Text = txtDos!!.text.toString()
        if (num1Text.isEmpty() || num2Text.isEmpty()) {
            Toast.makeText(this.applicationContext, "Rellena todos los campos", Toast.LENGTH_SHORT)
                .show()
        } else {
            calculadora!!.num1 = txtUno!!.text.toString().toFloat().toInt()
            calculadora!!.num2 = txtDos!!.text.toString().toFloat().toInt()
            val total = calculadora!!.division().toFloat()
            lblResultado!!.text = total.toString()
        }
    }

    private fun btnLimpiar() {
        lblResultado!!.text = ""
        txtUno!!.setText("")
        txtDos!!.setText("")
    }

    private fun btnRegresar() {
        val confirmar = AlertDialog.Builder(this)
        confirmar.setTitle("Calculadora")
        confirmar.setMessage("Regresar al MainActivity")
        confirmar.setPositiveButton(
            "Confirmar"
        ) { dialog, which -> finish() }
        confirmar.setNegativeButton(
            "Cancelar"
        ) { dialog, which ->
            // No hace nada
        }
        confirmar.show()
    }
}