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

Para ejecutar el programa (después de compilar):

```bash
java -jar target/ejecuta.jar
```

## Limpieza

Adicionalmente para limpiar los archivos generados por la compilación:

```bash
mvn clean
```

## Comentarios

# Representación binaria para números reales.

Si se usa una representación binario con un número de bits muy grande puede causar desbordamientos, ya que para hacer la partición se requiere calcular el número de valores representables con el número de bits y este se consigue con 2^n, donde n es el número de bits.
Esta función crece exponencialmente y puede causar desbordamientos que hagan funcionar mal el programa.

# Búsqueda por escalada

Justificación de la implementación.
No se utiliza una función de "soluciones" aleatorias asignando un color aleatorio a cada vértice, puesto que la función objetivo en ese caso se enfocaría a contar el número de conflictos que se encuentran en nuestra gráfica, mientras que generar soluciones aleatorias enfocadas a respetar las adyacencias nos asegura generar siempre soluciones válidas aunque el número de colores utilizados no sea el óptimo. 
Las soluciones de las gráficas en el reporte no coinciden con las soluciones del archivo, puesto que se ha ejecutado el código más veces para probar su funcionamiento cuando ya no se representan los colores como String, sino como números. Antes habíamos creado un método que genere un color dependiendo el entero ingresado pero estaba limitando las gráficas a ingresar, puesto que tendría que generar la misma cantidad de colores que de vértices en el peor caso. 

