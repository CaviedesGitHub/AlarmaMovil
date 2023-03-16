package com.example.vinyls.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.vinyls.R
import com.example.vinyls.database.VinylRoomDatabase
import com.example.vinyls.models.Alarma
import com.example.vinyls.models.Album
import com.example.vinyls.network.NetworkServiceAdapter
import com.example.vinyls.repositories.AlbumRepository
import com.example.vinyls.repositories.MusicianRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragViewModel(application: Application) :  AndroidViewModel(application) {
        private val _alarmas = MutableLiveData<List<Alarma>>()

        val alarmas: LiveData<List<Alarma>>
            get() = _alarmas

        val lstAlarmas:List<Alarma>

        init {
            lstAlarmas=listOf<Alarma>(
                    Alarma(1, "2023/03/10", "06:00am", "Despertarse", "0111110", "", "Lat=10.464506, Lon=-73.2582494", "Musica, Despacito", "Prender la Luz", "Ninguna"),
                    Alarma(2, "2023/04/11", "09:00pm", "Gimnasio", "0101010", "2023/12/30", "Lat=10.464506, Lon=-73.2582494", "Musica, Beep", "Hacer Cuadrado", "Hacer Triangulo"),
                    Alarma(3, "2023/02/12", "01:00pm", "Colegio", "0111110", "2023/11/15", "Lat=10.464506, Lon=-73.2582494", "Musica, Infinity", "Ninguna", "Ninguna"),
                    Alarma(4, "2023/06/13", "06:00am", "Medicina", "1111111", "2023/12/30", "Lat=10.464506, Lon=-73.2582494", "Tono, Bell", "Ninguna", "Hacer Triangulo")
                )
        }

        class Factory(val app: Application) : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(MainFragViewModel::class.java)) {
                    @Suppress("UNCHECKED_CAST")
                    return MainFragViewModel(app) as T
                }
                throw IllegalArgumentException("Unable to construct viewmodel")
            }
        }

}