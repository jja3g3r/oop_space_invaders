package invaderlib;
import processing.core.PImage;

public class Sprite {
    protected Window pWindow;
    protected XYpos xypos, sprite_position;
    public PImage placeholder;
    Sprite(){}
    Sprite(float newX, float newY, float newSX, float newSY, Window newWindow){
        SetXYpos(newX, newY).SetSpritePos(newX, newY).SetpWindow(newWindow);
        placeholder = pWindow.loadImage("../jojo.png");
    }
    Sprite(float newX, float newY, float newSX, float newSY){
        SetXYpos(newX, newY).SetSpritePos(newX, newY);
        placeholder = pWindow.loadImage("../Placeholder.png");
    }
    public void Time(){}
    public void Death(){}
    public void Movement(){}
    private Sprite SetXYpos(float newX, float newY){this.xypos = new XYpos(newX,newY); return this;}
    private Sprite SetSpritePos(float newX, float newY){this.sprite_position = new XYpos(newX, newY); return this;}
    private Sprite SetpWindow(Window newWindow){
        this.pWindow = newWindow;
        return this;
    }
    public XYpos GetXYpos(){return this.xypos;}
}
