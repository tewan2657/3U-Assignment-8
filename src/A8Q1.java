
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

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
    Color dPeach = new Color(209, 194, 131);
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
    int pupilRight = 600;
    int pupilD2 = 1;
    //eyes animtion
    int eyeLeft = 415;
    int eyeD1 = 1;
    int eyeRight = 615;
    int eyeD2 = 1;
    //Ear animation 
    int earLeft = 190;
    int earD1 = 1;
    int earRight = 190;
    int earD2 = 1;
    //moustache animation
    int mous = 425;
    int mousD1 = 1;
    boolean reached = false;

    // GAME VARIABLES END HERE   
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
//        Random rand = new Random();
//        int sieze = rand.nextInt(10) + 1;
//        switch (sieze) {
//            case 1:
//                g.setColor(Color.BLACK);
//                break;
//            case 10:
//                g.setColor(Color.RED);
//                break;
//            case 2:
//                g.setColor(Color.BLUE);
//                break;
//            case 3:
//                g.setColor(Color.GREEN);
//                break;
//            case 4:
//                g.setColor(Color.ORANGE);
//                break;
//            case 5:
//                g.setColor(Color.MAGENTA);
//                break;
//            case 6:
//                g.setColor(Color.YELLOW);
//                break;
//            case 7:
//                g.setColor(Color.CYAN);
//                break;
//            case 8:
//                g.setColor(Color.PINK);
//                break;
//            case 9:
//                g.setColor(Color.GRAY);
//                break;
//            default:
//                break;
//        }
//        g.fillRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE 

        //Ears 
        g.setColor(dPeach);
        g.fillOval(250, earLeft, 75, 200);
        g.fillOval(725, earRight, 75, 200);

        //head of the person
        g.setColor(Peach);
        g.fillOval(275, 75, 500, 600);

        //Eyeball
        g.setColor(Color.WHITE);
        g.fillOval(375, 250, 100, 60);
        g.fillOval(575, 250, 100, 60);

        //Pupils
        g.setColor(Brown);
        g.fillOval(pupilLeft, 253, 50, 55);
        g.fillOval(pupilRight, 253, 50, 55);

        g.setColor(Color.BLACK);
        g.fillOval(eyeLeft, 270, 20, 20);
        g.fillOval(eyeRight, 270, 20, 20);

        //eyebrows
        g.setColor(Color.BLACK);
        g.fillOval(375, eyebrowLeft, 100, 20);
        g.fillOval(575, eyebrowRight, 100, 20);

        //hair
        g.fillArc(325, 75, 400, 250, 0, 180);

        //nose
        g.drawArc(487, 250, 75, 200, 180, 180);

        //moustache
        g.fillArc(mous, 465, 200, 20, 200, 140);

        //mouth\
        g.setColor(Brown);
        g.fillOval(425, 500, 200, 60);

        //teeth 
        g.setColor(Color.WHITE);
        g.fillRect(503, 500, 20, 20);
        g.fillRect(524, 500, 20, 20);

        //tongue 
        g.setColor(Color.RED);
        g.fillArc(500, 545, 50, 30, 0, 180);

        //lips
        // g.fillArc(425, 520, 200, 40, 180, 180);

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


            //eyeRight
            if (eyeRight <= 700 && reached == false) {
                eyeD2 = 1;

                if (eyeRight == 700) {
                    reached = true;
                }
            }
            if (eyeRight >= 200 && reached == true) {
                eyeD2 = -1;

                if (eyeRight == 200) {
                    reached = false;
                }
            }
            eyeRight = eyeRight + eyeD2;


            //EyesLeft
            if (eyeLeft <= 500 && reached == false) {
                eyeD1 = 1;

                if (eyeLeft == 500) {
                    reached = true;
                }
            }
            if (eyeLeft >= 200 && reached == true) {
                eyeD1 = -1;

                if (eyeLeft == 200) {
                    reached = false;
                }
            }
            eyeLeft = eyeLeft + eyeD1;

            //PupilRight
            if (pupilRight <= 700 && reached == false) {
                pupilD2 = 1;

                if (pupilRight == 700) {
                    reached = true;
                }
            }
            if (pupilRight >= 200 && reached == true) {
                pupilD2 = -1;

                if (pupilRight == 200) {
                    reached = false;
                }
            }
            pupilRight = pupilRight + pupilD2;

            //pupilLeft
            if (pupilLeft <= 500 && reached == false) {
                pupilD1 = 1;

                if (pupilLeft == 500) {
                    reached = true;
                }
            }
            if (pupilLeft >= 200 && reached == true) {
                pupilD1 = -1;

                if (pupilLeft == 200) {
                    reached = false;
                }
            }
            pupilLeft = pupilLeft + pupilD1;



            //EyebrowLEFT
            if (eyebrowLeft >= 200 && reached == false) {
                eyebrowDirection = -1;

                if (eyebrowLeft == 200) {
                    reached = true;
                }
            }
            if (eyebrowLeft <= 227 && reached == true) {

                eyebrowDirection = 1;

                if (eyebrowLeft == 227) {
                    reached = false;
                }
            }
            eyebrowLeft = eyebrowLeft + eyebrowDirection;

            //EyebrowRight
            if (eyebrowRight >= 200 && reached == false) {
                eyebrowD2 = -1;

                if (eyebrowRight == 200) {
                    reached = true;
                }
            }
            if (eyebrowRight <= 227 && reached == true) {

                eyebrowD2 = 1;

                if (eyebrowRight == 227) {
                    reached = false;
                }
            }
            eyebrowRight = eyebrowRight + eyebrowD2;



            //ear Left
            if (earLeft <= 200 && reached == false) {
                earD1 = 1;

                if (earLeft == 200) {
                    reached = true;
                }
            }
            if (earLeft >= 300 && reached == true) {
                earD1 = -1;

                if (earLeft == 300) {
                    reached = false;
                }
            }
            earLeft = earLeft + earD1;

            //earRight
            if (earRight <= 200 && reached == false) {
                earD2 = 1;

                if (earRight == 200) {
                    reached = true;

                }
            }
            if (earRight >= 300 && reached == true) {
                earD2 = -1;

                if (earRight == 300) {
                    reached = false;
                }
            }
            earRight = earRight + earD2;

            //moustache
            if (mous <= 450 && reached == false) {
                mousD1 = 1;

                if (mous == 450) {
                    reached = true;
                }
            }
            if (mous >= 300 && reached == true) {
                mousD1 = -1;

                if (mous == 300) {
                    reached = false;
                }
            }
            mous = mous + mousD1;
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

            System.out.println("X = " + e.getX() + " Y = " + e.getY());
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
