import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClockThread clockThread = new ClockThread();
            clockThread.setVisible(true);
        });
    }
}
