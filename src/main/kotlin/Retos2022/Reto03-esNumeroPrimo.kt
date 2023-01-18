package Retos2022
fun main(){

    /*
     * Reto #3
     * ¿ES UN NÚMERO PRIMO?
     *
     * Enunciado: Escribe un programa que se encargue de comprobar si un número es o no primo.
     * Hecho esto, imprime los números primos entre 1 y 100.
     *
     * https://github.com/mouredev/Weekly-Challenge-2022-Kotlin
     *
     */
    val numero = 3

    println("El número $numero es primo => ${esPrimo(4)}")

/*
    for (i in 1..100){
        if (esPrimo(i))
            println ("El número $i es primo")
    }
*/
    (1..100).forEach { numero ->
        if (esPrimo(numero))
            println ("El número $numero es primo")
    }

}

fun esPrimo(numero:Int):Boolean {

    if (numero < 2)
        return false

    for (i in 2 until numero) {
        if (numero % i == 0)
            return false
    }

    return true

    /*
    if (numero ==0 ||numero ==1)
        return false
    else{
        for (i in 2..numero-1){
            if ((numero%i)==0)
                return false
        }
        return true
    }*/

}