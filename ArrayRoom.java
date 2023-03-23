import ecs100.*;
import java.awt.Color;
/**
 * creates an array of lamps (2)
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayRoom
{
    // fields/class constants (static)
    private static int STARTX = 70;
    private static int YPOS = 30;
    private static int MAXLAMPS = 5;
   
    // make an array of flowers 
    // private Lamp[] lampRow = new Lamp[MAXLAMPS];    // initialise array
    
    // 2d array
    private Lamp[][] chandelier = new Lamp[MAXLAMPS][MAXLAMPS];
    
    /**
     * Contructor for living room
     * 
     */
    public ArrayRoom(){
        // initialise instance variables
        UI.initialise();
        UI.addButton("Quit", UI::quit);
        
        // set up lamp positions
        for (int i = 0; i < MAXLAMPS; i++) {
            for (int j = 0; j < MAXLAMPS; j++) {
                chandelier[i][j] = new Lamp(STARTX*(j+1), YPOS*((i*2)+1), 30, 70, 30, Color.black); // use outer loop i
            }
        }
        
        //draw each flower (for each loop)
        for (Lamp[] lamps : chandelier) {
            for (Lamp lamp : lamps) {
                lamp.draw();
            }
        }
        
        //set up mouse
        UI.setMouseListener(this::doMouse);
    }
    
    /**
     * Select object based on where the user clicks
     */
    private void doMouse(String action, double x,double y) {
        if (action.equals("clicked")) {
            //check the location of the x and y of the obj
            for (Lamp[] lamps : chandelier) {
                for (Lamp lamp : lamps) {
                    if ((x >= lamp.getStemLeft()) && (x <= lamp.getStemRight()) &&
                        (y >= lamp.getStemTop()) && (y <= lamp.getStemBottom())){
                        if (lamp.checkState() == true){     // if the lamp is off = true
                            lamp.turnOn();                      
                        } else {
                            lamp.turnOff();       
                        }  
                    } else if ((x >= lamp.getBulbLeft()) && (x <= lamp.getBulbRight()) &&
                               (y >= lamp.getBulbTop()) && (y <= lamp.getBulbBottom())) {
                        if (lamp.checkState() == false) {     // if the lamp is off = false (lamp is o
                            lamp.changeColor();
                        } else {
                            lamp.turnOn();
                      }
                    }
                }
            }
        }
    }
}
