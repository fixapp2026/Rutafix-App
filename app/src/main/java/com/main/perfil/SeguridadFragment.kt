package com.main.perfil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.rutafix.R

class SeguridadFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_placeholder, container, false)
        view.findViewById<TextView>(R.id.tv_placeholder_titulo).text = "Seguridad"
        view.findViewById<TextView>(R.id.tv_placeholder_mensaje).text = "Aquí podrás cambiar tu contraseña y gestionar la seguridad de tu cuenta."
        return view
    }
}