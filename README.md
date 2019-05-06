# Laboratorio 2 - Diseño e implementación de interfaz de usuario. Tienda de Mascotas

Elaborado por: Arnaldo Quintero Segura

## Decisiones de diseño

Para este laboratorio, se pedía representar una tienda de animales con tres tipos de animales distintos: Peces, Reptiles y Pájaros. Los cuales comparten entre sí todos sus atributos, ya mencionados en la especificación.

Para resolver este ejercicio se utilizan tres listas `DefaultListModel`, una para cada tipo de animal. Las cuales contendrán los animales cargados y que están siendo visualizados en pantalla.

Cada una de estas listas, es utilizada con este modelo, ya que así se comporta bajo un patrón observable, asociado a las `JList` utilizadas para mostrar en pantalla el contenido de las listas.

Para mostrar los detalles del elemento seleccionado, cada una de estas listas posee un `handler` de selección. El cual busca cuál fue el elemento seleccionado, y lo posiciona en la variable `animalSeleccionado`, la cual representa el animal actualmente seleccionado. Además de esto, se procede a rellenar todos los campos de los inputs con los valores correctos asociados a este animal seleccionado.

Cuando un animal no se encuentra seleccionado, todo el panel de información se encuentra inactivo. Dado que el usuario no puede interactuar aún con el mismo. Para que el usuario pueda interactuar con el panel de información. Se debe seleccionar un animal. O agregar uno.

Veamos como sucede la eliminación, edición y agregación de animales, asi como la implementación de las clases y la distribución de la pantalla en el programa.

### Clases

Las clases, son 3 utilizadas, `Pez`, `Reptil` y `Pajaro`. Cada una la cual representa un tipo de animal. Todas estas clases heredan de una clase padre `Animal`, la cual define todos los atributos que poseen estas clases; así como el método `toString` utilizado para mostrar la lista.

Cada una de estas clases, ademas de los atributos propuestos en la actividad, poseen un atributo de tipo `Tipo`, el cual es un enumerable, que posee los posibles valores `PAJARO`, `PEZ` y `REPTIL`. Este atributo es utilizado a lo largo de los métodos, para poder diferenciar el animal seleccionado de qué tipo es y que casillas deben estar mostradas.

De igual manera, existe el enumerable `Sexo`, que posee los valores `MACHO` y `HEMBRA`. Los cuales son utilizados para determinar el sexo del animal, y dentro del código para marcar las casillas correspondientes.

### Distribución de la pantalla

El contenedor principal, de tipo absoluto, se divide en dos partes. La parte baja, que contiene el panel de información. Y la parte alta que contiene las tres listas de los distintos animales.

En la parte alta, posicionadas a 25px de distancia entre sí y entre los bordes, se encuentran las tres listas. Y sobre cada una de ellas se encuentra su correspondiente botón de agregar y eliminar. Así como la etiqueta que denota a que animal pertenece dicha lista.

Por debajo, se tiene el panel de información. El cual posee tres inputs de tipo `JTextInput` y un `JTextArea`. Los cuales contienen los campos especie, código, alimentación, observaciones y descripción en dicho orden. Estos ocupan aproximadamente el 80% de la longitud del panel. Y a la derecha de estos, se encuentran dos grupos de botones circulares: uno que selecciona el tipo de animal y otro que denota el sexo del animal. Donde el primero de estos dos no es modificable mediante esta vía, es solo por referencia.

De esta manera el usuario tiene una vista genérica de las listas de animales que se encuentran en su tienda, asi como el detalle del animal seleccionado sin perder de vista las listas.

### Agregación de animales

Al pulsar sobre el botón azul con forma de `+`, se activa sobre esa lista la función de agregar. La cual esta asociada a un `handler` en dicho botón. Esta función se encarga de crear un nuevo elemento de la clase deseada. Marcarlo como `animalSeleccionado`, y habilitar la edición para que se agreguen los valores necesarios.

Al crearse, este ya viene con el tipo de animal relleno por defecto, valor que no puede ser cambiado. Esto, en caso de que desee ser cambiado, se debe eliminar el animal de dicha lista y crearlo en la lista deseada.

Se crea también con el campo Sexo por defecto en `HOMBRE`, dado que es el primer valor que se encuentra en la interfaz gráfica.

Para poder guardar este elemento recién creado, se deben rellenar todos los campos obligatorios, que son todos menos las observaciones.

### Edición de animales

Al hacer click sobre un animal en una lista, y ser mostrados sus datos en el panel de información. Se procede a entrar en el estado de edición. Donde todos los campos excepto el tipo de animal son modificables.

Al editar cualquiera de estos campos, y detectarse este cambio, con un evento escuchador de detección asociado a cada uno de los `JTextInput`. Se procede a comparar si ha habido algún cambio entre el `animalSeleccionado` y los valores que poseen los inputs. Y en caso de que esto sea cierto, es decir, que haya un cambio; Se habilita el botón de `Guardar Cambios`. El cual se encarga de editar sobre el `animalSeleccionado` los valores modificados.

Para este evento en particular, luego de editar la referencia al modelo asociado a la `JList`, a pesar de ser un puntero a la misma dirección, la vista no toma el cambio al hacer la modificación sobre el `animalSeleccionado`, por lo que se fuerza a la lista a actualizar la posición que contiene ese elemento con su mismo valor. Haciendo así que la vista responda de manera inmediata al cambio y lo refleje sobre la lista.

Al hacer click sobre los animales, se poseen tres eventos de ratón: `click` `mousePressed` y `mouseReleased`. Para este tipo de funciones de selección, el handler se aplica a las 3 funciones, dado que es el método mediante el cual la interfaz se comporta de manera más fluida y sin retrasos visuales respecto a lo ocurrido en código.

### Eliminación de animales

Para eliminar un animal, este debe ser seleccionado previamente, para lo cual se activa el botón de `-` de color rojo posicionado sobre la lista en la cual se encuentra dicho animal.

Al presionar este botón, se busca en la lista de el animal correspondiente dicho animal, se procede a limpiar y deshabilitar el panel de información, luego eliminar dicho animal del model asociado a la lista. Y por último eliminar las selecciones de la lista. Para que se vuelva a un estado en el cual nada está seleccionado.

Para la función de eliminación, cómo este método no puede ser llamado varias veces, dado que causaría la eliminación de un elemento no deseado. Se llama al `handler` en la función `mouseReleased` ado que es el método mediante el cual la interfaz se comporta de manera más fluida y sin retrasos visuales respecto a lo ocurrido en código.

## Carga inicial

Al momento de la carga inicial, se cargan en cada una de las listas de animales, tres animales de prueba para cada lista. Y se puede ver en el ejecutable cómo se interactúa con dicha interfaz utilizando los recursos propuestos en la actividad.