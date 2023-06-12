package invaderlib;

import java.util.Vector;

public class Cover extends Sprite{
    private Vector<XYpos> collisionMap, destroMap;
    Cover(float newX, float newY, Window newWindow){
        super(newX, newY, newWindow);
        alive1 = pWindow.loadImage("../pngs/cover.png");
        alive1.resize(48,32);
        deadp = pWindow.loadImage("../pngs/black.png");
    }
    public void Time(){}
    public void Death(){}
    public void Movement(){}
    public void Paint(){
        pWindow.image(alive1, xypos.GetX(), xypos.GetY());

    }

    public final Vector<XYpos> GetCollisionMap(){return this.collisionMap;}
    public final Vector<XYpos> GetDestroMap(){return this.destroMap;}

}
