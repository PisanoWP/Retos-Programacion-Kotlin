package Retos2023

import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query


fun main() {

    /*
    * Reto #10 06/03/2023
    *
    * Implementa una llamada HTTP a una API (la que tú quieras) y muestra su
    * resultado a través de la terminal. Por ejemplo: Pokémon, Marvel...
    *
    * Aquí tienes un listado de posibles APIs:
    * https://github.com/public-apis/public-apis
    *
    * Vamos a usar https://swapi.dev/, para recuperar planetas y especies del universo StarWars
    *
    *
    * PENDIENTE REALIZAR LA PRACTICA CON ESTA API, QUE HACE PETICION POST EN LUGAR DE GET
    * Vamos a usar https://aztro.readthedocs.io/en/latest/#
    * Para recuperar el horoscopo diario
    */

    /*
    Preparación.
     1.- Registras las dependencias. En el fichero build.gradle.kts en el bloque dependencies añadir:

        IMPORTANTE, en lugar de ser
        implementation 'com.squareup.retrofit2:retrofit:2.9.0'
        es:
        implementation("com.squareup.retrofit2:retrofit:2.9.0")

        // Retrofit
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        // Gson (To convert raw JSON to pretty JSON)
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")


      2.- Creamos la DATA class que va a guardar la respuesta de la API

      3.- Cramos la interfaz que luego usara retrofit

      4.- Creamos un objecto que será el cliente para realizar las llamadas de retrofit


     */

    // Usando los siguientes articulos
    // https://cursokotlin.com/tutorial-retrofit-2-en-kotlin-con-corrutinas-consumiendo-api-capitulo-20-v2/
    // https://www.vogella.com/tutorials/Retrofit/article.html
    // https://www.geeksforgeeks.org/retrofit-with-kotlin-coroutine-in-android/
    // https://johncodeos.com/how-to-make-post-get-put-and-delete-requests-with-retrofit-using-kotlin/

    println("configurando retrofit...")

    // https://dog.ceo/api/breed/hound/images
    // searchByName("hound")
    println("RELACIÓN PLANETAS DE STARWARS")
    recuperarPlanetas()

    println("RELACIÓN RAZAS DE STARWARS")
    recuperarEspecies()



}

fun recuperarPlanetas( pagina : Int=1){

    //val planetas = StarWarsBDClient.service.getPlanets("planets/?page=${pagina}")
    val planetas = StarWarsBDClient.service.getPlanets(pagina)
    val body = planetas.execute().body()
    if (body != null) {
        println("Se han recuperado {${body.count} planetas")

        body.planetas.forEach { planeta ->
            println(" * ${planeta.nombre} de tipo ${planeta.terreno}")
        }

        if (body.next!=null){
            println("... Más planetas en  {${body.next}")
            recuperarPlanetas(pagina+1)
        }



    } else {
        println("error al recuperar planetas")
    }

}



fun recuperarEspecies( pagina : Int=1){

    val especies = StarWarsBDClient.service.getSpecies(pagina)
    val body = especies.execute().body()
    if (body != null) {
        println("Se han recuperado {${body.count} especies")

        body.especies.forEach { especie ->
            println(" * ${especie.nombre} de tipo ${especie.clasificacion}")
        }

        if (body.next!=null){
            println("... Más especies en  {${body.next}")
            recuperarEspecies(pagina+1)
        }


    } else {
        println("error al recuperar planetas")
    }

}


object StarWarsBDClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://swapi.dev/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: SWAPIService = retrofit.create(SWAPIService::class.java)

}

interface SWAPIService {
    //    @GET
//    fun getPlanets(@Url url: String): Call<SWPlanetsResponse>
    @GET("planets")
    fun getPlanets(@Query("page") page: Int): Call<SWPlanetsResponse>

    @GET("species")
    fun getSpecies(@Query("page") page: Int): Call<SWSpeciesResponse>

}


data class SWPlanetsResponse(
    @SerializedName("count") var count: Int,
    @SerializedName("next") var next: String,
    @SerializedName("previous") var previous: String,
    @SerializedName("results") var planetas: List<SWPlanet>
)

// https://swapi.dev/documentation#planets
data class SWPlanet(
    @SerializedName("name") var nombre: String,
    @SerializedName("terrain") var terreno: String
)
data class SWSpeciesResponse(
    @SerializedName("count") var count: Int,
    @SerializedName("next") var next: String,
    @SerializedName("previous") var previous: String,
    @SerializedName("results") var especies: List<SWSpecie>
)

// https://swapi.dev/documentation#species
data class SWSpecie(
    @SerializedName("name") var nombre: String,
    @SerializedName("classification") var clasificacion: String
)


/*


fun searchByName(query: String) {
    //CoroutineScope(Dispatchers.IO).launch {
    thread {
        val call = getRetrofit().create(APIService::class.java).getCharacterByName("$query/images").execute()
        val puppies = call.body() as DogsResponse?
        //runOnUiThread {
            if (puppies?.status == "success") {
                println("éxito en la llama, mostrar los chuchos")
                val chuchos = puppies?.images
                chuchos?.forEach {
                    imagen ->
                    println(imagen)
                }
            } else {
                println("error en la llamada")

            }

        //}
    //}
    }
}

fun getRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/breed/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

interface APIService {
    @GET
    fun getCharacterByName(@Url url: String): Call<DogsResponse>
}

data class DogsResponse(
    @SerializedName("status") var status: String,
    @SerializedName("message") var images: List<String>
)
 */