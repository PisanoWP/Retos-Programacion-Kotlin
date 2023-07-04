package retos2022

/*
 * Reto #7
 * CONTANDO PALABRAS
 *
 * Enunciado: Crea un programa que cuente cuantas veces se repite cada palabra y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 */

fun main() {
    //val frase: String = "Hola Mundo COMO ¿Qué tal estas?, hola estoy bien, y tú, como estas"
    val frase = "Hola, mi nombre es brais. Mi nombre completo es Brais Moure (MoureDev)."

    contadorPalabras(frase)
    println("-----------------------------------------")
    countWords(frase)

}

fun contadorPalabras(frase: String){

    val lista = ListaPalabras()

//    palabras.add(Palabra("hola", 0))
//    palabras.add(Palabra("adios", 3))

    // Normalizar para poner  cada palabra en minúsculas
    val fraseNormalizada = frase.lowercase()

    var palabra = ""
    var i = 0
    while(i < fraseNormalizada.length){

        while((i < fraseNormalizada.length) && !fraseNormalizada[i].isLetterOrDigit() ){
            i++
        }

        while((i < fraseNormalizada.length) && fraseNormalizada[i].isLetterOrDigit() ){
            palabra += fraseNormalizada[i]
            i++
        }
        //println("Palabra cazada => ${palabra}")
        lista.addPalabra(palabra)

        palabra=""

    }

    // Mostrar el resutlado
    lista.listar()


}

data class Palabra(var palabra:String, var ocurrencias:Int)

class ListaPalabras(var palabras: MutableList<Palabra> = mutableListOf<Palabra>()){

    fun addPalabra(palabra : String){
        var i = 0
        var add = true
        while (i < this.palabras.count()){
            if (this.palabras[i].palabra == palabra){
                this.palabras[i].ocurrencias++
                add = false
            }
            i++
        }
        if (add){
            this.palabras.add(Palabra(palabra, 1 ))
        }
    }

    fun listar(){
//
//        for (palabra in this.palabras){
//            println("${palabra.palabra} => ${palabra.ocurrencias}")
//        }

        this.palabras.forEach(){
            println("${it.palabra} se ha repetido ${it.ocurrencias} ${if(it.ocurrencias == 1) "vez" else "veces"}")
        }
    }

}


//
// Solucion propuesta
//
fun countWords(text: String) {

    val words = mutableMapOf<String, Int>()

    text.lowercase().replace("[^a-z0-9]".toRegex(), " ").split(" ").forEach { key ->
        if (key.isEmpty()) {
            return@forEach
        }
        if (words[key] != null) {
            words[key] = words.getValue(key) + 1
        } else {
            words[key] = 1
        }
    }

    words.forEach { word ->
        println("${word.key} se ha repetido ${word.value} ${if(word.value == 1) "vez" else "veces"}")
    }
}
