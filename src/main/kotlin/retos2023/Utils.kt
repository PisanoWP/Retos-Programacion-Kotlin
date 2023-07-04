package retos2023

fun pideNumero( etiqueta : String): Int {
    var numero: Int? = null
    var valido = false

    while (!valido) {
        print("Introduce $etiqueta >")
        val input = readLine()

        try {
            numero = input?.toInt()
            valido = true
        } catch (e: NumberFormatException) {
            println("Entrada inválida. Debes ingresar un número entero.")
        }
    }
    return numero!!
}


fun pideNumeroPositivo( etiqueta : String): Int {
    var numero: Int? = null
    var valido = false

    while (!valido) {
        print("Introduce $etiqueta >")
        val input = readLine()

        try {
            numero = input?.toInt()
            if (numero != null) {
                if (numero > 0){
                    valido = true
                } else {
                    println("Entrada inválida. Debes ingresar un número entero positivo.")
                }
            }

        } catch (e: NumberFormatException) {
            println("Entrada inválida. Debes ingresar un número entero positivo.")
        }
    }
    return numero!!
}