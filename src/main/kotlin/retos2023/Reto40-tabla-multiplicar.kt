package retos2023

fun main() {

    /*
    * Reto #40 10/10/2023  TABLA DE MULTIPICAR
    *
    * Crea un programa que sea capaz de solicitarte un número y se
    * encargue de imprimir su tabla de multiplicar entre el 1 y el 10.
    * - Debe visualizarse qué operación se realiza y su resultado.
    *   Ej: 1 x 1 = 1
    *       1 x 2 = 2
    *       1 x 3 = 3
    *       ...
    */

    val numero = pideNumeroPositivo("Tabla de Multipicar")
    pintarTablaMultiplicar(numero)

}

fun pintarTablaMultiplicar(numero: Int) {
    (1..10).forEach(){
        println("$numero x $it = ${numero * it}")
    }
}

