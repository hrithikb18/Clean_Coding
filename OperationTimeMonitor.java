public class OperationTimeMonitor {
    public void check(int minutes) {
        if (minutes > 360) {
            System.out.println("ALERT: Continuous operation exceeded 6 hours (Machine)");
        }
    }
}
