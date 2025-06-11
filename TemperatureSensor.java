public class TemperatureSensor {
    public void check(float value) {
        if (value > 35.0f) {
            System.out.println("ALERT: High temperature detected (Environment)");
        }
    }
}
