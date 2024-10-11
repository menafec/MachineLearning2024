# Regresión en Java

Este proyecto implementa varios modelos de **regresión** en Java utilizando un enfoque orientado a objetos. El objetivo de este programa es entrenar diferentes modelos de regresión, hacer predicciones y evaluar su rendimiento utilizando un conjunto de datos.

## Descripción

El proyecto incluye implementaciones de tres tipos de regresión:

- **Regresión Lineal Simple**: Modelo que relaciona una variable dependiente con una independiente.
- **Regresión Cuadrática**: Extensión de la regresión lineal que incluye un término cuadrático.
- **Regresión Cúbica**: Regresión polinómica de grado 3 que incluye términos de potencias hasta x³.

Para este proyecto, hemos implementado las siguientes clases:

- `DataSet`: Maneja la segmentación de los datos en conjuntos de entrenamiento y prueba.
- `SimpleLinearRegression`: Implementa la regresión lineal simple.
- `QuadraticRegression`: Implementa la regresión cuadrática.
- `PolynomialRegression`: Implementa la regresión polinómica de grado N (utilizada para la regresión cúbica).
- `Main`: Ejecuta el programa, permitiendo al usuario seleccionar el modelo de regresión a evaluar.

### Características

- Implementación orientada a objetos en Java.
- Entrenamiento de modelos de regresión y predicción de valores.
- Cálculo del coeficiente de determinación (R²) para evaluar la precisión del modelo.

## Estructura del Proyecto

El proyecto incluye los siguientes archivos:

- `Main.java`: Contiene la lógica principal del programa y permite al usuario seleccionar el modelo a evaluar.
- `SimpleLinearRegression.java`: Implementación del modelo de regresión lineal simple.
- `QuadraticRegression.java`: Implementación del modelo de regresión cuadrática.
- `PolynomialRegression.java`: Implementación del modelo de regresión cúbica.
- `DataSet.java`: Contiene la lógica para segmentar los datos en conjuntos de entrenamiento y prueba.

## Instalación y Ejecución

### Requisitos

- Java Development Kit (JDK) 8 o superior.
- La biblioteca **Jama** para operaciones matriciales.

Para descargar la librería Jama:

1. Visita: [Jama](http://math.nist.gov/javanumerics/jama/)
2. Descarga el archivo `jama.jar` y asegúrate de agregarlo al classpath del proyecto.

### Ejecución del Programa

Al ejecutar el programa, el usuario verá el siguiente mensaje en la consola:

Seleccione el modelo a evaluar:
1. Regresión Lineal Simple
2. Regresión Cuadrática
3. Regresión Cúbica

Elige el modelo deseado ingresando el número correspondiente (1, 2 o 3). El programa entrenará el modelo seleccionado utilizando un conjunto de datos predefinido y realizará predicciones para valores específicos. También calculará el coeficiente de determinación (R²) para evaluar la precisión del modelo.

Mejoras Futuras

Algunas posibles mejoras incluyen:

	•	Permitir que el usuario cargue su propio conjunto de datos en lugar de usar un dataset predefinido.
	•	Implementar otros tipos de modelos de regresión.
	•	Agregar soporte para la normalización de datos.


Licencia

Este proyecto está bajo la licencia MIT. Ver el archivo LICENSE para más detalles.
