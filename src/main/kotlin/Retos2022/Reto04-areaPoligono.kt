package Retos2022

import java.text.DecimalFormat

fun main(){

 /*
 * Reto #4
 * ÁREA DE UN POLÍGONO
 *
 * Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 *
 *  https://github.com/mouredev/Weekly-Challenge-2022-Kotlin
 *
 */

    val triangulo = Triangulo(2.0, 3.5)
    val rectangulo = Rectangulo(3.5, 6.0)
    val cuadrado = Cuadrado(2.6)

    areaPoligono(triangulo)
    areaPoligono(rectangulo)
    areaPoligono(cuadrado)

}

fun areaPoligono(poligono: Poligono){
    val df = DecimalFormat("#.##")
    val roundoff = df.format(poligono.getArea())
    println(roundoff)
}

interface Poligono{
    fun getArea():Double
}

class Triangulo(var base:Double, var altura:Double):Poligono{
    override fun getArea(): Double {
        return (base * altura) / 2
    }
}
class Rectangulo(var base:Double, var altura:Double):Poligono{
    override fun getArea(): Double {
        return (base * altura)
    }
}
class Cuadrado(var lado:Double):Poligono{
    override fun getArea(): Double {
        return lado * lado
    }
}