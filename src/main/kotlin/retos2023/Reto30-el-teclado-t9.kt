package retos2023

fun main() {

    /*
    * Reto #30 24/07/2023 EL TECLADO T9
    *
    * Los primeros dispositivos móviles tenían un teclado llamado T9
    * con el que se podía escribir texto utilizando únicamente su
    * teclado numérico (del 0 al 9).
    *
    * Crea una función que transforme las pulsaciones del T9 a su
    * representación con letras.
    * - Debes buscar cuál era su correspondencia original.
    * - Cada bloque de pulsaciones va separado por un guión.
    * - Si un bloque tiene más de un número, debe ser siempre el mismo.
    * - Ejemplo:
    *     Entrada: 6-666-88-777-33-3-33-888
    *     Salida: MOUREDEV
    *
    *
    *   1 .,?!  2 ABC   3 DEF
    *   4 GHI   5 JKL   6 MNO
    *   7 PRS   8 TUV   9 WXYZ
    *
    */

    var input = "6-666-88-777-33-3-33-888"
    println( "${input} => ${t9InputToString(input)}")

    print("Introduce entrada >")
    input = readLine().toString()
    println( "${input} => ${t9InputToString(input)}")


    // Solucion de @marchdz usando Map en lugar de switch
    t9ToText("6-666-88-777-33-3-33-888")                        // MOUREDEV
    t9ToText("333-88-66-222-444-666-66-2-0-666-55")             // FUNCIONA OK
    t9ToText("H2O-333-88-66-222-88888-444-666-66-2-0-666-55-1") // FUNCIONA OK

}

fun t9InputToString(input : String):String{
    val listaPulsaciones = input.split('-')
    var resultado = ""
    listaPulsaciones.forEach {
        val letra = t9Transform(it)
        println("$it => $letra" )
        resultado +=  letra
    }

    return resultado
}

fun t9Transform(bloque:String):Char{
   return  when (bloque) {
        "1" -> '.'
        "11" -> ','
        "111" -> '?'
        "1111" -> '!'

        "2" -> 'A'
        "22" -> 'B'
        "222" -> 'C'

        "3" -> 'D'
        "33" -> 'E'
        "333" -> 'F'

        "4" -> 'G'
        "44" -> 'H'
        "444" -> 'I'

        "5" -> 'J'
        "55" -> 'K'
        "555" -> 'L'

        "6" -> 'M'
        "66" -> 'N'
        "666" -> 'O'

        "7" -> 'P'
        "77" -> 'Q'
        "777" -> 'R'
        "7777" -> 'S'

        "8" -> 'T'
        "88" -> 'U'
        "888" -> 'V'

        "9" -> 'W'
        "99" -> 'X'
        "999" -> 'Y'
        "9999" -> 'Z'

        else -> ' '
    }


}


fun t9ToText(input: String) {

    val t9Map = mapOf(
        "2" to 'A', "22" to 'B', "222" to 'C', "3" to 'D', "33" to 'E', "333" to 'F', "4" to 'G', "44" to 'H',
        "444" to 'I', "5" to 'J', "55" to 'K', "555" to 'L', "6" to 'M', "66" to 'N', "666" to 'O', "7" to 'P',
        "77" to 'Q', "777" to 'R', "7777" to 'S', "8" to 'T', "88" to 'U', "888" to 'V', "9" to 'W', "99" to 'X',
        "999" to 'Y', "9999" to 'Z', "0" to " "
    )

    val output = input.split("-").mapNotNull { t9Map[it] }.joinToString("")

    println(output)
}



