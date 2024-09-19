import java.util.List;

public class SimpleLinearRegression {
    private double beta0; // Intercepcion
    private double beta1; // Pendiente (coeficiente)

    // Método para entrenar el modelo de regresión lineal simple
    public void train(List<Double> xTrain, List<Double> yTrain) {
        int n = xTrain.size();
        double sumX = 0.0, sumY = 0.0, sumXY = 0.0, sumX2 = 0.0;

        // Calcular las sumatorias necesarias
        for (int i = 0; i < n; i++) {
            double x = xTrain.get(i);
            double y = yTrain.get(i);
            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumX2 += x * x;
        }

        // Calcular los coeficientes beta0 (intercepto) y beta1 (pendiente)
        beta1 = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        beta0 = (sumY - beta1 * sumX) / n;
    }

    // Método para predecir valores
    public double predict(double x) {
        return beta0 + beta1 * x;
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

    // Obtener los coeficientes para imprimir
    public double getBeta0() {
        return beta0;
    }

    public double getBeta1() {
        return beta1;
    }
}