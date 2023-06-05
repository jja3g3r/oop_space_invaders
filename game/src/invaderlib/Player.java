package invaderlib;

public class Player extends Sprite{
    public boolean direction;
    Player(float newX, float newY, float newSX, float newSY, Window newWindow){
        super(newX, newY, newSX, newSY,newWindow);
    }
    public void Shooting(Window window){
        window.GetDakka().AddShoot(xypos,false);
    }
    public void GettingHit(){}
    @Override
    public void Death(){}
    @Override
    public void Movement(){
        if(direction == true && xypos.GetX() <= pWindow.GetWidth()-17 ){
            this.xypos.SetX(xypos.GetX() + 3);
        }else if(direction == false && xypos.GetX() >= 0){
            this.xypos.SetX(xypos.GetX() - 3);
        }
    }
}
