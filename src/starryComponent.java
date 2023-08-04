// This creates a big graphical object I can add to the window.
// This object will paint a night sky and fill it with the stars built in class Star.

import javax.swing.*;
import java.awt.*;

// extends JComponent
    // Subclass will inherit all the "powers" of JComponent
    // For example: We have variables and methods that we get.
        // Such as .addMouseListener
    // This makes it addable to a JFrame window.
public class starryComponent extends JComponent {

    // This is called AUTOMATICALLY when we make the window visible.
    // This make this be called automatically, must use the method paintComponent(Graphics variable).
    public void paintComponent(Graphics g) {
        // Draw stuff here.
        // Here's where I actually draw the sky and the stars.

        // Make a background.
        g.setColor(Color.BLACK);
        g.fillRect(0,0,starryNight.WIDTH, starryNight.HEIGHT);

        // For each star "s" within the myStar array.
        for(Star s : starryNight.myStar) {
            // We could have set up some stars in myStar[] to be nonexistent AKA NULL.
                // For example: certain positions were never initialized, or maybe they were deleted.
            // If that's the case, some s may be null.
            // Check if it's null and don't call functions on s if it is to avoid errors.
            if(s!=null) {
                // Tell the star (if it's NOT null) to draw itself, giving it the graphics object
                s.drawYourself(g);
            }
        }
    }
}