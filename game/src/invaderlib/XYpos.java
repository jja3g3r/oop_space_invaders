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
    public final float GetX(){return x;}
    public final float GetY(){return y;}
    public XYpos SetX(float newX){this.x = newX; return this;}
    public XYpos SetY(float newY){this.y = newY; return this;}
    public void SetPos(XYpos xypos){
        this.y = xypos.GetY();
        this.x = xypos.GetX();
    }
}
