package Retos2022

fun main() {

    /*
    * Reto #5
    * ASPECT RATIO DE UNA IMAGEN
    *
    * Enunciado: Crea un programa que se encargue de calcular el aspect ratio de una imagen a partir de una url.
    * - Nota: Esta prueba no se puede resolver con el playground online de Kotlin. Se necesita Android Studio.
    * - Url de ejemplo: https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png
    * - Por ratio hacemos referencia por ejemplo a los "16:9" de una imagen de 1920*1080px.
    *
    */
    val urlImagen = "https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png"
    val imagen = urlImagen.substring(urlImagen.lastIndexOf("/")+1)

    val aspectRatio = aspectRatio(urlImagen)
    println("El aspect ratio de $imagen es ${aspectRatio}")



}
fun aspectRatio(url:String):String{



//    var medidas = Pair(1200, 675)
    var medidas = Pair(900, 823)
    var ratio =  medidas.second


    while(  ((medidas.first.mod(ratio) != 0 )
        ||  (medidas.second.mod(ratio) != 0 ))
        && ( ratio > 0 ) ) {
        ratio = ratio - 1
    }
//    println("Ratio final ${ratio}");



    return "${medidas.first / ratio}:${medidas.second / ratio}"

//    return "16:9"
}