## Navegación
No main, hai que añadir un `FragmentContainerView` para mostrar os distintos fragmentos e enlazalo a o grafo de navegación
```xml
    <androidx.fragment.app.FragmentContainerView
        android:id="@+id/container_fragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:name="androidx.navigation.fragment.NavHostFragment"
        app:navGraph="@navigation/nav_graph"
        app:defaultNavHost="true"
        />
```
* `app:defaultNavHost="true"`: para poder volver ao fragmento anterior pulsando o boton atrás
* `app:navGraph="@navigation/nav_graph"`: para enlazar o grafo de navegacion
* `android:name`: pode indicar 2 cousas
  * `android:name="androidx.navigation.fragment.NavHostFragment"`: que vai pintar un host de navegación
  * `android:name="com.example.ud_04_1_inbox.HelpFragment"`: que vai pintar SOLO ese fragmento, neste caso HelpFragment