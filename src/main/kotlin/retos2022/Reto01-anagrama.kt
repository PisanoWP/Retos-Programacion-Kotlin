package retos2022

fun main(){
    /*
    * Reto #1
    * ¿ES UN ANAGRAMA?
    *
    * Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
    * Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
    * NO hace falta comprobar que ambas palabras existan.
    * Dos palabras exactamente iguales no son anagrama.
    *
    */
    val palabra1 = "amor"
    val palabra2 = "ROMA"

    println(isAnagrama(palabra1, palabra2))

    println("Otra Solución:")
    println(isAnagram(palabra1, palabra2))


}

fun isAnagrama(pal1:String, pal2:String):Boolean{

    if (pal1.lowercase() == pal2.lowercase())
        return false

    val palabra1: List<Char> = pal1.lowercase().toList()
    val palabra2: List<Char> = pal2.lowercase().toList()

    return palabra1.sorted()==palabra2.sorted()

}

// Otra posible solución:
// https://github.com/mouredev/Weekly-Challenge-2022-Kotlin/blob/main/app/src/main/java/com/mouredev/weeklychallenge2022/Challenge1.kt
private fun isAnagram(wordOne: String, wordTwo: String): Boolean {
    if (wordOne.lowercase() == wordTwo.lowercase()) {
        return false
    }
    return wordOne.lowercase().toCharArray().sortedArray().contentEquals(wordTwo.lowercase().toCharArray().sortedArray())
}