
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author tewan2657
 */
public class A8Q1 extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 1000;
    static final int HEIGHT = 800;
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    
    // GAME VARIABLES WOULD GO HERE
    //Colors
    Color Peach = new Color(212, 195, 140);
    Color Brown = new Color(66, 55, 20);
    
    //eyebrows animation 
    int eyebrowLeft = 227;
    int eyebrowDirection = 1;
    
    int eyebrowRight = 227;
    int eyebrowD2 = 1;
    
    
    //pupil animation x-axis
    int pupilLeft = 400;
    int pupilD1 = 1;
    
    
    
   boolean reached = false;

 

    // GAME VARIABLES END HERE   
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE 

        //hair



        //head of the person
        g.setColor(Peach);
        g.fillOval(275, 75, 500, 600);

        //Eyes
        g.setColor(Color.WHITE);
        g.fillOval(375, 250, 100, 60);
        g.fillOval(575, 250, 100, 60);

        //Pupils
        g.setColor(Brown);
        g.fillOval(pupilLeft, 253, 50, 55);
        g.fillOval(600, 253, 50, 55);
          
        g.setColor(Color.BLACK);
        g.fillOval(415, 270, 20, 20);
        g.fillOval(615, 270, 20, 20);

        //eyebrows
        g.setColor(Color.BLACK);
        g.fillOval(375,eyebrowLeft, 100, 20);
        g.fillOval(575, eyebrowRight, 100, 20);

        //hair
        g.fillOval(325, 75, 400, 100);



        //mouth
        g.setColor(Brown);
        g.fillOval(425, 500, 200, 60);

        //teeth 
        g.setColor(Color.WHITE);
        g.fillRect(503, 500, 20, 20);
        g.fillRect(524, 500, 20, 20);
        

        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;

        preSetup();

        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE
            
            if( pupilLeft <= 500 && reached == false){
                pupilD1 = 1;
            
            if(pupilLeft == 500){
                reached = true;
            }
            }
            if(pupilLeft >= 200 && reached == true){
                pupilD1 = -1;
                
                if(pupilLeft == 200){
                    reached = false;
                }
            }
            pupilLeft = pupilLeft + pupilD1;
            
           
            
            
            
            
            //EyebrowLEFT
            if(eyebrowLeft >= 200 && reached == false){
                eyebrowDirection = -1;
                
                if(eyebrowLeft == 200 ){
                    reached = true;
                }
            }
             if(eyebrowLeft <= 227 && reached == true) {
            
                eyebrowDirection = 1;
                
                if(eyebrowLeft == 227 ){
                    reached = false;
                }
            }
           eyebrowLeft = eyebrowLeft + eyebrowDirection;

           //EyebrowRight
           if(eyebrowRight >= 200 && reached == false){
                eyebrowD2 = -1;
                
                if(eyebrowRight == 200 ){
                    reached = true;
                }
            }
             if(eyebrowRight <= 227 && reached == true) {
            
                eyebrowD2 = 1;
                
                if(eyebrowRight == 227 ){
                    reached = false;
                }
            }
           eyebrowRight = eyebrowRight + eyebrowD2;

            
           
            // GAME LOGIC ENDS HERE 
            // update the drawing (calls paintComponent)
            repaint();

            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try {
                if (deltaTime > desiredTime) {
                    //took too much time, don't wait
                    Thread.sleep(1);
                } else {
                    // sleep to make up the extra time
                    Thread.sleep(desiredTime - deltaTime);
                }
            } catch (Exception e) {
            };
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");

        // creates an instance of my game
        A8Q1 game = new A8Q1();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(game);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        game.addMouseListener(new Mouse());

        // starts the game loop
        game.run();
    }

    // Used to implement any of the Mouse Actions
    private static class Mouse extends MouseAdapter {
        // if a mouse button has been pressed down

        @Override
        public void mousePressed(MouseEvent e) {
            
            System.out.println("X = " +  e.getX() + " Y = " + e.getY());
        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    // Used to implements any of the Keyboard Actions
    private static class Keyboard extends KeyAdapter {
        // if a key has been pressed down

        @Override
        public void keyPressed(KeyEvent e) {
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
