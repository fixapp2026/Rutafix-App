package com.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.rutafix.R

class GruasAdapter(private val listaGruas: List<Grua>) :
    RecyclerView.Adapter<GruasAdapter.GruaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GruaViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grua, parent, false)
        return GruaViewHolder(vista)
    }

    override fun onBindViewHolder(holder: GruaViewHolder, position: Int) {
        val grua = listaGruas[position]
        holder.tipo.text = grua.tipo
        holder.capacidad.text = "Capacidad: ${grua.capacidad}"
        holder.tiempo.text = "Tiempo: ${grua.tiempoEstimado}"
        holder.precio.text = "Precio base: ${grua.precio}"
        
        // Usando el recurso del sistema directamente para evitar errores de referencia interna
        holder.foto.setImageResource(android.R.drawable.ic_menu_compass)

        holder.btnPedir.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Has solicitado una ${grua.tipo}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = listaGruas.size

    class GruaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foto: ImageView = itemView.findViewById(R.id.iv_grua_foto)
        val tipo: TextView = itemView.findViewById(R.id.tv_grua_tipo)
        val capacidad: TextView = itemView.findViewById(R.id.tv_grua_capacidad)
        val tiempo: TextView = itemView.findViewById(R.id.tv_grua_tiempo)
        val precio: TextView = itemView.findViewById(R.id.tv_grua_precio)
        val btnPedir: Button = itemView.findViewById(R.id.btn_seleccionar_grua)
    }
}