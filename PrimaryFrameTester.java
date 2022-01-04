import Model.DataModel;
import StoneDisplay.ConcreteCircle;
import StoneDisplay.ConcreteStar;
import View.Formatter;

import javax.swing.*;
import java.awt.*;

/**
 * this is the tester class used to run the program
 */
public class PrimaryFrameTester {

    /**
     * @Author Andrew Townsend
     * @Author Taran Chowdhury
     * 
     * this is the main method which instantiates formatters, data model, and the three frames used by the project
     * @param args
     */
    public static void main(String[] args){

        DataModel temp = new DataModel();
        Formatter stoneShapeFormatter = new Formatter(Color.BLUE, new ConcreteCircle(30,0,0),30);
        Formatter starShapeFormatter = new Formatter(Color.GREEN, new ConcreteStar(30,0,0),30);
        Formatter defaultFormatter = new Formatter(Color.GRAY,new ConcreteCircle(30,0,0),30);

        PrimaryFrame myPF = new PrimaryFrame(temp,defaultFormatter);
        FormatFrame myFF = new FormatFrame(stoneShapeFormatter,starShapeFormatter,temp);
        StoneNumFrame mySNF = new StoneNumFrame(defaultFormatter, temp);

        temp.attach(myPF);
        temp.attach(myFF);
        temp.attach(mySNF);

    }


}