package View;

import StoneDisplay.StoneShape;

import java.awt.*;

/**
 * @Author Andrew Townsend
 * @Author Taran Chowdhury
 * 
 * this is a formatter object to be held by the Board Icon class and used by the board Icon class to
 * determine the likeness of the board
 */
public class Formatter {
    private Color formatColor;
    private StoneShape formatShape;
    private int stoneWidth;

    /**
     * 
     * @param c the color for the format
     * @param s the stone shape for the format
     * @param w the width of the stone shape
     */
    public Formatter(Color c, StoneShape s,int w){
        this.formatColor = c; this.formatShape = s; stoneWidth = w;
    }

    /**
     * mutator for the color of the format
     * 
     * @param c the color for the concrete format
     */
    public void setColor(Color c){ formatColor = c; }

    /**
     * mutator for the shape of the stone for the format
     * 
     * @param s the shape of the stone
     */
    public void setFormatShape(StoneShape s){ formatShape = s; }

    /**
     * mutator for the width of the stone shape
     * 
     * @param w width of the stone shape.
     */
    public void setStoneWidth(int w){ stoneWidth = w; }

    /**
     * Accessor for the format color.
     * 
     * @return formatColor the color of the format
     */
    public Color getColor(){ return formatColor; }

    /**
     * accessor for the stone shape of the format
     * 
     * @return formatShape the stone shape of the format
     */
    public StoneShape getShape(){ return formatShape; }

    /**
     * accessor for the stone shape width
     * 
     * @return stoneWidth the width of the stone shape
     */
    public int getStoneWidth(){ return stoneWidth; }

}