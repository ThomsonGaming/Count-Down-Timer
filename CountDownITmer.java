import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

public class BreakTimer {
    public static void main(String[] args) throws InterruptedException {
        // Set the screen resolution
        int screenWidth = 1920;
        int screenHeight = 1080;

        // Create a JFrame window
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setSize(screenWidth, screenHeight);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the background color to transparent
        frame.setBackground(new Color(0, 0, 0, 0));
        frame.setOpacity(0.0f);

        // Create a label to display the countdown timer
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(screenWidth, screenHeight));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(label.getFont().deriveFont(72.0f));

        // Add the label to the window
        frame.add(label);

        // Prompt the user to enter the duration of the break
        int duration = Integer.parseInt(System.console().readLine("Enter the duration of the break (in minutes): "));

        // Convert the duration to seconds
        int durationInSeconds = duration * 60;

        // Display a countdown timer
        for (int i = durationInSeconds; i > 0; i--) {
            int minutes = i / 60;
            int seconds = i % 60;
            label.setText(String.format("%02d:%02d", minutes, seconds));
            frame.setVisible(true);
            Thread.sleep(1000);
        }

        label.setText("Time's up!");
        frame.setVisible(true);
        Thread.sleep(2000);
        frame.dispose();
    }
}
