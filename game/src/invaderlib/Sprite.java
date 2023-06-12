package invaderlib;
import processing.core.PImage;
import java.util.Vector;
import invaderlib.XYpos;

public abstract class Sprite {
    protected Window pWindow;
    protected XYpos xypos, sprite_position;
    protected Vector<XYpos> collisionMap;
    public PImage alive1, alive2, dead, ammo1, ammo2, ammo3, ammo4;
    Sprite(float newX, float newY, float newSX, float newSY, Window newWindow){
        SetXYpos(newX, newY).SetSpritePos(newX, newY).SetpWindow(newWindow);
    }
    public abstract void Time();
    public abstract void Death();
    public abstract void Movement();
    public abstract void Paint();

    public XYpos GetXYpos(){return this.xypos;}
    public Vector<XYpos> GetCollisionMap(){return this.collisionMap;}

    private Sprite SetXYpos(float newX, float newY){this.xypos = new XYpos(newX,newY); return this;}
    private Sprite SetSpritePos(float newX, float newY){this.sprite_position = new XYpos(newX, newY); return this;}
    private Sprite SetpWindow(Window newWindow){
        this.pWindow = newWindow;
        return this;
    }
}
