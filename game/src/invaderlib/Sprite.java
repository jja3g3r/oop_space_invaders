package invaderlib;

public class Sprite {
    private XYpos xypos, sprite_position;
    private Health health;
    Sprite(){}
    Sprite(XYpos newXYpos, XYpos newSpritePos, Health health){
        this.SetXYpos(newXYpos).SetSpritePos(newSpritePos);
    }
    public void Time(){}
    private Sprite SetXYpos(XYpos newXYpos){this.xypos = newXYpos; return this;}
    private Sprite SetSpritePos(XYpos newSpritePos){this.sprite_position = newSpritePos; return this;}
    private Sprite SetHealth(Health newHealth){this.health = newHealth; return this;}
}
