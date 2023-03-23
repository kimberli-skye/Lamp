import ecs100.*;
import java.awt.Color;
/**
 * creates an array of lamps (2)
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class livingRoom
{
    // fields/class constants (static)
    private static int STARTX = 70;
    private static int YPOS = 30;
    private static int MAXLAMPS = 5;
   
    // make an array of flowers 
    private Lamp[] lampRow = new Lamp[MAXLAMPS];    // initialise array
    
    /**
     * Contructor for living room
     * 
     */
    public livingRoom(){
        // initialise instance variables
        UI.initialise();
        UI.addButton("Quit", UI::quit);
        
        // set up lamp positions
        for (int i = 0; i < MAXLAMPS; i++) {
            lampRow[i] = new Lamp(STARTX*(i+1), YPOS, 40, 75, 40, Color.black);
        }
        
        //draw each flower (for each loop)
        for (Lamp Lamp : lampRow) {
            Lamp.draw();
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
            for (Lamp Lamp : lampRow) {
                if ((x >= Lamp.getStemLeft()) && (x <= Lamp.getStemRight()) &&
                    (y >= Lamp.getStemTop()) && (y <= Lamp.getStemBottom())){
                    if (Lamp.checkState() == true){     // if the lamp is off = true
                        Lamp.turnOn();                      
                    } else {
                        Lamp.turnOff();       
                    }
                } else if ((x >= Lamp.getBulbLeft()) && (x <= Lamp.getBulbRight()) &&
                            (y >= Lamp.getBulbTop()) && (y <= Lamp.getBulbBottom())) {
                    if (Lamp.checkState() == false) {     // if the lamp is off = false (lamp is on)
                        Lamp.changeColor();
                    } else {
                        Lamp.turnOn();
                  }
                }
            }
        }
    }
}
