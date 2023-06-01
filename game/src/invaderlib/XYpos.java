package invaderlib;

public class XYpos {
    private float x,y;
    XYpos(float newX, float newY){
        this.SetX(newX).SetY(newY);
    }
    public float GetX(){return x;}
    public float GetY(){return y;}
    public XYpos SetX(float newX){this.x = newX; return this;}
    public XYpos SetY(float newY){this.y = newY; return this;}
}
