package com.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rutafix.R

class ContratarMecanicoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contratar_mecanico, container, false)

        val rvMecanicos = view.findViewById<RecyclerView>(R.id.rv_mecanicos)
        rvMecanicos.layoutManager = LinearLayoutManager(requireContext())
        
        val listaMecanicos = ProveedorMecanicos.obtenerMecanicos()
        rvMecanicos.adapter = MecanicosAdapter(listaMecanicos)

        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_mecanicos)
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }
}