// Reminder: "*" means "everything". AKA import everything from swing. This is FROWNED UPON, bloats the program storing all the applicable data.
import javax.swing.*;

public class firstGraphics {
    // Reminder..
        // Public: Available within other classes.
        // Static: GLOBAL variables, used throughout the entire program. Would say firstGraphics."variable name".
        // Final: These variables are CONSTANTS, cannot be changed.
        // Int: Variable type of integer.
    public static final int WIDTH = 500, HEIGHT = 500;

    public static void main(String[] args) {
        // Window setup stuff.
        JFrame myWindow = new JFrame("Graphics Stuff");
        // EXIT_ON_CLOSE: A CONSTANT variable aka "Final". Not method/function.
            // IS static because I called it on the JFrame CLASS, not the myWindow OBJECT variable.
        int op = JFrame.EXIT_ON_CLOSE;
        // setDefaultCloseOperation is a method/function, notice the parenthesis after.
            // NOT static because called on an individual object.
        myWindow.setDefaultCloseOperation(op);
        myWindow.setSize(WIDTH, HEIGHT); // NOTICE: if you're within the defined class, don't need "firstGraphics.".

        // Create a graphicsComponent object and add it to myWindow.
        graphicsComponent myGraphics = new graphicsComponent();
        myWindow.add(myGraphics);

        myWindow.setVisible(true);
    }
}
