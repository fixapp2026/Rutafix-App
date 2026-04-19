package com.main.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rutafix.R

class TecnicosFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Usa tu layout placeholder por ahora para que no de error
        return inflater.inflate(R.layout.fragment_placeholder, container, false)
    }
}