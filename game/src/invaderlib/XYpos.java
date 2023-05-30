package invaderlib;

public class XYpos {
    private double x,y;
    XYpos(double newX, double newY){
        this.SetX(newX).SetY(newY);
    }
    public double GetX(){return x;}
    public double GetY(){return y;}
    private XYpos SetX(double newX){this.x = newX; return this;}
    private XYpos SetY(double newY){this.y = newY; return this;}
}
