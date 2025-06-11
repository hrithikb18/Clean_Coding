public class SelfTestAnalyzer {
    public void analyze(int code) {
        switch (code) {
            case 0xFF -> System.out.println("Self-test OK");
            case 0x00 -> System.out.println("ALERT: No data from machine (Environment)");
            case 0x01 -> System.out.println("ALERT: Controller board failure (Machine)");
            case 0x02 -> System.out.println("ALERT: Configuration data corrupted (Machine)");
            default   -> System.out.println("ALERT: Unknown self-test code (Machine)");
        }
    }
}
