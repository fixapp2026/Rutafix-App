package com.main.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rutafix.R
import com.main.home.ProveedorProductosRutaFix
import com.main.home.TiendaAdapterRutaFix

/**
 * Fragmento que muestra el Catálogo de Productos (RecyclerView).
 */
class ProductsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.fragment_home_tienda, container, false)

        val rvCatalogo = vista.findViewById<RecyclerView>(R.id.rv_home_catalogo_automotriz)
        rvCatalogo.layoutManager = LinearLayoutManager(requireContext())

        val listaProductos = ProveedorProductosRutaFix.obtenerListaProductos()
        
        // Configuramos el adaptador con la acción de clic para abrir el detalle
        rvCatalogo.adapter = TiendaAdapterRutaFix(listaProductos) { producto ->
            val detalleFragment = ProductDetailFragment.newInstance(producto)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, detalleFragment)
                .addToBackStack(null)
                .commit()
        }

        return vista
    }
}
