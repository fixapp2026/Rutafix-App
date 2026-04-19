package com.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.rutafix.R

class NotificacionesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_placeholder, container, false)
        view.findViewById<TextView>(R.id.tv_placeholder_titulo).text = "Notificaciones"
        view.findViewById<TextView>(R.id.tv_placeholder_mensaje).text = "Mantente al tanto de tus servicios y promociones aquí."
        return view
    }
}