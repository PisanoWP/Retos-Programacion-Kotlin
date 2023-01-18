package Retos2022
fun main(){
    /*
     * Reto #2
     * LA SUCESIÓN DE FIBONACCI
     *
     * Enunciado: Escribe un programa que imprima los 50 primeros números de la sucesión de Fibonacci empezando en 0.
     * La serie Fibonacci se compone por una sucesión de números en la que el siguiente siempre es la suma de los dos anteriores.
     * 0, 1, 1, 2, 3, 5, 8, 13...
     *
     * https://github.com/mouredev/Weekly-Challenge-2022-Kotlin
     *
     */

    fibonacci(50)
}

fun fibonacci(numVeces: Int){
    var num1 : Long = 0
    print("$num1, ")
    var num2 : Long = 1

    var num3:Long
    for (i in 1..numVeces){
        print("$num2, ")
        /* Como toda la vida de dios, usando una variable auxiliar
        num3 = num1 + num2
        num1 = num2
        num2 = num3*/

        // Nivel pro, usando la función de extension also
        num1 = num2.also {
            num2 += num1
        }

    }



}
