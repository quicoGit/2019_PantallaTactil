package com.plumbaria.e_5_8_pantallatactil

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnTouchListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val entrada:TextView = findViewById(R.id.textViewEntrada)
        entrada.setOnTouchListener(this)
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        val salida:TextView = findViewById(R.id.textViewSalida)
        salida.append("\n " + event.toString() + "\n  Presión:" + event?.pressure + "\n Tamaño:" + event?.size + "\n")
        return true
    }


}
