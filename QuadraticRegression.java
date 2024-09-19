import java.util.List;

public class QuadraticRegression {
    private double beta0; // Intercepcion
    private double beta1; // Coeficiente lineal
    private double beta2; // Coeficiente cuadrático

    // Método para entrenar el modelo de regresión cuadrática
    public void train(List<Double> xTrain, List<Double> yTrain) {
        int n = xTrain.size();
        double sumX = 0.0, sumX2 = 0.0, sumX3 = 0.0, sumX4 = 0.0;
        double sumY = 0.0, sumXY = 0.0, sumX2Y = 0.0;

        // Calcular las sumatorias 
        for (int i = 0; i < n; i++) {
            double x = xTrain.get(i);
            double y = yTrain.get(i);
            double x2 = x * x;

            sumX += x;
            sumX2 += x2;
            sumX3 += x2 * x;
            sumX4 += x2 * x2;

            sumY += y;
            sumXY += x * y;
            sumX2Y += x2 * y;
        }

        // Resolver sistema de ecuaciones normales
        double[][] A = {
            {n, sumX, sumX2},
            {sumX, sumX2, sumX3},
            {sumX2, sumX3, sumX4}
        };
        double[] B = {sumY, sumXY, sumX2Y};

        double[] betas = solveSystem(A, B);

        beta0 = betas[0];
        beta1 = betas[1];
        beta2 = betas[2];
    }

    // Método para predecir valores
    public double predict(double x) {
        return beta0 + beta1 * x + beta2 * x * x;
    }

    // Método para calcular el coeficiente de determinación R^2
    public double calculateR2(List<Double> xTest, List<Double> yTest) {
        double ssTotal = 0.0, ssResidual = 0.0;
        double meanY = yTest.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

        for (int i = 0; i < xTest.size(); i++) {
            double yPred = predict(xTest.get(i));
            ssResidual += Math.pow(yTest.get(i) - yPred, 2);
            ssTotal += Math.pow(yTest.get(i) - meanY, 2);
        }

        return 1 - (ssResidual / ssTotal);
    }

    // Método para calcular la correlación
    public double calculateCorrelation(List<Double> xTest, List<Double> yTest) {
        double meanX = xTest.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        double meanY = yTest.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

        double sumXY = 0.0, sumX2 = 0.0, sumY2 = 0.0;

        for (int i = 0; i < xTest.size(); i++) {
            double x = xTest.get(i);
            double y = yTest.get(i);
            sumXY += (x - meanX) * (y - meanY);
            sumX2 += Math.pow(x - meanX, 2);
            sumY2 += Math.pow(y - meanY, 2);
        }

        return sumXY / Math.sqrt(sumX2 * sumY2);
    }

    // Resolver sistema de ecuaciones normales
    private double[] solveSystem(double[][] A, double[] B) {
        int n = B.length;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                double factor = A[k][i] / A[i][i];
                for (int j = i; j < n; j++) {
                    A[k][j] -= factor * A[i][j];
                }
                B[k] -= factor * B[i];
            }
        }

        double[] X = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            X[i] = B[i];
            for (int j = i + 1; j < n; j++) {
                X[i] -= A[i][j] * X[j];
            }
            X[i] /= A[i][i];
        }

        return X;
    }

    // Obtener coeficientes
    public double getBeta0() {
        return beta0;
    }

    public double getBeta1() {
        return beta1;
    }

    public double getBeta2() {
        return beta2;
    }
}