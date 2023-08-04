// This defines a single star within the starryNight sky.
import java.awt.*;

public class Star {
    // Every star has x, y, size, and c.
    private int x;
    private int y;
    private int size;
    private Color c;
    // If hidden, do not draw the star.
    private boolean hidden;

    // Make a constructor
        // Same name as class
        // No return type
    public Star(int x, int y, int size) {
        // "This" means to take the local variable WITHIN the constructor and assign it to a variable within the class.
        this.x = x;
        this.y = y;
        this.size = size;
        c = Color.WHITE;
        hidden = false;
    }
    // This is an OVERLOADED constructor, Star() will be called if there are no parameters on new Star()
    // Overriding another constructor with one that takes in different parameters is referred to as OVERLOADING.
    // Make a RANDOM star
    // In a good constructor, every field should have a value at end of constructor.
    public Star() {
        // Random coordinate
        x = (int) (Math.random() * starryNight.WIDTH);
        y = (int) (Math.random() * starryNight.HEIGHT);
        // Random size between 10 and 50
        size = (int) (Math.random() * (50-10)+10);
        // Random color made up of three random integers between 0 - 255.
        c = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
        // By default, stars are visible.
        hidden = false;

    }

    // This function will draw itself based on g.
    public void drawYourself(Graphics g) {
        // Check if we are hidden first.
        if(hidden) {
            // Quit the function early so the star is never drawn.
            return;
        }
        // Actually draw each star.
        g.setColor(c);
        g.drawLine(x, y - size / 2, x, y + size / 2);
        g.drawLine(x - size / 2, y, x + size / 2, y);
        g.drawLine(x - size / 2, y - size / 2, x + size / 2, y + size / 2);
        g.drawLine(x - size / 2, y + size / 2, x + size / 2, y - size / 2);
    }

    // Checks whether a provided coordinates are inside the star bounds.
    public boolean didIClickOnYou(int xPressed, int yPressed) {
        return xPressed >= x - size / 2 && xPressed <= x + size / 2 && yPressed >= y - size / 2 && yPressed <= y + size / 2;
    }
    // Sets hidden to true if vanish is run on a particular star.
    public void vanish() {
        hidden = true;
    }
}
