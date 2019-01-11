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

        var acciones:Array<String> = arrayOf("ACTION_DOWN","ACTION_UP","ACTION_MOVE",
            "ACTION_CANCEL", "ACTION_OUTSIDE", "ACTION_POINTER_DOWN", "ACTION_POINTER_UP")
        var accion:Int? = event?.action
        var codigoAccion:Int? = accion?.and(MotionEvent.ACTION_MASK)
        var iPuntero = (accion?.and(MotionEvent.ACTION_POINTER_INDEX_MASK))?.shr(MotionEvent.ACTION_POINTER_INDEX_SHIFT)
        salida.append("\n" + acciones[codigoAccion!!])
        salida.append(" Generada por puntero: " + iPuntero)
        for (i in 0..(event?.pointerCount!!-1)){
            salida.append("\npuntero:" + event?.getPointerId(i) +
                    " x:" + event.getX(i) + " y:" + event.getY(i)
            )
        }
        salida.append("\n")
        return true
    }


}
