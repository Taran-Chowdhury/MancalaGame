package View;

import Model.DataModel;
import StoneDisplay.StoneShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

/**
 * @Author Andrew Townsend
 * @Author Taran Chowdhury
 * 
 * this is a custom button class held by the Format frame
 * it serves the purpose of Displaying the two different concrete format styles that the player can pick for the mancala board
 * the buttons are only set to be active when the Format Frame is visible
 * this is accomplished by using accessor functions to check flags in data model
 */
public class FormatButton extends JButton {

    private Formatter format;
    private DataModel myModel;

    private static final int width = 200;
    private static final int height = 200;

    /**
     * Initializes the FormaButton.
     * 
     * @param f concrete format for the format style
     * @param dm data model object
     */
    public FormatButton(Formatter f, DataModel dm){
        format = f; myModel = dm;

        this.setPreferredSize(new Dimension(width,height));
        this.setIcon(new FormatButton.FormatIcon(width,height,format));
        this.addActionListener(new FormatButtonListener());
    }

    /**
     * Inner class to display the Icon of the format button
     * 
     * implements the icon interface 
     */
    private class FormatIcon implements Icon {

        private Formatter myFormat;
        private int width;
        private int height;

        /**
         * Initializes the format icon
         * 
         * @param w Width of the FormatIcon
         * @param h Height of the FormatIcon
         * @param f The concrete Format for FormatButton Icon
         */
        public FormatIcon(int w, int h, Formatter f){
            width = w; height = h; myFormat = f;
        }

        /**
         * accessor for the concrete format represented by this FormatButton.
         * 
         * @return myFormat the concrete Format
         */
        public Formatter getMyFormat(){
            return myFormat;
        }

        /**
         *  Draws the icon for the format button according to the format that is represented by the FormatButton
         * 
         * @param c the component object
         * @param g the graphics component
         * @param x the x-coordinate of the icon
         * @param y the y-coordinate of the icon
         */
        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2 = (Graphics2D) g;
            Rectangle2D.Double background = new Rectangle2D.Double(0,0,width,height);
            g2.setColor(myFormat.getColor());
            g2.fill(background);
            g2.setColor(Color.BLACK);

            int tempX = width/2 - myFormat.getStoneWidth()/2;
            int tempY = height/2 - myFormat.getStoneWidth()/2;
            StoneShape tempStone = myFormat.getShape().cloneAt(tempX,tempY);

            tempStone.fill(g2);
            g2.setColor(Color.RED);
            tempStone.draw(g2);
            g2.setColor(Color.BLACK);
        }

        /**
         * Accessor for icon width of FormatButton.
         * 
         * @return width the width of the Icon
         */
        @Override
        public int getIconWidth() {
            return width;
        }

        /**
         * Accessor for icon height of FormatButton.
         * 
         * @return width the height of the Icon
         */
        @Override
        public int getIconHeight() {
            return height;
        }
    }

    /**
     * Inner class that create actionListener for the FormatButton.
     */
    private class FormatButtonListener implements ActionListener{

        /**
         * esets the format style of the mancala board according to the selected format and
         * makes the setNumStonesFrame visible
         * 
         * @param e the event that triggers this action listener.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            myModel.setSelectedFormat(FormatButton.this.format);
            myModel.startTurn(1);
            myModel.setStoneNumFrameVisible(true);
            myModel.setFormatFrameClosed(true);
        }
    }
}
