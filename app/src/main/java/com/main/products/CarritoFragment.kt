package com.main.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.rutafix.R

class CarritoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_carrito, container, false)

        val btnContinueShopping = view.findViewById<TextView>(R.id.btn_continue_shopping)
        val btnCheckout = view.findViewById<Button>(R.id.btn_checkout)

        btnContinueShopping.setOnClickListener {
            // Regresar a la tienda (ProductsFragment)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProductsFragment())
                .commit()
        }

        btnCheckout.setOnClickListener {
            // Ir a la pantalla de Finalización de Compra (CheckoutFragment)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CheckoutFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}