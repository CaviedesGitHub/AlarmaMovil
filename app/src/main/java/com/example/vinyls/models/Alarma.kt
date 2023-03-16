package com.example.vinyls.models

data class Alarma (
    val alarmaId:Int,
    val fecha:String,
    val hora:String,
    val nombre:String,
    val repite:String,
    val fecha_fin:String,
    val ubicacion:String,
    val sonido:String,
    val cancelar:String,
    val posponer:String
)
