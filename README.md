# memorySmash
Este repositorio contiene un juego simple de memoria implementado en Java utilizando Swing. El juego consiste en encontrar pares de cartas iguales entre un conjunto de cartas dispuestas aleatoriamente en una cuadrícula.

**Estructura del Proyecto
**El proyecto está organizado en tres clases principales dentro del paquete TrabajoGrupoMemory:

**1. App.java
**
Punto de entrada del programa. Inicia la interfaz gráfica del juego.

**2. Board.java
**
Representa el tablero del juego, que contiene las cartas dispuestas aleatoriamente. Utiliza la clase Card para representar cada carta.

**3. Card.java
**
Representa una carta del juego, que es una extensión de JToggleButton en Swing. Cada carta puede estar boca abajo (con una imagen por defecto) o boca arriba (mostrando una imagen específica).

**4. GameFrame.java
**
Extiende JFrame y es responsable de manejar la lógica del juego. Controla la interacción del usuario con las cartas y verifica si se han encontrado todos los pares para determinar el fin del juego.
**Ejecución**
Para ejecutar el juego, asegúrese de tener configurado un entorno de desarrollo Java y Maven.

Dependencias
El proyecto no tiene dependencias externas más allá de la API estándar de Java y JUnit para pruebas unitarias, configurado en el archivo pom.xml de Maven.

Contribuciones
Si deseas contribuir al proyecto, puedes hacer lo siguiente:

Implementar nuevas características como niveles de dificultad.
Mejorar la interfaz de usuario o agregar animaciones.
Optimizar el código existente para mejor rendimiento.
Te animamos a que explores el código y contribuyas con mejoras. ¡Diviértete jugando y programando!
