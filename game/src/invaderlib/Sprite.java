package invaderlib;

public class Sprite {
    private Window pWindow;
    private XYpos xypos, sprite_position;
    Sprite(){}
    Sprite(XYpos newXYpos, XYpos newSpritePos){
        this.SetXYpos(newXYpos).SetSpritePos(newSpritePos);
    }
    public void Time(){}
    public void Death(){}
    public void Movement(){}
    private Sprite SetXYpos(XYpos newXYpos){this.xypos = newXYpos; return this;}
    private Sprite SetSpritePos(XYpos newSpritePos){this.sprite_position = newSpritePos; return this;}
}
