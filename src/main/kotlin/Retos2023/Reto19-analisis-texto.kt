package Retos2023


fun main() {

    /*
    * Reto #19 11/05/2023
    *
     * Crea un programa que analice texto y obtenga:
     * - Número total de palabras.
     * - Longitud media de las palabras.
     * - Número de oraciones del texto (cada vez que aparecen un punto).
     * - Encuentre la palabra más larga.
     *
     * Todo esto utilizando un único bucle.
     */

    //var texto = "Hay varias maneras de saber que te queda poco espacio disponible en el disco asignado a tu cuenta de hosting, pero no es algo que solamos revisar a menudo, y me incluyo. Normalmente nos preocupamos más del rendimiento del servidor, de la velocidad de página, y sobre todo de los contenidos y el SEO, pero no de queda mucho o poco espacio, de cuántos gigas hay libres de los que tenemos contratados."
    val texto = "Aunque como te decía arriba, a veces será la empresa de hosting quien te avise, no deberías llegar a ese límite, y deberías vigilar de vez en cuando el uso del espacio en disco contratado, para evitar los problemas que hemos comentado antes. El primer sitio que debes visitar para saber la cantidad de espacio en disco contratado y consumido es el propio panel del hosting que, de distintas maneras, según el tipo de panel de usuario que utilice, te mostrará en mayor o menor detalle."

    var totalPalabras = 0
    var longMediaPalabra = 0
    var totalOraciones = 0
    var palabraMasLarga = ""

    texto.split(" ").forEach { pal ->
        totalPalabras++
        longMediaPalabra += pal.length
        if (pal.contains('.')) { totalOraciones++ }
        if (pal.length > palabraMasLarga.length) { palabraMasLarga = pal }
    }
    longMediaPalabra = (longMediaPalabra / totalPalabras)
    println ("Número total de palabras $totalPalabras")
    println ("Longitud media de las palabras  $longMediaPalabra")
    println ("Número de oraciones del texto $totalOraciones")
    println ("Palabra más larga: $palabraMasLarga")

}





