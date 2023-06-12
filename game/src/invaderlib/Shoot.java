package invaderlib;


public class Shoot extends Sprite{
    private boolean updown;
    public Shoot(XYpos xypos, XYpos sxypos, boolean newUPDOWN,Window pWindow){
        super(xypos.GetX(), xypos.GetY(), sxypos.GetX(), sxypos.GetY(), pWindow);
        updown = newUPDOWN;
        alive1 = pWindow.loadImage("../shot.png");
        alive1.resize(20,20);
    }
    public void Time(){}
    @Override
    public void Death(){
        xypos.SetX(20000);
        xypos.SetY(20000);
    }
    @Override
    public void Movement(){
        if(updown == true){
            this.xypos.SetY(xypos.GetY() + 1);
        }else if(updown == false){
            this.xypos.SetY(xypos.GetY() - 1);
        }
    }
    public void Paint(){}
}
