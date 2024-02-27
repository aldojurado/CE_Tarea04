# Tarea 02: Representación de Soluciones

## Integrantes del equipo:

- **Ángeles Sánchez Aldo Javier 320286144**
- **Jurado Guadalupe Aldo Emilio 320025255**

## Requisitos

Este proyecto usa maven. <br>
**Instalación desde terminal:**

### En fedora:

```bash
sudo dnf install maven
```

### En ubuntu:

```bash
sudo apt install maven
```

Adicionalmente ya se debe tener java con su **jdk**.
De no tenerlo, en fedora se instala de la siguiente forma:

```bash
sudo dnf install java-devel

```

## Compilar y Ejecutar

Para compilar de forma limpia:

```bash
mvn clean install
```

Para ejecutar el programa (después de compilar) hay dos formas:

### Forma 1:

Busqueda local: java -jar target/ejecuta.jar k d x_1 ... x_n <br>
Donde k es el número de la operación (1 = Sum Squares, 2 = Dixon Price, 3 = Styblinski Tang) <br>
d es la dimensión <br>
x_1 ... x_n son los valores iniciales de la solución <br>

Ejemplo:

```bash
java -jar target/ejecuta.jar 1 2 5.1 4
```

### Forma 2 :

Busqueda aleatoria: java -jar target/ejecuta.jar k d a iteraciones <br>
Donde k es el número de la operación (1 = Sum Squares, 2 = Dixon Price, 3 = Styblinski Tang) <br>
d es la dimensión <br>
el caracter 'a' indica que será búsqueda aleatoria <br>
y iteraciones es el número de iteraciones que deseamos para la búsqueda<br>

Ejemplo:

```bash
java -jar target/ejecuta.jar 2 3 a 10000
```

## Limpieza

Adicionalmente para limpiar los archivos generados por la compilación:

```bash
mvn clean
```

## Comentarios
# Representación binaria para números reales.
El archivo ...
# Búsqueda por escalada 
Justificación de la implementación. 
No se utiliza una función de "soluciones" aleatorias asignando un color aleatorio a cada vértice, puesto que la función objetivo en ese caso se enfocaría a contar el número de conflictos que se encuentran en nuestra gráfica, mientras que generar soluciones aleatorias enfocadas a respetar las adyacencias, nos asegura generar siempre soluciones válidas aunque en número de colores utilizados no sea el óptimo. 
