package com.example.appextra3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {

    private lateinit var tv_confirmacion_reserva:TextView
    private lateinit var btn_back2Main:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        initComponents()
        initListeners()
        initUI()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initComponents()
    {
        tv_confirmacion_reserva = findViewById(R.id.tv_confirmacion_reserva)
        btn_back2Main = findViewById(R.id.btn_back2Main)
    }

    private fun initListeners()
    {
        btn_back2Main.setOnClickListener()
        {
            nav2Main()
        }
    }

    private fun initUI()
    {
        val numAsientos:Int = intent.extras?.getInt("NUM_ASIENTOS")?:0
        val nombre:String = intent.extras?.getString("NOMBRE")?:"Nombre_Por_Defecto"
        val time:Int = intent.extras?.getInt("TIME")?:0

        tv_confirmacion_reserva.text = "Reserva confirmada a nombre de " + nombre + " para " + numAsientos + " personas a las " + time + ":00."
    }

    private fun nav2Main()
    {
        var intentMA = Intent(this, MainActivity::class.java)

        startActivity(intentMA)
    }
}