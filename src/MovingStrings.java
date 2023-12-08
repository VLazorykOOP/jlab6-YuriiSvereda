import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MovingStrings extends JFrame {
    String[] strings = {"Hello", "World", "Java", "Programming"};
    Random random = new Random();

    public MovingStrings() {
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            int x = random.nextInt(200);
            int y = random.nextInt(200);
            int dx = random.nextInt(5) - 2; // Random direction
            int dy = random.nextInt(5) - 2; // Random direction
            String string = strings[random.nextInt(strings.length)]; // Random string

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString(string, x, y);

                if (x < 0 || x > getWidth()) {
                    dx = -dx;
                }
                if (y < 0 || y > getHeight()) {
                    dy = -dy;
                }

                x += dx;
                y += dy;
                repaint();
            }
        };

        add(panel);
        setVisible(true);
    }
}
