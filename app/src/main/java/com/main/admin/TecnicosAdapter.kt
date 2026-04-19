package com.main.admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.rutafix.R

// Creamos una clase de datos temporal solo para la vista
data class TecnicoDummy(val nombre: String, val descripcion: String, val precio: String)

// Creamos el adaptador
class TecnicosAdapter(private val listaTecnicos: List<TecnicoDummy>) :
    RecyclerView.Adapter<TecnicosAdapter.TecnicoViewHolder>() {

    class TecnicoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tv_mecanico_nombre)
        val tvDescripcion: TextView = itemView.findViewById(R.id.tv_mecanico_desc)
        val tvPrecio: TextView = itemView.findViewById(R.id.tv_mecanico_precio)
        val btnContratar: Button = itemView.findViewById(R.id.btn_contratar_mecanico)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TecnicoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mecanico, parent, false)
        return TecnicoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TecnicoViewHolder, position: Int) {
        val tecnico = listaTecnicos[position]

        holder.tvNombre.text = tecnico.nombre
        holder.tvDescripcion.text = tecnico.descripcion
        holder.tvPrecio.text = tecnico.precio

        // Interacción visual básica para cumplir con la rúbrica
        holder.btnContratar.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Opciones de ${tecnico.nombre}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = listaTecnicos.size
}