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
 * of undoing the current changes made to the stone locations on the mancala board
 * due to the move made by the current player.
 * 
 * The button is only set to be active when the Primary Frame is visible and
 * when one of the players clicks on one of their stone holes.
 * 
 * This is accomplished by using accessor functions to check flags in data model
 */
public class UndoButton extends JButton {
    private DataModel myModel;

    /**
     * initializes the undo button with background color and text
     * 
     * @param myDM the DataModel object
     */
    public UndoButton(DataModel myDM){
        myModel = myDM;
        this.setBackground(Color.LIGHT_GRAY);
        this.setText("Undo");
    }

    /**
	 * checks if the flag is true and initializes and adds the action listener to
	 * the continue button accordingly.
	 * 
	 * @param flag flag for setIsActive.
	 */
    public void setIsActive(boolean flag){
        removeAllActionListeners();
        if(flag){
            this.setBackground(Color.RED);
            this.addActionListener(new UndoButtonListener());
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
	 * Inner class that creates ActionListener for the UndoButton.
	 */
    private class UndoButtonListener implements ActionListener{
        
        /**
		 * calls the undoTurn method in data model when undo button is clicked.
		 * 
		 * @param e the event that triggers this function.
		 */
        @Override
        public void actionPerformed(ActionEvent e) {
            myModel.undoTurn();
        }
    }
}
