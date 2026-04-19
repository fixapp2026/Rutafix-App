package com.main.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.rutafix.R
import com.main.home.HomeFragment

class CheckoutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_checkout, container, false)

        val btnConfirmPayment = view.findViewById<Button>(R.id.btn_confirm_payment)

        btnConfirmPayment.setOnClickListener {
            // Simular éxito de compra
            Toast.makeText(requireContext(), "¡Compra realizada con éxito!", Toast.LENGTH_LONG).show()
            
            // Regresar al inicio
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }

        return view
    }
}