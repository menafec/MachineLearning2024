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
        System.out.println("3. Regresión Cúbica");

        int choice = scanner.nextInt();
        PolynomialRegression model = null;

        switch (choice) {
            case 1:
                // Regresión Lineal Simple (grado 1)
                model = new PolynomialRegression(1);
                break;
            case 2:
                // Regresión Cuadrática (grado 2)
                model = new PolynomialRegression(2);
                break;
            case 3:
                // Regresión Cúbica (grado 3)
                model = new PolynomialRegression(3);
                break;
            default:
                System.out.println("Opción no válida.");
                scanner.close();
                return;
        }

        // Entrenar el modelo seleccionado
        model.train(xTrain, yTrain);

        System.out.println("Coeficientes:");
        for (int i = 0; i <= model.getDegree(); i++) {
            System.out.println("Beta" + i + ": " + model.getCoefficient(i));
        }

        System.out.println("Predicciones:");
        System.out.println("Predicción para Batch Size 15: " + model.predict(15));
        System.out.println("Predicción para Batch Size 25: " + model.predict(25));

        System.out.println("Coeficiente de Determinación (R^2): " + model.calculateR2(xTest, yTest));

        scanner.close();
    }
}
