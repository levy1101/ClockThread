import javax.swing.*;
import java.awt.*;

public class ClockThread extends JFrame {
    private JTextField timezoneField;

    public ClockThread() {
        setTitle("Clock App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 120);
        setLocationRelativeTo(null);

        timezoneField = new JTextField(10);
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            String timezoneText = timezoneField.getText().trim();
            try {
                int timezoneOffset = Integer.parseInt(timezoneText);
                Clock clock = new Clock(timezoneOffset);
                clock.setVisible(true);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid timezone format!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Timezone Offset: "));
        panel.add(timezoneField);
        panel.add(addButton);

        getContentPane().add(panel, BorderLayout.CENTER);
    }
}
