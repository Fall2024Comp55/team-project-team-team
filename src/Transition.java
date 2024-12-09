import javax.swing.*;
import java.awt.*;

public class Transition extends JPanel {
    private float alpha = 0.0f; 
    private Runnable onComplete; // Action to perform after the fade completes
//done again
    public Transition(Runnable onComplete) {
        this.onComplete = onComplete;
        Timer timer = new Timer(50, e -> {
            alpha += 0.05f;
            if (alpha >= 1.0f) {
                alpha = 1.0f;
                ((Timer) e.getSource()).stop();
                if (onComplete != null) {
                    onComplete.run();
                }
            }
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Screen Transition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Initial screen
        JPanel firstScreen = new JPanel();
        firstScreen.setBackground(Color.BLUE);
        firstScreen.add(new JLabel("First Screen"));

        // Next screen
        JPanel secondScreen = new JPanel();
        secondScreen.setBackground(Color.GREEN);
        secondScreen.add(new JLabel("Second Screen"));

        // Show the first screen initially
        frame.setContentPane(firstScreen);
        frame.setVisible(true);

        // Start transition after 2 seconds
        new Timer(2000, e -> {
            ((Timer) e.getSource()).stop();
            Transition transitionPanel = new Transition(() -> {
                // Replace with the second screen after the fade
                frame.setContentPane(secondScreen);
                frame.revalidate();
            });
            frame.setContentPane(transitionPanel);
            frame.revalidate();
        }).start();
    }
}
