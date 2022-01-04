package View;

import Model.DataModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author Andrew Townsend
 * @Author Taran Chowdhury
 * 
 * This is a custom button class held by the Primary frame it serves the purpose
 * of Commiting changes to the stone locations on the mancala board.
 * 
 * The button is only set to be active when the
 * Primary Frame is visible and when one of the players clicks on one of their stone holes. T
 * 
 * This is accomplished by using accessor functions to check flags in data model
 */
public class ContinueButton extends JButton {
    private DataModel myModel;

    /**
     * Initializes the continue button by setting its text and its background color.
     * 
     * @param myDM the data model object
     */
    public ContinueButton(DataModel myDM){
        myModel = myDM;
        this.setBackground(Color.LIGHT_GRAY);
        this.setText("Continue");
    }

    /**
     * checks if the flag is true and initializes and adds the action listener 
     * to the continue button accordingly.
     * 
     * @param flag flag for setIsActive.
     */
    public void setIsActive(boolean flag){
        removeAllActionListeners();
        if(flag){
            this.setBackground(Color.GREEN);
            this.addActionListener(new ContinueButtonListener());
        } else {
            this.setBackground(Color.LIGHT_GRAY);
        }
    }

    /**
     * removes all ActionListeners
     */
    private void removeAllActionListeners(){
        ActionListener[] tempArray = this.getActionListeners();
        if(tempArray != null) {
            for (int i = 0; i < tempArray.length; i++) {
                this.removeActionListener(tempArray[i]);
            }
        }
    }

    /**
     * Inner class that creates ActionListener for the continueButton.
     */
    private class ContinueButtonListener implements ActionListener{

        /**
         * calls the continue turn method in data model when continue button is clicked.
         * 
         * @param e the event that triggers this function.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            myModel.continueTurn();
        }
    }
}
