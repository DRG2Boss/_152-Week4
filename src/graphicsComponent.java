import javax.swing.*;
import java.awt.*;
public class graphicsComponent extends JComponent {
    // paintComponent is called automatically by the operating system. Whenever:
        // setVisible(true)
        // Resizing the window
        // When function repaint() is used
    // Job of paintComponent is to render our graphics; (Graphics "variable") component.
    public void paintComponent(Graphics g) {
        // Make entire window background white
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, firstGraphics.WIDTH, firstGraphics.HEIGHT);
        // Draw purple "P"
        Color myPurple = new Color(109, 65, 140); // Googled purple RGB value.
        g.setColor(myPurple);
        g.drawLine(250, 100, 250, 225);
        g.drawOval(250, 100, 50, 50);
        // Draw orange square
        g.setColor(Color.ORANGE);
        int size = 50;
        int topX = firstGraphics.WIDTH/2 - size/2;
        int topY = firstGraphics.HEIGHT/2 - size/2;
        g.fillRect(topX, topY, size, size);
        // Draw black "P" as a string
        g.setColor(Color.BLACK);
        g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 100));
        g.drawString("P", 200, 400);

        System.out.println("Paint component ran.");
    }
}
