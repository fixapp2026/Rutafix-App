package com.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rutafix.R

class EstacionesServicioFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_estaciones_servicio, container, false)
        
        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_stations)
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
        
        return view
    }
}