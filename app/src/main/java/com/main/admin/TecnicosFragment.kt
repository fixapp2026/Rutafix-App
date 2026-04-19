package com.main.admin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rutafix.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TecnicosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tecnicos, container, false)

        val recyclerTecnicos = view.findViewById<RecyclerView>(R.id.recyclerTecnicos)
        val fabAgregarTecnico = view.findViewById<FloatingActionButton>(R.id.fabAgregarTecnico)

        // Creamos nuestra lista "quemada" para la presentación visual
        val listaDePrueba = listOf(
            TecnicoDummy("Carlos Rodríguez", "Especialista en motores y frenos.", "Precio base: 45.000 COP"),
            TecnicoDummy("Ana Gómez", "Sistemas eléctricos y escaneo.", "Precio base: 55.000 COP"),
            TecnicoDummy("Roberto Pérez", "Mecánica general y fluidos.", "Precio base: 40.000 COP"),
            TecnicoDummy("Luis Martínez", "Suspensión y dirección.", "Precio base: 50.000 COP")
        )

        // Configuramos el RecyclerView
        recyclerTecnicos.layoutManager = LinearLayoutManager(requireContext())
        recyclerTecnicos.adapter = TecnicosAdapter(listaDePrueba)

        // Acción interactiva del botón
        fabAgregarTecnico.setOnClickListener {
            // Reemplazamos el Toast por el Intent
            val intent = Intent(requireContext(), AgregarTecnicoActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}