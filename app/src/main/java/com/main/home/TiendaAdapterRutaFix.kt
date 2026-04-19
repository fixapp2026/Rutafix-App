package com.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.rutafix.R

/**
 * Adaptador para el RecyclerView de la tienda RutaFix.
 */
class TiendaAdapterRutaFix(
    private val listaProductos: List<ProductoRutaFix>,
    private val onItemClick: (ProductoRutaFix) -> Unit
) : RecyclerView.Adapter<TiendaAdapterRutaFix.ProductoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_catalogo_producto, parent, false)
        return ProductoViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = listaProductos[position]
        
        holder.imagen.setImageResource(producto.imagenProductoResId)
        holder.nombre.text = producto.nombreProducto
        holder.marca.text = producto.marcaProducto
        holder.precio.text = producto.precioProducto

        // Clic en toda la tarjeta para ver detalle
        holder.itemView.setOnClickListener {
            onItemClick(producto)
        }

        // Acción del botón agregar
        holder.btnAgregar.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Se agregó ${producto.nombreProducto} al carrito",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int = listaProductos.size

    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagen: ImageView = itemView.findViewById(R.id.iv_producto_imagen)
        val nombre: TextView = itemView.findViewById(R.id.tv_producto_nombre)
        val marca: TextView = itemView.findViewById(R.id.tv_producto_marca)
        val precio: TextView = itemView.findViewById(R.id.tv_producto_precio)
        val btnAgregar: AppCompatButton = itemView.findViewById(R.id.btn_producto_agregar)
    }
}
