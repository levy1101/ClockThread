import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Clock extends JFrame {
    private JLabel timeLabel;
    private int timezoneOffset;

    public Clock(int timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
        setTitle("Clock - UTC" + (timezoneOffset >= 0 ? "+" : "") + timezoneOffset);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        timeLabel = new JLabel();
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        updateTime();

        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        getContentPane().add(timeLabel, BorderLayout.CENTER);
    }

    private void updateTime() {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        long currentTimeMillis = System.currentTimeMillis();
        long offsetMillis = timeZone.getRawOffset() + (timezoneOffset * 3600 * 1000);
        long currentTimeZoneMillis = currentTimeMillis + offsetMillis;
        Date currentTimeZoneDate = new Date(currentTimeZoneMillis);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone.getID()));
        String formattedTime = dateFormat.format(currentTimeZoneDate);
        timeLabel.setText("Current Time: " + formattedTime);
    }
}
