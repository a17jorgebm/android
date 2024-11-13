# Binding
## Importacion
Hai que importar, dentro do gradle de app:
```kts
android{
    ...
    buildFeatures {
        viewBinding = true
    }
    ...
```

## Ejemplo de uso
Neste caso usarase no MainActivity (tarea UD06_chronos_binding)

1. Nos atributos da clase MainActivity:
```kotlin
lateinit var binding: ActivityMainBinding
```
2. Ahora, inicializamos a variable con todo o contido da vista usando `ActivityMainBinding.inflate(layoutInflater)`, 
podendoa usar posteriormente para coller todos os datos da vista con `binding.root`.
Indicar que ActivityMainBinding cambia de nome según o nome do arquivo kotlin.
```kotlin
onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root) //ahora
    // setContentView(R.layout.activity_main) //antes
//...
```
Como sabe que vista inflar? Polo espacio de nombres, por eso é moi importante **os nombres dos archivos**.
Por ejemplo no `MainActivity` relacionariao ca vista `activity_main.xml`.
3. Ahora podemos usalo para pillar datos da vista, en vez de con `findViewById`
```kotlin
//antes
// chrono= findViewById<Chronometer>(R.id.chrTemporizador)

//ahora con binding
chrono = binding.chrTemporizador
```

## Ejemplo de uso en fragmento
esta no proyecto de chronos tamen



# Model
para compartir datos entre vistas, crease unha clase de tipo `ViewModel`


# LiveData
## Importacion
```kotlin
implementation("androidx.lifecycle:lifecycle-livedata-core-ktx:2.8.7")
```
Para que os textos da vista se actualicen automaticamente co modelo

