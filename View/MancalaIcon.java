package View;

import View.Formatter;

import javax.swing.*;
import java.awt.*;

/**
 * @Author Andrew Townsend
 * @Author Taran Chowdhury
 * 
 * This class create the mancala icon for the mancala section on the mancala board
 */
public class MancalaIcon extends StoneHolder implements Icon{

    private int width;
    private int height;
    private Formatter myFormat;


    /**
     * initializes the Mancal Icon
     * 
     * @param w width of the mancala icon
     * @param h the height of the mancala icon
     * @param f the concrete format
     */
    public MancalaIcon(int w, int h, Formatter f){
        super(0);
        width = w; height = h; myFormat = f;
    }

    /**
     * mutator for the format of MancalaIcon
     * 
     * @param newF The concret format
     */
    public void setMyFormatter(Formatter newF){
        myFormat = newF;
    }

    /**
     * Paint the stones in the boundaries of the icon
     * Icon is the color given in the formatter
     * 
     * @param c the component object
     * @param g the graphics component
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        drawStones(g2,getIconWidth(),getIconHeight(),numStones,myFormat);

    }

    /**
     * accessor for the icon width
     * 
     * @return width the width of the icon
     */
    @Override
    public int getIconWidth() {
        return width;
    }

    /**
     * accessor for the icon height 
     * 
     * @return height the height of the icon
     */
    @Override
    public int getIconHeight() {
        return height;
    }
}