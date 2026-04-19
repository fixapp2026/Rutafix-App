package com.example.rutafix.main.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rutafix.R
import com.main.admin.ReporteDummy
import com.main.admin.ReportesAdapter

class ReportesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reportes, container, false)

        val recyclerReportes = view.findViewById<RecyclerView>(R.id.recyclerReportes)

        // Creamos una lista falsa
        val listaDePrueba = listOf(
            ReporteDummy("Grúa de Plataforma", "19 Abr 2026", "Andrés Felipe", "Completado", "120.000 COP"),
            ReporteDummy("Mecánico Vial", "18 Abr 2026", "María Camila", "Completado", "45.000 COP"),
            ReporteDummy("Cerrajero Vial", "18 Abr 2026", "Luis Carlos", "En proceso", "50.000 COP"),
            ReporteDummy("Paso de Corriente", "17 Abr 2026", "Diana Marcela", "Cancelado", "30.000 COP"),
            ReporteDummy("Grúa Pesada", "15 Abr 2026", "Empresa XYZ", "Completado", "250.000 COP")
        )

        recyclerReportes.layoutManager = LinearLayoutManager(requireContext())
        recyclerReportes.adapter = ReportesAdapter(listaDePrueba)

        return view
    }
}