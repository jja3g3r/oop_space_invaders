package invaderlib;

public class Shoot extends Sprite{
    public Shoot(XYpos xypos, XYpos sxypos, boolean newUPDOWN,Window pWindow){
        super(xypos.GetX(), xypos.GetY(), sxypos.GetX(), sxypos.GetY(), pWindow);
        updown = newUPDOWN;
    }
    private boolean updown;
    public void CollisionCheck(){}
    @Override
    public void Movement(){
        if(updown == true){
            this.xypos.SetY(xypos.GetY() + 1);
        }else if(updown == false){
            this.xypos.SetY(xypos.GetY() - 1);
        }
    }
    @Override
    public void Death(){
        xypos.SetX(20000);
        xypos.SetY(20000);
    }
}
