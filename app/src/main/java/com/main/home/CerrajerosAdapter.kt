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

class CerrajerosAdapter(private val listaCerrajeros: List<Cerrajero>) :
    RecyclerView.Adapter<CerrajerosAdapter.CerrajeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CerrajeroViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cerrajero, parent, false)
        return CerrajeroViewHolder(vista)
    }

    override fun onBindViewHolder(holder: CerrajeroViewHolder, position: Int) {
        val cerrajero = listaCerrajeros[position]
        holder.nombre.text = cerrajero.nombre
        holder.descripcion.text = cerrajero.descripcion
        holder.precio.text = "Precio base: ${cerrajero.precio}"
        holder.foto.setImageResource(cerrajero.imagenResId)

        holder.btnContratar.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Has seleccionado a ${cerrajero.nombre}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = listaCerrajeros.size

    class CerrajeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foto: ImageView = itemView.findViewById(R.id.iv_cerrajero_foto)
        val nombre: TextView = itemView.findViewById(R.id.tv_cerrajero_nombre)
        val descripcion: TextView = itemView.findViewById(R.id.tv_cerrajero_desc)
        val precio: TextView = itemView.findViewById(R.id.tv_cerrajero_precio)
        val btnContratar: Button = itemView.findViewById(R.id.btn_contratar_cerrajero)
    }
}