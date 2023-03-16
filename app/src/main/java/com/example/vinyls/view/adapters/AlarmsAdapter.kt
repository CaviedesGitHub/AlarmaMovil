package com.example.vinyls.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vinyls.R
import com.example.vinyls.databinding.AlarmaItemBinding
import com.example.vinyls.models.Alarma


class AlarmsAdapter : RecyclerView.Adapter<AlarmsAdapter.AlarmsViewHolder>(){

    //var alarms :List<Alarma> = emptyList()
    //    set(value) {
    //        field = value
    //        notifyDataSetChanged()
    //    }

    var alarms :List<Alarma> =listOf<Alarma>(
    Alarma(1, "2023/03/10", "06:00am", "Despertarse", "0111110", "", "Lat=10.464506, Lon=-73.2582494", "Musica, Despacito", "Prender la Luz", "Ninguna"),
    Alarma(2, "2023/04/11", "09:00pm", "Gimnasio", "0101010", "2023/12/30", "Lat=10.464506, Lon=-73.2582494", "Musica, Beep", "Hacer Cuadrado", "Hacer Triangulo"),
    Alarma(3, "2023/02/12", "01:00pm", "Colegio", "0111110", "2023/11/15", "Lat=10.464506, Lon=-73.2582494", "Musica, Infinity", "Ninguna", "Ninguna"),
    Alarma(4, "2023/06/13", "06:00am", "Medicina", "1111111", "2023/12/30", "Lat=10.464506, Lon=-73.2582494", "Tono, Bell", "Ninguna", "Hacer Triangulo")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmsAdapter.AlarmsViewHolder {
        val withDataBinding: AlarmaItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            AlarmsAdapter.AlarmsViewHolder.LAYOUT,
            parent,
            false)
        return AlarmsAdapter.AlarmsViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: AlarmsAdapter.AlarmsViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.alarma = alarms[position]
        }
        holder.viewDataBinding.root.setOnClickListener {
            //val action = FragmentAlbumListDirections.actionFragmentAlbumListToFragmentAlbumDetail(albums[position].name, albums[position].genre, albums[position].cover, albums[position].releaseDate, albums[position].description, albums[position].albumId)
            // Navigate using that action
            //holder.viewDataBinding.root.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return alarms.size
    }


    class AlarmsViewHolder(val viewDataBinding: AlarmaItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.alarma_item
        }
    }


}