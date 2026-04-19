package com.main.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rutafix.R

class AdminFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Corregido: ya no busca fragment_blank, usa el placeholder de Rutafix
        return inflater.inflate(R.layout.fragment_placeholder, container, false)
    }
}