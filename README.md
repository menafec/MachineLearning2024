Proyecto de Modelos de Regresión en Java

Descripción

Este proyecto implementa tres tipos de modelos de regresión en Java:

	1.	Regresión Lineal Simple
	2.	Regresión Cuadrática
	3.	Regresión Cúbica (o Regresión Polinómica de grado 3)

El programa permite entrenar cada modelo con un conjunto de datos y realizar predicciones. Además, calcula el coeficiente de determinación (R²) para evaluar el ajuste de cada modelo. La implementación está diseñada de manera orientada a objetos y utiliza la biblioteca Jama para operaciones de álgebra lineal.

Estructura del Proyecto

	•	Main.java: Contiene la lógica principal del programa, que permite al usuario seleccionar el tipo de modelo de regresión a evaluar.
	•	SimpleLinearRegression.java: Implementación de la regresión lineal simple.
	•	QuadraticRegression.java: Implementación de la regresión cuadrática (regresión polinómica de grado 2).
	•	PolynomialRegression.java: Implementación de la regresión polinómica de grado N (en este caso, se utiliza para la regresión cúbica con grado 3).
	•	DataSet.java: Contiene la lógica para segmentar los datos en conjuntos de entrenamiento y prueba.

Instalación y Ejecución

Requisitos

	•	Java Development Kit (JDK) 8 o superior.
	•	La biblioteca Jama para operaciones matriciales.

Para descargar la librería Jama:

	1.	Visita: http://math.nist.gov/javanumerics/jama/
	2.	Descarga el archivo jama.jar y asegúrate de agregarlo al classpath del proyecto.

Ejecución del Programa

	1.	Clona o descarga el proyecto en tu máquina.
	2.	Asegúrate de que el archivo jama.jar está presente y configurado en tu entorno de desarrollo.
	3.	Compila y ejecuta el archivo Main.java para interactuar con el programa.

javac -cp .:jama.jar Main.java
java -cp .:jama.jar Main

Ejemplo de Uso

Al ejecutar el programa, el usuario verá el siguiente mensaje en la consola:

Seleccione el modelo a evaluar:
1. Regresión Lineal Simple
2. Regresión Cuadrática
3. Regresión Cúbica

Elige el modelo deseado ingresando el número correspondiente (1, 2 o 3). El programa entrenará el modelo seleccionado utilizando un conjunto de datos predefinido y realizará predicciones para valores específicos. También calculará el coeficiente de determinación (R²) para evaluar la precisión del modelo.

Segmentación de Datos

El conjunto de datos se divide en dos partes:

	•	70% para el entrenamiento.
	•	30% para las pruebas.

Esto asegura que el modelo pueda ser entrenado y probado con diferentes subconjuntos de datos.

Clases Principales

SimpleLinearRegression.java

	•	Implementa la regresión lineal simple (y = β₀ + β₁x).
	•	Contiene métodos para entrenar el modelo, hacer predicciones y calcular R².

QuadraticRegression.java

	•	Implementa la regresión cuadrática (y = β₀ + β₁x + β₂x²).
	•	Similar a la regresión lineal, pero incluye un término cuadrático.

PolynomialRegression.java

	•	Implementa una regresión polinómica general (y = β₀ + β₁x + β₂x² + … + βₙxⁿ).
	•	En este proyecto, se usa para la regresión cúbica (grado 3).

DataSet.java

	•	Segmenta los datos en conjuntos de entrenamiento y prueba.
	•	Puede personalizarse para manejar diferentes tamaños de segmentación.

Dependencias

	•	Jama - Biblioteca de álgebra lineal para Java.

Mejoras Futuras

Algunas posibles mejoras incluyen:

	•	Permitir que el usuario cargue su propio conjunto de datos en lugar de usar un dataset predefinido.
	•	Implementar otros tipos de modelos de regresión.
	•	Agregar soporte para la normalización de datos.


Licencia

Este proyecto está bajo la licencia MIT. Ver el archivo LICENSE para más detalles.

