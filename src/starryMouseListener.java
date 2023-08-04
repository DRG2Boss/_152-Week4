// This object will listen to mouse clicks on "sky" and respond to them.
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// To give this object "mouse listening" powers, must implement an interface called MouseListener.

// "Implements" does NOT mean you're a subclass like with extends.
// It means you MUST have certain functions/methods.
// For example, the MouseListener interface DEMANDS that you have:
    // mousePressed
    // mouseReleased
    // mouseClicked
    // mouseEntered
    // mouseExited
public class starryMouseListener implements MouseListener {
    public void mouseClicked(MouseEvent e) {
        // Get the coordinates of where I clicked.
        int xPressed = e.getX();
        int yPressed = e.getY();
        System.out.println("Clicked " + xPressed + ", " + yPressed);

        // Did I click on a star?
        // Go through every star and check.
        for(Star s : starryNight.myStar) {
            // Check s: Did I click on it?
                // Make a function in class Star didIClickOnYou
                // Pass in info: coordinates of click
                // Function should give me a boolean value.
            if(s.didIClickOnYou(xPressed, yPressed)) {
                System.out.println("Clicked on a star!");
                // To make it vanish:
                    // Change the info on whether a star is vanished to YES.
                    // Redraw the screen
                s.vanish();
            }
        }
        // Update the screen so it automatically reruns paintComponent.
            // If I do not do this, stars will remain visible until paintComponent manually runs again.
        starryNight.sky.repaint();
    }

    // Must have the rest of these, but leaving them empty because they are not used.
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

}
