package invaderlib;

public class XYpos {
    private float x,y;
    XYpos(float newX, float newY){
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
