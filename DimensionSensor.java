public class DimensionSensor {
    public void check(float variation) {
        if (variation > 0.05f) {
            System.out.println("ALERT: Part-dimension variation too high (Machine)");
        }
    }
}
