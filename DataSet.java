import java.util.ArrayList;
import java.util.List;

public class DataSet {
    List<Double> xValues;
    List<Double> yValues;

    public DataSet() {
        // Dataset de Batch Size y Machine Efficiency
        xValues = new ArrayList<>();
        yValues = new ArrayList<>();

        xValues.add(108.0); yValues.add(95.0);
        xValues.add(115.0); yValues.add(96.0);
        xValues.add(106.0); yValues.add(95.0);
        xValues.add(97.0);  yValues.add(97.0);
        xValues.add(95.0);  yValues.add(97.0);
        xValues.add(91.0);  yValues.add(94.0);
        xValues.add(97.0);  yValues.add(93.0);
        xValues.add(83.0);  yValues.add(92.0);
        xValues.add(78.0);  yValues.add(86.0);
        xValues.add(54.0);  yValues.add(73.0);
        xValues.add(67.0);  yValues.add(80.0);
        xValues.add(56.0);  yValues.add(65.0);
        xValues.add(53.0);  yValues.add(69.0);
        xValues.add(61.0);  yValues.add(77.0);
        xValues.add(115.0); yValues.add(96.0);
        xValues.add(81.0);  yValues.add(87.0);
        xValues.add(78.0);  yValues.add(89.0);
        xValues.add(100.0); yValues.add(90.0);
        xValues.add(45.0);  yValues.add(63.0);
        xValues.add(99.0);  yValues.add(95.0);
        xValues.add(32.0);  yValues.add(61.0);
        xValues.add(25.0);  yValues.add(55.0);
        xValues.add(28.0);  yValues.add(56.0);
        xValues.add(90.0);  yValues.add(94.0);
        xValues.add(89.0);  yValues.add(93.0);
    }

    // Método para segmentar el dataset en 70% entrenamiento y 30% prueba
    public List<List<Double>> segmentDataSet(double splitRatio) {
        int splitIndex = (int) (xValues.size() * splitRatio);

        List<Double> xTrain = xValues.subList(0, splitIndex);
        List<Double> yTrain = yValues.subList(0, splitIndex);

        List<Double> xTest = xValues.subList(splitIndex, xValues.size());
        List<Double> yTest = yValues.subList(splitIndex, yValues.size());

        List<List<Double>> segmentedData = new ArrayList<>();
        segmentedData.add(xTrain);
        segmentedData.add(yTrain);
        segmentedData.add(xTest);
        segmentedData.add(yTest);

        return segmentedData;
    }
}