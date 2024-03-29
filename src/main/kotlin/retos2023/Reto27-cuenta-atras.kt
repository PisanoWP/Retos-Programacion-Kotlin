﻿package retos2023

fun main() {

    /*
    * Reto #27 03/07/2023 CUENTA ATRÁS
    *
    * Crea una función que reciba dos parámetros para crear una cuenta atrás.
    * - El primero, representa el número en el que comienza la cuenta.
    * - El segundo, los segundos que tienen que transcurrir entre cada cuenta.
    * - Sólo se aceptan números enteros positivos.
    * - El programa finaliza al llegar a cero.
    * - Debes imprimir cada número de la cuenta atrás.
    *
    */

    val start = pideNumeroPositivo( "Valor inicial")
    val interval = pideNumeroPositivo( "Intervalo en segundos")

    initCountDown(start, interval)

}

fun initCountDown(start:Int, interval:Int) {
    println("Inicio cuenta atrás ...")

    (start downTo 0).forEach {
        print("\r${it}")
        Thread.sleep((interval*1000).toLong())

    }
    println()
    println("Fin")

}




