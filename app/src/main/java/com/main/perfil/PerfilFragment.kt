package com.main.perfil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.rutafix.R
import com.main.MainActivity
import com.main.home.NotificacionesFragment
import com.main.home.AyudaSoporteFragment

class PerfilFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_perfil, container, false)

        // Referencias a los elementos del layout
        val itemCuenta = view.findViewById<LinearLayout>(R.id.item_perfil_cuenta)
        val btnEditProfile = view.findViewById<Button>(R.id.btn_go_edit_profile)
        val itemVehiculos = view.findViewById<LinearLayout>(R.id.item_perfil_vehiculos)
        val itemSeguridad = view.findViewById<LinearLayout>(R.id.item_perfil_seguridad)
        val itemPrivacidad = view.findViewById<LinearLayout>(R.id.item_perfil_privacidad)
        val itemNotificaciones = view.findViewById<LinearLayout>(R.id.item_perfil_notificaciones)
        val itemAyuda = view.findViewById<LinearLayout>(R.id.item_perfil_ayuda)
        val btnLogout = view.findViewById<Button>(R.id.btn_logout_perfil)

        // 1. Redirección a Editar Perfil (desde el bloque de Cuenta o el botón)
        val openEditProfile = View.OnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, EditProfileFragment())
                .addToBackStack(null)
                .commit()
        }
        itemCuenta?.setOnClickListener(openEditProfile)
        btnEditProfile?.setOnClickListener(openEditProfile)

        // 2. Redirección a Mis Vehículos
        itemVehiculos?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MisVehiculosFragment())
                .addToBackStack(null)
                .commit()
        }

        // 3. Redirección a Seguridad
        itemSeguridad?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SeguridadFragment())
                .addToBackStack(null)
                .commit()
        }

        // 4. Redirección a Privacidad
        itemPrivacidad?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PrivacidadFragment())
                .addToBackStack(null)
                .commit()
        }

        // 5. Redirección a Notificaciones
        itemNotificaciones?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, NotificacionesFragment())
                .addToBackStack(null)
                .commit()
        }

        // 6. Ayuda y Soporte
        itemAyuda?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AyudaSoporteFragment())
                .addToBackStack(null)
                .commit()
        }

        // 7. Cerrar Sesión (Diálogo de confirmación)
        btnLogout?.setOnClickListener {
            (activity as? MainActivity)?.mostrarDialogoCerrarSesion()
        }

        return view
    }
}
