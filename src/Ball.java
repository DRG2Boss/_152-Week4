// Used in ballExample
// Models an individual ball that has a position x,y and speed sx, sy
public class Ball {
    // ballX and ballY are replicated for each ball. Every ball has one, and they can all be different.
        // Therefore, they are called "fields" or "instance variables" and are NOT static.
            // They BELONG to the ball object.
    // When I say a class variable is PRIVATE, it means it can ONLY be used within this class.
    private double ballX, ballY;
    private double ballSpeedX, ballSpeedY;
    // The word STATIC means that it is a GLOBAL variable.
        // There is only ONE GRAVITY variable used throughout the entire program.
    // If I do NOT make a variable static, then I say:
        // aBall = new Ball();  aBall.ballX
    // If I DO make a variable static, then I say:
        // Ball.GRAVITY
    private static double gravity = 0.1;

    // Can call with Ball.zeroGravity, which sets gravity to 0.
    // This function is called a "setter" or a "mutator".
        // Function is designed to change its internal private variables.
    public static void zeroGravity() {
        gravity = 0;
    }

    // The "Constructor Function" below is automatically called when we say "new Ball."
    // It is defined by the following:
        // Same name as the class.
        // NO defined return type.
        // Always at LEAST one Constructor per class (except for main).
    // The Constructor's job it to initialize all the global variables.
        // How? Some variables you may pass in as parameters (ex: startX and startY below).
        // Other variables like ballSpeedX you might generate inside of Ball().
    public Ball(int startX, int startY) {
        ballX = startX;
        ballY = startY;

        ballSpeedX = Math.random() * 2 - 1;
        ballSpeedY = Math.random() * 2 - 1;
    }

    public boolean areYouAt(int x, int y) {
        /* Old Method:
        if(x == ballX && y == ballY) {
            return true;
        }
        else {
            return false;
        }
        */
        // New Easier Method
        // Will automatically return true/false depending on condition.
        return x == Math.round(ballX) && y == Math.round(ballY);
    }
    
    // Move the ball one space and bounce it if it hits a wall
    public void move() {
        // Adjusts the ball's Y speed so gravity pulls it downwards.
        ballSpeedY += gravity;
        // Want ball to move northeast (x+1, y-1)
        ballX = ballX + ballSpeedX;
        ballY = ballY + ballSpeedY;

        // Make the ball bounce off of the edges of the grid.
        if(ballY >= ballExample.HEIGHT - 1 || ballY < 0) {
            // Special case: Bounces off floor? Want to reduce speed.
            if(ballY >= ballExample.HEIGHT) {
                ballSpeedY = ballSpeedY * .3;
            }
            ballSpeedY = -ballSpeedY;
            if(ballY > ballExample.HEIGHT - 1) {
                ballY = ballExample.HEIGHT - 1;
            }
            if(ballY < 0) {
                ballY = 0;
            }
        }
        if(ballX < 0 || ballX > ballExample.WIDTH - 1) {
            ballSpeedX = -ballSpeedX;
            if(ballX > ballExample.WIDTH - 1) {
                ballX = ballExample.WIDTH - 1;
            }
            if(ballX < 0) {
                ballX = 0;
            }
        }
    }

    // This function does nothing more than passes a private internal variable.
        // Allows me to share the variable WITHOUT allowing other classes to modify it.
        // "Accessor" or "Getter" function.
    public double getBallY() {
        return ballY;
    }
}
