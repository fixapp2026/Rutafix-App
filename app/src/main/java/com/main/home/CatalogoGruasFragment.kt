package com.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rutafix.R

class CatalogoGruasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_catalogo_gruas, container, false)

        val rvGruas = view.findViewById<RecyclerView>(R.id.rv_gruas)
        rvGruas.layoutManager = LinearLayoutManager(requireContext())
        
        val listaGruas = ProveedorGruas.obtenerGruas()
        rvGruas.adapter = GruasAdapter(listaGruas)

        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_gruas)
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }
}