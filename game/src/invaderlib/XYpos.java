package invaderlib;

/**
 * Represents an XY position in the game.
 */
public class XYpos {
    private float x, y;

    /**
     * Initializes a new instance of the XYpos class.
     * @param newX The X coordinate.
     * @param newY The Y coordinate.
     */
    public XYpos(float newX, float newY) {
        this.SetX(newX).SetY(newY);
    }

    /**
     * Gets the X coordinate.
     * @return The X coordinate.
     */
    public final float GetX() {
        return x;
    }

    /**
     * Gets the Y coordinate.
     * @return The Y coordinate.
     */
    public final float GetY() {
        return y;
    }

    /**
     * Sets the X coordinate.
     * @param newX The new X coordinate.
     * @return The updated XYpos object.
     */
    public XYpos SetX(float newX) {
        this.x = newX;
        return this;
    }

    /**
     * Sets the Y coordinate.
     * @param newY The new Y coordinate.
     * @return The updated XYpos object.
     */
    public XYpos SetY(float newY) {
        this.y = newY;
        return this;
    }
}