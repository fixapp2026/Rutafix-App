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

class MecanicosAdapter(private val listaMecanicos: List<Mecanico>) :
    RecyclerView.Adapter<MecanicosAdapter.MecanicoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MecanicoViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mecanico, parent, false)
        return MecanicoViewHolder(vista)
    }

    override fun onBindViewHolder(holder: MecanicoViewHolder, position: Int) {
        val mecanico = listaMecanicos[position]
        holder.nombre.text = mecanico.nombre
        holder.descripcion.text = mecanico.descripcion
        holder.precio.text = "Precio base: ${mecanico.precio}"
        holder.foto.setImageResource(mecanico.imagenResId)

        holder.btnContratar.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Has seleccionado a ${mecanico.nombre}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = listaMecanicos.size

    class MecanicoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foto: ImageView = itemView.findViewById(R.id.iv_mecanico_foto)
        val nombre: TextView = itemView.findViewById(R.id.tv_mecanico_nombre)
        val descripcion: TextView = itemView.findViewById(R.id.tv_mecanico_desc)
        val precio: TextView = itemView.findViewById(R.id.tv_mecanico_precio)
        val btnContratar: Button = itemView.findViewById(R.id.btn_contratar_mecanico)
    }
}