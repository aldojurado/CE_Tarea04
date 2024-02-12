# Secreto-Compartido-de-Shamir

Implementación de encriptación del secreto compartido de shamir

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

Para limpiar los archivos generados por la compilación:

```bash
mvn clean
```

### Cifrar

Para cifrar se debe seguir la siguiente estructura en la línea de comandos: <br>
**java -jar target/proyecto3.jar c <n (número de personas a repartir la llave)> <t (número de partes de la llave necesarias para descifrar)> <ruta del archivo con el texto a cifrar> <nombre que se le pondrá al archivo con las evaluaciones>**

Sobre el guardado de archivos:

- El archivo cifrado se guardará en la misma ruta del texto claro y con el mismo nombre pero con la extensión .cif
- El archivo con las evaluaciones se guardará en la carpeta evaluaciones con el nombre proporcionado en la línea de comandos y la extensión .evl

### Descifrar

Para descifrar se debe seguir la siguiente estructura en la línea de comandos: <br>
**java -jar target/proyecto3.jar d <ruta del archivo con las evaluaciones> <ruta del archivo con el texto cifrado> <t (número necesario de partes de la llave para descifrar)>**

Sobre el guardado de archivos:

- El archivo descifrado se guardará en la misma ruta del texto cifrado y con el mismo nombre pero con la extensión .dec

### Prueba rápida

Si quieres probar el programa rápidamente, puedes ejecutar las siguientes líneas de código en el orden que se muestran:

1.- Compilar:

```bash
mvn clean install
```

2.- Probar:

```bash
java -jar target/proyecto3.jar
```

3.- Esto ya ignora:

```bash
java -jar target/proyecto3.jar d evaluaciones/evals.evl archivos/prueba.cif 3
```

### Pruebas unitarias

Si quieres ver las pruebas unitaras ubicadas en la carpeta src/test:

```bash
mvn clean install
```

O directamente lo puedes probar con:

```bash
mvn test
```

IMPORTANTE: LEER LAS INSTRUCCIÓNES DE TestDecifrado.
