import java.util.List;

public class PolynomialRegression {
    private double[] coefficients;
    private int degree;

    public PolynomialRegression(int degree) {
        this.degree = degree;
        this.coefficients = new double[degree + 1];  // Hay degree + 1 coeficientes
    }

    // Método para entrenar el modelo de regresión polinómica
    public void train(List<Double> xValues, List<Double> yValues) {
        int n = xValues.size();
        double[][] X = new double[n][degree + 1];  // Matriz de diseño

        // Llenar la matriz X con potencias de x
        for (int i = 0; i < n; i++) {
            double xi = xValues.get(i);
            for (int j = 0; j <= degree; j++) {
                X[i][j] = Math.pow(xi, j);
            }
        }

        // Convertir yValues a un array 1D
        double[] yArray = new double[n];
        for (int i = 0; i < n; i++) {
            yArray[i] = yValues.get(i);
        }

        // Calcular la transpuesta de X
        double[][] XT = transposeMatrix(X);
        
        // Multiplicar X^T por X
        double[][] XTX = multiplyMatrices(XT, X);
        
        // Multiplicar X^T por y
        double[] XTy = multiplyMatrixVector(XT, yArray);

        // Invertir la matriz XTX
        double[][] XTX_inv = invertMatrix(XTX);
        
        // Obtener los coeficientes resolviendo el sistema (XTX_inv * XTy)
        coefficients = multiplyMatrixVector(XTX_inv, XTy);
    }

    // Método para hacer predicciones
    public double predict(double x) {
        double yPred = 0;
        for (int i = 0; i <= degree; i++) {
            yPred += coefficients[i] * Math.pow(x, i);
        }
        return yPred;
    }

    // Calcular el coeficiente de determinación (R^2)
    public double calculateR2(List<Double> xTest, List<Double> yTest) {
        double totalSumOfSquares = 0;
        double residualSumOfSquares = 0;
        double yMean = yTest.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

        for (int i = 0; i < xTest.size(); i++) {
            double yPred = predict(xTest.get(i));
            double yTrue = yTest.get(i);
            residualSumOfSquares += Math.pow(yTrue - yPred, 2);
            totalSumOfSquares += Math.pow(yTrue - yMean, 2);
        }

        return 1 - (residualSumOfSquares / totalSumOfSquares);
    }

    // Obtener los coeficientes
    public double getCoefficient(int index) {
        if (index >= 0 && index < coefficients.length) {
            return coefficients[index];
        }
        return 0.0;  // Retorna 0 si el índice es inválido
    }

    public int getDegree() {
        return degree;
    }

    // Imprimir el modelo
    public void printModel() {
        StringBuilder sb = new StringBuilder();
        sb.append("y = ");
        for (int i = 0; i <= degree; i++) {
            sb.append(String.format("%.4f", coefficients[i]));
            if (i > 0) sb.append(" * x^").append(i);
            if (i < degree) sb.append(" + ");
        }
        System.out.println(sb.toString());
    }

    // Método para multiplicar dos matrices
    private double[][] multiplyMatrices(double[][] a, double[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;
        double[][] result = new double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                result[i][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    // Método para multiplicar una matriz por un vector
    private double[] multiplyMatrixVector(double[][] a, double[] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        double[] result = new double[rowsA];

        for (int i = 0; i < rowsA; i++) {
            result[i] = 0;
            for (int j = 0; j < colsA; j++) {
                result[i] += a[i][j] * b[j];
            }
        }
        return result;
    }

    // Método para transponer una matriz
    private double[][] transposeMatrix(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] transposed = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    // Método para invertir una matriz usando Gauss-Jordan
    private double[][] invertMatrix(double[][] matrix) {
        int n = matrix.length;
        double[][] augmented = new double[n][2 * n];

        // Crear la matriz aumentada con la identidad a la derecha
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmented[i][j] = matrix[i][j];
            }
            augmented[i][i + n] = 1;
        }

        // Aplicar eliminación Gauss-Jordan
        for (int i = 0; i < n; i++) {
            double pivot = augmented[i][i];
            for (int j = 0; j < 2 * n; j++) {
                augmented[i][j] /= pivot;
            }

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = augmented[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        augmented[k][j] -= factor * augmented[i][j];
                    }
                }
            }
        }

        // Extraer la matriz invertida
        double[][] inverse = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[i][j] = augmented[i][j + n];
            }
        }

        return inverse;
    }
}