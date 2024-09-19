import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataSet dataSet = new DataSet();
        List<List<Double>> segmentedData = dataSet.segmentDataSet(0.7); // Segmentar 70%-30%

        List<Double> xTrain = segmentedData.get(0);
        List<Double> yTrain = segmentedData.get(1);
        List<Double> xTest = segmentedData.get(2);
        List<Double> yTest = segmentedData.get(3);

        System.out.println("Seleccione el modelo a evaluar:");
        System.out.println("1. Regresión Lineal Simple");
        System.out.println("2. Regresión Cuadrática");

        int choice = scanner.nextInt();

        if (choice == 1) {
            SimpleLinearRegression slr = new SimpleLinearRegression();
            slr.train(xTrain, yTrain);

            System.out.println("Coeficientes:");
            System.out.println("Beta0: " + slr.getBeta0());
            System.out.println("Beta1: " + slr.getBeta1());

            System.out.println("Predicciones para valores conocidos y desconocidos:");
            System.out.println("Predicción para Batch Size 15: " + slr.predict(15));
            System.out.println("Predicción para Batch Size 25: " + slr.predict(25));
            System.out.println("Predicción para Batch Size 35: " + slr.predict(35));
            System.out.println("Predicción para Batch Size 45: " + slr.predict(45));
            System.out.println("Predicción para Batch Size 55: " + slr.predict(55));

            System.out.println("Coeficiente de Determinación (R^2): " + slr.calculateR2(xTest, yTest));
            System.out.println("Correlación: " + slr.calculateCorrelation(xTest, yTest));

        } else if (choice == 2) {
            QuadraticRegression qr = new QuadraticRegression();
            qr.train(xTrain, yTrain);

            System.out.println("Coeficientes:");
            System.out.println("Beta0: " + qr.getBeta0());
            System.out.println("Beta1: " + qr.getBeta1());
            System.out.println("Beta2: " + qr.getBeta2());

            System.out.println("Predicciones para valores conocidos y desconocidos:");
            System.out.println("Predicción para Batch Size 15: " + qr.predict(15));
            System.out.println("Predicción para Batch Size 25: " + qr.predict(25));
            System.out.println("Predicción para Batch Size 35: " + qr.predict(35));
            System.out.println("Predicción para Batch Size 45: " + qr.predict(45));
            System.out.println("Predicción para Batch Size 55: " + qr.predict(55));

            System.out.println("Coeficiente de Determinación (R^2): " + qr.calculateR2(xTest, yTest));
            System.out.println("Correlación: " + qr.calculateCorrelation(xTest, yTest));
        } else {
            System.out.println("Opción no válida.");
        }

        scanner.close();
    }
}