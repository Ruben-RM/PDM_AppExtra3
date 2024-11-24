package com.example.appextra3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var cv_2asientos:CardView
    private lateinit var cv_4asientos:CardView
    private lateinit var cv_8asientos:CardView
    private var numAsientos = 2
    private lateinit var et_name:EditText
    private var nombre = ""
    private lateinit var tv_time:TextView
    private var time = 20
    private lateinit var btn_less_time:FloatingActionButton
    private lateinit var btn_more_time:FloatingActionButton
    private lateinit var btn_add_reserva:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        initComponents()
        initListeners()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initComponents()
    {
        cv_2asientos = findViewById(R.id.cv_2asientos)
        cv_4asientos = findViewById(R.id.cv_4asientos)
        cv_8asientos = findViewById(R.id.cv_8asientos)
        et_name = findViewById(R.id.text_name)
        tv_time = findViewById(R.id.text_time)
        btn_less_time = findViewById(R.id.btn_less_time)
        btn_more_time = findViewById(R.id.btn_more_time)
        btn_add_reserva = findViewById(R.id.btn_add_reserva)
    }

    private fun initListeners()
    {
        cv_2asientos.setOnClickListener()
        {
            numAsientos = 2
            setCardViewsBackgrounds()
        }
        cv_4asientos.setOnClickListener()
        {
            numAsientos = 4
            setCardViewsBackgrounds()
        }
        cv_8asientos.setOnClickListener()
        {
            numAsientos = 8
            setCardViewsBackgrounds()
        }

        btn_less_time.setOnClickListener()
        {
            time--
            if(time < 20)
                time = 22

            set_tvTime()
        }

        btn_more_time.setOnClickListener()
        {
            time++
            if(time > 22)
                time = 20

            set_tvTime()
        }

        btn_add_reserva.setOnClickListener()
        {
            nombre = et_name.text.toString()

            if(nombre.equals(""))
                Toast.makeText(this, "¡No dejes el nombre vacío!", Toast.LENGTH_SHORT).show()
            else
                nav2confirmationScreen()
        }
    }

    private fun setCardViewsBackgrounds()
    {
        when(numAsientos)
        {
            2 -> {
                cv_2asientos.setCardBackgroundColor(ContextCompat.getColor(this, R.color.bg_cardView_selected))
                cv_4asientos.setCardBackgroundColor(ContextCompat.getColor(this, R.color.bg_cardView))
                cv_8asientos.setCardBackgroundColor(ContextCompat.getColor(this, R.color.bg_cardView))
            }
            4 -> {
                cv_2asientos.setCardBackgroundColor(ContextCompat.getColor(this, R.color.bg_cardView))
                cv_4asientos.setCardBackgroundColor(ContextCompat.getColor(this, R.color.bg_cardView_selected))
                cv_8asientos.setCardBackgroundColor(ContextCompat.getColor(this, R.color.bg_cardView))
            }
            8 -> {
                cv_2asientos.setCardBackgroundColor(ContextCompat.getColor(this, R.color.bg_cardView))
                cv_4asientos.setCardBackgroundColor(ContextCompat.getColor(this, R.color.bg_cardView))
                cv_8asientos.setCardBackgroundColor(ContextCompat.getColor(this, R.color.bg_cardView_selected))
            }
        }
    }

    private fun set_tvTime()
    {
        tv_time.text = time.toString() + ":00"
    }

    private fun nav2confirmationScreen()
    {
        var intentCA = Intent(this, ConfirmationActivity::class.java)

        startActivity(intentCA)
    }
}