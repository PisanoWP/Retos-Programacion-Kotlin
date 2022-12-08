/*
 * Reto #6
 * INVIRTIENDO CADENAS
 *
 * Enunciado: Crea un programa que invierta el orden de una cadena de texto sin usar funciones propias del lenguaje que lo hagan de forma automática.
 * - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
 *
 */

fun main() {
    var cadena: String = "Hola Mundo ¿Qué tal estas?"

    println(invertirCadena(cadena))

}

fun invertirCadena(cadena: String): String {

    var cadenaInvertida: String = ""
    (cadena.length - 1 downTo 0).forEach() {
        cadenaInvertida += cadena[it]
    }
    return cadenaInvertida
}