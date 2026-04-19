package com.main.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.rutafix.R
import com.main.home.ProductoRutaFix

class ProductDetailFragment : Fragment() {

    private var producto: ProductoRutaFix? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        producto = arguments?.let {
            ProductoRutaFix(
                idProducto = it.getInt("id"),
                nombreProducto = it.getString("nombre", ""),
                marcaProducto = it.getString("marca", ""),
                descripcionProducto = it.getString("descripcion", ""),
                precioProducto = it.getString("precio", ""),
                imagenProductoResId = it.getInt("imagen")
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detalle_producto, container, false)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar_detail)
        val ivImagen = view.findViewById<ImageView>(R.id.iv_detail_image)
        val tvNombre = view.findViewById<TextView>(R.id.tv_detail_name)
        val tvMarca = view.findViewById<TextView>(R.id.tv_detail_brand)
        val tvPrecio = view.findViewById<TextView>(R.id.tv_detail_price)
        val tvDescripcion = view.findViewById<TextView>(R.id.tv_detail_description)
        val btnAddCart = view.findViewById<Button>(R.id.btn_add_cart_detail)
        val btnBuyNow = view.findViewById<Button>(R.id.btn_buy_now)

        producto?.let {
            tvNombre.text = it.nombreProducto
            tvMarca.text = it.marcaProducto
            tvPrecio.text = it.precioProducto
            tvDescripcion.text = it.descripcionProducto
            ivImagen.setImageResource(it.imagenProductoResId)
        }

        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // Redirección al Checkout con los datos del producto
        btnBuyNow.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CheckoutFragment())
                .addToBackStack(null)
                .commit()
        }

        btnAddCart.setOnClickListener {
            // Lógica para agregar al carrito
        }

        return view
    }

    companion object {
        fun newInstance(producto: ProductoRutaFix): ProductDetailFragment {
            val fragment = ProductDetailFragment()
            val args = Bundle()
            args.putInt("id", producto.idProducto)
            args.putString("nombre", producto.nombreProducto)
            args.putString("marca", producto.marcaProducto)
            args.putString("descripcion", producto.descripcionProducto)
            args.putString("precio", producto.precioProducto)
            args.putInt("imagen", producto.imagenProductoResId)
            fragment.arguments = args
            return fragment
        }
    }
}