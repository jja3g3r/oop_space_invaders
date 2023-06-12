package invaderlib;

import processing.core.PImage;
import java.util.Vector;
import invaderlib.XYpos;

/**
 * Represents a sprite in the game.
 */
public abstract class Sprite {
    protected Window pWindow;
    protected XYpos xypos, sprite_position;
    protected Vector<XYpos> collisionMap;
    public PImage alive1, alive2, deadp, ammo1, ammo2, ammo3, ammo4;

    /**
     * Initializes a new instance of the Sprite class.
     * @param newX The X coordinate of the sprite.
     * @param newY The Y coordinate of the sprite.
     * @param newSX The X size of the sprite.
     * @param newSY The Y size of the sprite.
     * @param newWindow The window associated with the sprite.
     */
    Sprite(float newX, float newY, float newSX, float newSY, Window newWindow) {
        SetXYpos(newX, newY).SetSpritePos(newX, newY).SetpWindow(newWindow);
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

    /**
     * Gets the XY position of the sprite.
     * @return The XY position of the sprite.
     */
    public final XYpos GetXYpos() {
        return this.xypos;
    }

    /**
     * Gets the collision map of the sprite.
     * @return The collision map of the sprite.
     */
    public final Vector<XYpos> GetCollisionMap() {
        return this.collisionMap;
    }

    private Sprite SetXYpos(float newX, float newY) {
        this.xypos = new XYpos(newX, newY);
        return this;
    }

    private Sprite SetSpritePos(float newX, float newY) {
        this.sprite_position = new XYpos(newX, newY);
        return this;
    }

    private Sprite SetpWindow(Window newWindow) {
        this.pWindow = newWindow;
        return this;
    }
}
