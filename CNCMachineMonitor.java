import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CNCMachineMonitor {
    private final TemperatureSensor temperatureSensor = new TemperatureSensor();
    private final DimensionSensor dimensionSensor = new DimensionSensor();
    private final OperationTimeMonitor operationTimeMonitor = new OperationTimeMonitor();
    private final SelfTestAnalyzer selfTestAnalyzer = new SelfTestAnalyzer();

    public void process(float temp, float variation, int minutes, int selfTestCode) {
        temperatureSensor.check(temp);
        dimensionSensor.check(variation);
        operationTimeMonitor.check(minutes);
        selfTestAnalyzer.analyze(selfTestCode);
        System.out.println("---");
    }

    public static void main(String[] args) {
        CNCMachineMonitor monitor = new CNCMachineMonitor();
        String filePath = "cnc_data.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.trim().split("\\s+");
                if (parts.length != 4) {
                    System.err.println("Invalid data line: " + line);
                    continue;
                }

                try {
                    float temp = Float.parseFloat(parts[0]);
                    float variation = Float.parseFloat(parts[1]);
                    int minutes = Integer.parseInt(parts[2]);
                    int selfTest = Integer.decode(parts[3]);

                    monitor.process(temp, variation, minutes, selfTest);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing line: " + line);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
        }
    }
}
