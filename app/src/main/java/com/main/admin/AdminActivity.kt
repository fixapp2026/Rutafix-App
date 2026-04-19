package com.main.admin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.rutafix.R
import com.example.rutafix.main.admin.ReportesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class AdminActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Necesitarás crear un archivo activity_admin.xml con el BottomNavigationView
        setContentView(R.layout.activity_admin)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation_admin)

        // Cargar Fragment inicial por defecto
        if (savedInstanceState == null) {
            replaceFragment(TecnicosFragment())
        }

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_admin_tecnicos -> replaceFragment(TecnicosFragment())
                R.id.nav_admin_reportes -> replaceFragment(ReportesFragment())
                R.id.nav_admin_ajustes -> replaceFragment(AdminAjustesFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_admin, fragment)
            .commit()
    }
}