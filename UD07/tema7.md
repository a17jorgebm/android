# Guardado de variables
## Dentro da vista
```kotlin
var welcomeScreenHasBeenPainted = remember {
    mutableStateOf(false)
}
```
## En cambios de estado
```kotlin
var welcomeScreenHasBeenPainted = rememberSaveable {
    mutableStateOf(false)
}
```