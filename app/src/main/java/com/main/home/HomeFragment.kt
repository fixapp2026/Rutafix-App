package com.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.rutafix.R
import com.main.products.ProductsFragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val cardRequestService = view.findViewById<CardView>(R.id.card_request_service)
        val cardShop = view.findViewById<CardView>(R.id.card_shop)
        val cardFeaturedCrane = view.findViewById<CardView>(R.id.card_featured_crane)
        val cardFeaturedMechanic = view.findViewById<CardView>(R.id.card_featured_mechanic)

        // Navegación a Solicitar Servicio
        val openSolicitar = View.OnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SolicitarServicioFragment())
                .addToBackStack(null)
                .commit()
        }
        cardRequestService.setOnClickListener(openSolicitar)

        // Navegación a Tienda
        cardShop.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProductsFragment())
                .addToBackStack(null)
                .commit()
        }

        // Navegación desde Servicios Destacados
        cardFeaturedCrane.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CatalogoGruasFragment())
                .addToBackStack(null)
                .commit()
        }

        cardFeaturedMechanic.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ContratarMecanicoFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}