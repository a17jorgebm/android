## Material desing
[GitHub](https://github.com/material-components/material-components-android/blob/master/docs/getting-started.md) do repo

### Dependencias
Hai que indicar o repo en `settings.gradle.kts`
```xml
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google() <!-- este que suelte tar xa por defecto -->
        mavenCentral()
    }
}
```
E en `build.gradle.kts` metemos a dependencia, indicando a versión
```xml
implementation("com.google.android.material:material:1.12.0")
```

En `res/values/themes.xml` podense configurar os temas da app, tamen hai themes.xml (night)
```xml
                                        <!-- cambiar esto -->
<style name="Base.Theme.UD_04_1_Inbox" parent="Theme.Material3.DayNight">
<!-- a de arriba mostraria a actionbar por defecto do sistema, a de abaixo no -->
<style name="Base.Theme.UD_04_1_Inbox" parent="Theme.Material3.DayNight.NoActionBar">
```

### MaterialActionBar
Non vamos usar a ActionBar por defecto do sistema, usaremos a de Material desing:
1. Incluila na vista
```xml
<com.google.android.material.appbar.MaterialToolbar
    android:id="@+id/materialToolBar"
    android:layout_width="match_parent"
    android:layout_height="?attr/actionBarSize"
    style="@style/Widget.MaterialComponents.Toolbar.Primary"
    >
</com.google.android.material.appbar.MaterialToolbar>
```
2. Pillala desde o kotlin e facela a ActionBAr por defecto (se non puxemos o `.NoActionBar` no themes vai dar error)
```kotlin
val actionBar=findViewById<MaterialToolbar>(R.id.materialToolBar)
setSupportActionBar(actionBar) //de esta maneira, facemos esa barra a por defecto da aplicacion
```

### Menu na barra de navegación
Pa crear: `res -> click dereito -> new -> Android resource file -> Resource Type (Menu)`

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <item
        android:id="@+id/helpFragment"
        android:icon="@android:drawable/ic_menu_help"
        android:title="@string/help"
        app:showAsAction="always"
        />
</menu>
```
* `app:showAsAction="always"`: fai que o item sexa un boton independente no menú (non esta dentro dos 3 puntitos)
  * `android:icon="@android:drawable/ic_menu_help"`: se ten a propiedad de arriba pode