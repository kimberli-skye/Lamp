import ecs100.*;
import java.awt.Color;

/**
 * draws a lamp
 *
 * @author KJ
 * @version 21/03/23
 */

public class Lamp
{
    private Color bulbColor;
    // instance variables
    private double lampX;      // x pos of the flower
    private double lampY;      // y pos of the flower
    
    private int lampSize;             // flower size
    private int lampHeight;           // flower height
    private int bulbHeight;

    private double left;                // left of the flower
    private double top;                 // top of the flower
    private double bottom;              // bottom of the flower
    
    private boolean stateOff;          // Is the state off?
    private boolean colorBlack;        // Is the color black?
   
    /**
     * Constructor for objects of class DrawLolipop
     */
    public Lamp(double x, double y, int size, int stem, int bulb, Color col)
    {
        // initialise instance variables
        this.lampX = x;
        this.lampY = y;
        this.lampSize = size;
        this.lampHeight = stem;
        this.bulbColor = col;
        this.bulbHeight = bulb;
        
        // set the top, left, and bottom 
        setTop();
        setLeft();
        setBottom();
    }
    
    // The getters for the stem location
    /**
     * Getter for stem left
     * needs to return something (not void)
     */
    public double getStemLeft() {
        //half the stem width
        double STEMWDITHHALF = 2.5;
        return this.left+(lampSize/2.0)-STEMWDITHHALF;
    }
    
    /**
     * Getter Stem right
     * needs to return something (not void)
     */
    public double getStemRight() {
        //half the stem width
        double STEMWDITHHALF = 2.5;
        return (this.left + this.lampSize)-(lampSize/2.0)+STEMWDITHHALF;
    }
    
    /**
     * Getter Stem top
     * needs to return something (not void)
     */
    public double getStemTop() {
        return (this.top + this.bulbHeight);
    }
    
    /**
     * Getter Stem bottom
     * needs to return something (not void)
     */
    public double getStemBottom() {
        return this.bottom;
    }
    
    // The getters for the bulb location
    
    /**
     * gets the bulb left location
     */
    public double getBulbLeft() {
        // take the diameter (size) cut in half and subtract from the x
        return this.left;
    }
    /**
     * gets bulb top location
     */
    public double getBulbTop() {
        // take the diameter (size) cut in half and subtract from the Y
        return this.top;
    }
    /**
     * gets bulb bottom location
     */
    public double getBulbBottom() {
        // take the diameter (size) cut in half and subtract from the Y
        return this.top + this.bulbHeight;
    }
    /**
     * Gets bulb right location
     */
    public double getBulbRight() {
        return this.left+this.lampSize;
    }
    
    // encapsulated (protecting from editing outside of the class
    /**
     * Set left
     */
    public void setLeft() {
        // take the diameter (size) cut in half and subtract from the x
        this.left = this.lampX - this.lampSize/2.0;
    }
    /**
     * Set top
     */
    public void setTop() {
        // take the diameter (size) cut in half and subtract from the Y
        this.top = this.lampY - this.lampSize/2.0;
    }
    /**
     * Set bottom
     */
    public void setBottom() {
        // take the diameter (size) cut in half and subtract from the Y
        this.bottom = this.lampY + this.bulbHeight;
    }
    
   
    /**
     * Draw a lollipop
     * 
     */
    public void draw(){
        
        //constant
        final int STEMWIDTH = 5;
        final int BULBWIDTH = 1;
        
        //draw the stick
        UI.setLineWidth(STEMWIDTH);
        UI.setColor(Color.gray);
        UI.drawLine(lampX, lampY, lampX, bottom);
       
        // draw the lolly
        UI.setLineWidth(BULBWIDTH);
        UI.setColor(bulbColor);
        UI.fillOval(left, top, lampSize, lampSize);
        
        // bulbColor is black (checky living room)
        this.colorBlack = true;
    }
    /**
     * Checks if the lamp is on or off
     */
    public boolean checkState() {
        if (this.colorBlack == true) {
            this.stateOff = true;
        } else {
            this.stateOff = false;
        }
        
        return this.stateOff;
        
    }
    
    /**
     * Turn on or off (change from black to yellow
     */
    public void turnOn() {
        // draw the lolly
        final int BULBWIDTH = 1;
        UI.setLineWidth(BULBWIDTH);
        UI.setColor(Color.yellow);
        UI.fillOval(left, top, lampSize, lampSize);
        
        // What color the bulb is
        this.colorBlack = false;
    }
    public void turnOff() {
        // draw the lolly
        final int BULBWIDTH = 1;
        UI.setLineWidth(BULBWIDTH);
        UI.setColor(Color.black);
        UI.fillOval(left, top, lampSize, lampSize);
        
        // What color the bulb is
        this.colorBlack = true;
    }
    
    /**
     * Change colour to a bright colour
     */
    public void changeColor() {
        // draw the lolly
        final int BULBWIDTH = 1;
        UI.setLineWidth(BULBWIDTH);
        UI.setColor(Color.getHSBColor((float)(Math.random()), 1.0f, 1.0f));
        UI.fillOval(left, top, lampSize, lampSize);
        
        // What color the bulb is
        this.colorBlack = false;
    }
}