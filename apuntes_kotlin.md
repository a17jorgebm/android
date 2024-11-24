## Variables
Non hai variables primitivas como en java, todas son clases.

* `Byte(8), Short(16), Int(32), Long(64)` bits
* `Float(32), Double(64)` bits
* `Char, String`
* `Unit`: o mismo que **void**, representa a ausencia de valor
* `Nothing`: indica que unha funcion nin retorna nada nin terminou, por ejemplo cando se lanza excepcion

### Any
Todos os objetos **non nulos** son de tipo `Any`, o equivalente a `Object` en java.

Se se asigna un valor a unha variable de tipo any solo se terá acceso as funcions comuns a todos os tipos, e non as de ese tipo en especifico

````kotlin
val valor: Any = 42
val texto: Any = "Hola, Kotlin!"
````

Ejemplo usando any para meter variables de calquer tipo nunha lista:
````kotlin
var elementos: List<Any> = listOf(1,"ola",2.3f)
for (e in elementos){
    println(e::class.simpleName)
}
````


### Uso de Unit
Para indicar que unha funcion non devolve ningún valor usase Unit. Ainda que non é necesario poñelo, xa que se non se indica o valor que devolve asumese de forma implícita.
````kotlin
fun mostrarMensaje(): Unit{
    println("oli")
}
````

Podense gardar funcions lambda indicando o que devolven
````kotlin
var funcionQueSoloPrintea : () -> Unit = { println("ola") }
funcionQueSoloPrintea() //ejecutariase
funcionQueSoloPrintea //fariase referencia a variable

//na que devolve algo e se lle pasa algo
var funcionStringInt: (String, Int) -> String =
    {nombre,edad -> nombre+edad}
var stringDevolto: String= funcionStringInt("Paco",23)
print(stringDevolto)
````

### Conversion de tipos
Kotlin non ten conversions automaticas entre tipos numericos, hai que usar as funcions. Por ejemlo:
````kotlin
var numero: Int = 19
var numeroByte: Byte=numero.toByte() //19

var char: Char='o'
var charToString: String= char.toString() //"o"

var double : Double=-45.9342342
var doubleToInt: Int = double.toInt() //-45 (trunca, non redondea)
````
Indicar que non se lanzan errores nas conversions, por ejemplo de un double muy grande que non colle nun int, o Int collerá o valor maximo de Int.








## Cadenas (Strings)
````kotlin
var cadena : String = "Oli, que tal"
````
### Funcions de cadenas
son as mismas que en java, indicar que os Strings son `inmutables`, polo que ningunha de estas funcions modifica o string original, solo devolve outro novo
````kotlin
cadena.length
cadena.toLowerCase()
cadena.toUpperCase()
cadena.reversed() //dalle a volta
cadena.trim()
cadena.substring(0,3) //Oli
cadena.replace("Oli","Chao") //Chao, que tal
cadena.split(",") //["Oli"," que tal"]

cadena.contains("Oli") //true
cadena.startsWith("Ol") / .endsWith("oli") //true , false
cadena.indexOf("Oli") //devolve 0, -1 se non se encontra

cadena.isEmpty() //se esta vacia
cadena.isBlank() //se solo ten espacios

val texto="42"
texto.padStart(5,'0') //42000
texto.padEnd(3,'0') //042
texto.repeat(3) //424242

"Ola que tal %s tienes %d".format("Pedro",412)

cadena.take(3) //Oli (devolve os n primeiros)
cadena.drop(3) //, que tal (quita os n primeiros)

var lista = listOf("Juan","Pepe","Manolo")
lista.joinToString(", ") //"Juan, Pepe, Manolo"

//iterar sobre os caracteres dunha cadena !!!!!
texto.withIndex() //con esto
for ((indice, caracter) in texto.withIndex()){
    print("$indice, $caracter")
}
````

### Comparacion de cadenas
`equals()` e `==`: son o mesmo, comparan tendo en conta mayusc
`equals(b, ignorecase = true)`: non lle importan as mayusc
````kotlin
var a="ola"
var b="Ola"
println(a==b) //false
println(a.equals(b)) //false
println(a.equals(b, ignoreCase = true)) //true
````
### Raw Strings
Se non se quere que se interpreten os caracteres de escape nin caracteres especiales usase `"""`
````kotlin
val ruta = """C:\Users\Usuario\Documentos"""
````
### String Templates
Uf esto é gozada, podense poñer variables dentro de Strings con `$`





## Pair e Triple
Como é tan común ter que devolver en funcións 2 ou 3 valores (ej. coordenadas 2D/3D...) podemos usar `Pair` e `Triple`.

Son clases genéricas, polo que hai que indicar o tipo dos elementos.

Para recuperar os elementos usase `first`,`second` e `third`(solo no Triple)
### Pair
````kotlin
val pair : Pair<String, Int> = Pair("Pera",4)
pair.first //"Pera"
pair.second //4
````
### Triple
````kotlin
val triple : Triple<String, Int, Float> = Triple("Pera",4,3.2f)
triple.first //"Pera"
triple.second //4
triple.third //3.2
````



## Condicionales
### if else
O mitico if else
````kotlin
if(edad>1){
    
}else if(edad>2){
    
}else{
    
}
````
### Operador ternario
````kotlin
var mensaje=if (1>2) "si" else "esto"
````
### When
É o reemplazo de switch, pero mais versatil e poderosa.

Ejemplo de formas variadas de usalo:
````kotlin
val x=1
when(x){
    1 -> {
        //codigo con mais de unha linea
        println("é 1")
    }
    2 -> println("é 2")
    in 1..6 -> println("esta entre 1 e 6 (inclusivo)")
    is Int -> println("é de tipo enteiro")
    else -> println("non se cumpliu ningunha das condicións")
}
````
E tamen se pode usar con condicions arbitrarias e sen pasarlle un valor co que traballar, como se fora un if:
````kotlin
when {
    x > 1 -> println("son maior que 1")
    x == 10 -> println("son 10")
    else -> println("na")
}
````
E podese usar para `asignar valores a variables`
````kotlin
val result = when (x) {
    1 -> "One"
    2 -> "Two"
    3 -> "Three"
    else -> "Unknown number"
}
````



## Lambda
En kotlin as lambda son algo distintas a java, o nome dos parametros non se definen entre corchetes e sempre se devolve a ultima linea da funcion ou expresions mais complejas con `${}`
````kotlin
println("Hola, mi nombre es $name y tiene ${name.length} caracteres")
````
````kotlin
var funcionLambda: (Int) -> Unit=
    {nombreArgumento -> println(nombreArgumento)}
````
Outro ejemplo con mais logica dentro da funcion:
````kotlin
val generarSaludo: (String, Int) -> String = { nombre, edad ->
    val saludo = StringBuilder() // Usando StringBuilder para construir el mensaje
    saludo.append("Hola, $nombre.\n")
    if (edad < 18) {
        saludo.append("Eres menor de edad.")
    } else {
        saludo.append("Eres mayor de edad.")
    }
    saludo.toString() // Devuelve el resultado como String
}
````
Ainda que se pode usar `return` indicando o contexto no que o ten que facer, NON SE RECOMENDA. As lambdas en kotlin tan feitas pa ser concisas e devolver un valor ao final.

