// Main class
// Hold the storage for the program
// Set up storage and graphics

import javax.swing.*;

public class starryNight {
    // Constants: Dimensions of the screen, number of stars.
    public static final int WIDTH = 1500, HEIGHT = 1000, STARCOUNT = 100;

    // Make an array of stars to call from Star class, assign to variable myStar, and initialize the array.
    public static Star[] myStar = new Star[STARCOUNT];
    // Defining the variable here, but not making it until later on in main.
    // This allows sky to be referenced in another class.
    public static starryComponent sky;

    // Program starts here
    public static void main(String[] args) {
        // Create a single static star
        // To run this line, it will need a Star constructor that takes in 3 parameters.
        // myStar = new Star(50,30,20);

        for(int i = 0; i < myStar.length; i++) {
            // Since Star is taking in no parameters, it will run the Star constructor method that takes in no parameters.
                // This is called an OVERLOADED constructor.
            // When I say the line "new Star();"
                // Make a Star object in array position "i"
                // Runs a function called public Star(), which is a constructor.
            myStar[i] = new Star();
        }

        // Basic window setup
        JFrame myWindow = new JFrame("Starry Night");
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setSize(WIDTH, HEIGHT);

        // Creating a graphical object that will represent the sky.
        sky = new starryComponent();
        // Adding this object to the window.
            // Because we are not using panels, this will take up the entire window.
        myWindow.add(sky);

        // Make an object that operates on mouse clicks.
        starryMouseListener starryMouse = new starryMouseListener();
        // Associate it with "sky" so that it runs when I click on the sky.
        sky.addMouseListener(starryMouse);

        // Make the window appear
            // paintComponent located within sky will automatically run now.
        myWindow.setVisible(true);
    }
}
