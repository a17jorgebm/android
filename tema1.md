Todas as clases heredan da clase Activity

```
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
```
## APK
Kotlin -> Bytecode -> APK(o que ejecuta o mobil)

## Pasos nunha app
1. Activity (activity_main.kt)
2. Layout
3. Views
4. Interacción o usuario
5. Eventos que volven ao paso 1

## Literales e layouts
```java
setContentView(R.layout.activity_main)
```
* R(recursos) 
* layout(carpeta) 
* activity_main(o layout que se vai cargar)


Os textos(literales) sempre van ir dentro de `app/res/values/strings.xml` !!!
```xml
<resources>
    <string name="app_name">UD01_HolaMundo</string>
    <string name="prueba1">Hola a todos</string>
</resources>
```
E para usalos dentro de un <b>layout</b>, activity_main.xml neste caso:
```xml
...
<TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/prueba1"
        app:layout_constraintBottom_toBottomOf="parent"
...
```
`android:text="@string/prueba1"`
### Crear un novo arquivo de idiomas(strings.xml)
1. Click dereito carpea `strings`
2. New -> Values resource file
3. O nome do arquivo sempre é <b>strings</b>, despois xa o detecta android según o idioma que escollamos no paso 4.
4. Available qualifiers -> Locale -> Seleccionar o idioma



## Disposicion dos elementos dun contedor
`<LinearLayout`: layout que pon os contidos un despois do outro
* `android:orientation="vertical"`: os contidos ordenaranse verticalmente
* `android:orientation="horizontal"`: os contidos ordenaranse horizontal
* ``


    o wrap_content axusta o contedor ao contido que ten dentro
    match_parent axusta o contedor para que ocupe toda a pantalla

Non se traballa con px, traballase con `dp`, que axusta os pixeles dependendoda resolucion da pantalla. É parecido ao % de html

android:gravity="center" : centra o contenido de dentro do layout ao medio
android:layout_gravity="center": centra o layout dentro do contedor no que ta


## Elementos en codigo
```kotlin
val btnSend=findViewById<Button>(R.id.btnSend)
btnSend.setOnKeyListener();
```

## Cronometro
`SystemClock.elapsedRealtime()`: valor do reloj interno de android desde que empezou a ejecutarse a app

# Tema idiomas que empezan a ler desde a dereita
Dentro do arquivo `AndroidManifest.xml` añadimos:
````xml
    <application
        ...
        android:supportsRtl="true"
        ...
````
