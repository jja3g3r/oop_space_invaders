package invaderlib;

public class Shoot extends Sprite{
    public Shoot(float newX, float newY, float newSX, float newSY, boolean newUPDOWN){
        super();
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
    public void Death(){}
}
