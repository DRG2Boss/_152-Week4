// Isaiah Marshall
// Comp Sci 152
// July 31st, August 1st, and 2nd

public class ballExample {
    // Set class variables.
    // FINAL means it's set once, can never be changed.
    public static final int HEIGHT = 15, WIDTH = 30, DT = 50;
    // Create myBall array to call from Ball class.
    // new Ball is a special function: "Constructor"
    // NOTE: I don't have 12 balls yet, I have 12 spaces available to hold 12 balls.
    public static int frames = 0;
    public static Ball[] myBall = new Ball[12];
    public static void drawFrame() {

        // Make a width by height grid of dots.
        // Vertical axis = y
        for(int y = 0; y < HEIGHT; y++) {
            // Horizontal axis = x
            for(int x = 0; x < WIDTH; x++) {
                // Assume shouldIDrawBall is false unless proven otherwise.
                boolean shouldIDrawBall = false;

                // If our x,y happens to match ballX,ballY don't draw "." instead draw "O"
                // Go through EVERY ball, and ask question indivBall.areYouAt
                    // This is the equivalent of a "for each" loop in Python.
                    // Choose each ball within myBall one at a time.
                    // Then call each "indivBall" within the loop.
                        // ":" == within
                for(Ball indivBall : myBall) {
                    indivBall.areYouAt(x,y);
                    // This will ask the ball if it is here.
                    if(indivBall.areYouAt(x,y)) {
                        // The ball is here, so draw it.
                        shouldIDrawBall = true;
                    }
                    // No "else" needed. Just because one ball isn't here doesn't mean another won't be.
                }
                if(shouldIDrawBall) {
                    System.out.print("O");
                }
                else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) throws InterruptedException {
        // Create the balls using a for loop.
        for(int i = 0; i < myBall.length; i++) {
            // Give them each their own position based on "i".
            myBall[i] = new Ball(i,i);
        }

        // Real-time animation:
            // 1. Draw a frame
            // 2. Move the balls
            // 3. Wait a specific amount of time per movement
            // 4. Delete gravity after 5 seconds
            // 5. Stop program when first ball bounces off of floor

        while(true) {
            // Draw a frame
                // This will call above function
            drawFrame();
            // Move the balls.
                // This is the equivalent of a "for each" loop in Python.
                // Choose each ball within myBall one at a time.
                // Then call each "indivBall" within the loop.
                    // ":" == within
            for(Ball indivBall : myBall) {
                indivBall.move();
            }

            // Wait a specific amount of time per movement
            Thread.sleep(DT);

            // After running for 5 seconds, let's eliminate gravity.
            frames = frames + 1;
            if(frames==50) {
                Ball.zeroGravity();
            }

            // Stop when first ball hits the floor.
            if(myBall[0].getBallY() >= HEIGHT - 1) {
                break;
            }
        }
    }
}
