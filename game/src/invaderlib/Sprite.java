package invaderlib;

import processing.core.PImage;
import java.util.Vector;
import invaderlib.XYpos;

/**
 * Represents a sprite in the game.
 */
public abstract class Sprite {
    protected Window pWindow;
    protected XYpos xypos;
    public PImage alive1, alive2, deadp, ammo1, ammo2, ammo3, ammo4;
    Sprite(float newX, float newY, Window newWindow){
        SetXYpos(newX, newY).SetpWindow(newWindow);
    }

    /**
     * Called on each frame update to update the sprite's state.
     */
    public abstract void Time();

    /**
     * Handles the logic for the sprite's death.
     */
    public abstract void Death();

    /**
     * Handles the movement of the sprite.
     */
    public abstract void Movement();

    /**
     * Paints the sprite on the screen.
     */
    public abstract void Paint();

    public final XYpos GetXYpos(){return this.xypos;}

    private Sprite SetXYpos(float newX, float newY){this.xypos = new XYpos(newX,newY); return this;}
    private Sprite SetpWindow(Window newWindow){
        this.pWindow = newWindow;
        return this;
    }
}
