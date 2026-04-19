package com.main.admin

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rutafix.R

// Datos falsos para el video
data class ReporteDummy(val tipo: String, val fecha: String, val cliente: String, val estado: String, val total: String)

class ReportesAdapter(private val listaReportes: List<ReporteDummy>) :
    RecyclerView.Adapter<ReportesAdapter.ReporteViewHolder>() {

    class ReporteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTipo: TextView = itemView.findViewById(R.id.tvTipoServicio)
        val tvFecha: TextView = itemView.findViewById(R.id.tvFechaReporte)
        val tvCliente: TextView = itemView.findViewById(R.id.tvClienteReporte)
        val tvEstado: TextView = itemView.findViewById(R.id.tvEstadoReporte)
        val tvTotal: TextView = itemView.findViewById(R.id.tvTotalReporte)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReporteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_reporte, parent, false)
        return ReporteViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ReporteViewHolder, position: Int) {
        val reporte = listaReportes[position]
        holder.tvTipo.text = reporte.tipo
        holder.tvFecha.text = reporte.fecha
        holder.tvCliente.text = "Cliente: ${reporte.cliente}"
        holder.tvEstado.text = reporte.estado
        holder.tvTotal.text = reporte.total

        holder.itemView.setOnClickListener {
            val intent = android.content.Intent(holder.itemView.context, DetalleReporteActivity::class.java)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listaReportes.size
}