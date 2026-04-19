package com.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.rutafix.R

class SolicitarServicioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_solicitar_servicio, container, false)

        val cardCrane = view.findViewById<CardView>(R.id.card_service_crane)
        val cardMechanic = view.findViewById<CardView>(R.id.card_service_mechanic)
        val cardLocksmith = view.findViewById<CardView>(R.id.card_service_locksmith)
        val cardStations = view.findViewById<CardView>(R.id.card_service_stations)
        val cardTracking = view.findViewById<CardView>(R.id.card_service_tracking)

        // 1. Redirección a Seguimiento de Servicio (Botón Naranja)
        cardTracking?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SeguimientoServicioFragment())
                .addToBackStack(null)
                .commit()
        }

        // 2. Redirección a Catálogo de Grúas
        cardCrane?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CatalogoGruasFragment())
                .addToBackStack(null)
                .commit()
        }

        // 3. Redirección a Contratar Mecánico
        cardMechanic?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ContratarMecanicoFragment())
                .addToBackStack(null)
                .commit()
        }

        // 4. Redirección a Cerrajero Vial
        cardLocksmith?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ContratarCerrajeroFragment())
                .addToBackStack(null)
                .commit()
        }

        // 5. Redirección a Estaciones de Servicio (Mapa)
        cardStations?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, EstacionesServicioFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}