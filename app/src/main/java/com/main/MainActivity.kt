package com.main

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.rutafix.Login
import com.example.rutafix.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.main.home.HomeFragment
import com.main.home.NotificacionesFragment
import com.main.home.ComunidadFragment
import com.main.home.SolicitarServicioFragment
import com.main.home.AyudaSoporteFragment
import com.main.perfil.PerfilFragment
import com.main.products.ProductsFragment
import com.main.products.CarritoFragment

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val btnCart = findViewById<FrameLayout>(R.id.btn_toolbar_cart)

        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        btnCart.setOnClickListener {
            reemplazarFragmento(CarritoFragment(), "Mi Carrito")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }

        if (savedInstanceState == null) {
            reemplazarFragmento(HomeFragment(), "Inicio")
        }

        // --- Lógica Menú Lateral ---
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_drawer_home -> reemplazarFragmento(HomeFragment(), "Inicio")
                R.id.nav_drawer_products -> reemplazarFragmento(ProductsFragment(), "Tienda")
                R.id.nav_drawer_services -> reemplazarFragmento(SolicitarServicioFragment(), "Servicios")
                R.id.nav_drawer_profile -> reemplazarFragmento(PerfilFragment(), "Mi Cuenta")
                R.id.nav_drawer_logout -> mostrarDialogoCerrarSesion()
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // --- Lógica Menú Inferior ---
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_bottom_home -> {
                    reemplazarFragmento(HomeFragment(), "Inicio")
                    true
                }
                R.id.nav_bottom_products -> {
                    reemplazarFragmento(ProductsFragment(), "Tienda")
                    true
                }
                R.id.nav_bottom_grua -> {
                    reemplazarFragmento(SolicitarServicioFragment(), "Solicitar")
                    true
                }
                R.id.nav_bottom_favorites -> {
                    reemplazarFragmento(ComunidadFragment(), "Comunidad")
                    true
                }
                R.id.nav_bottom_profile -> {
                    reemplazarFragmento(PerfilFragment(), "Mi Cuenta")
                    true
                }
                else -> false
            }
        }
    }

    fun reemplazarFragmento(fragment: Fragment, titulo: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    fun mostrarDialogoCerrarSesion() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.dialog_logout)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnConfirm = dialog.findViewById<Button>(R.id.btn_confirm_logout)
        val btnCancel = dialog.findViewById<Button>(R.id.btn_cancel_logout)

        btnConfirm.setOnClickListener {
            dialog.dismiss()
            val intent = Intent(this, Login::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}