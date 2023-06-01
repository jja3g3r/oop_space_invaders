package invaderlib;

public class Player extends Sprite{
    public boolean direction;
    Player(float newX, float newY, float newSX, float newSY){
        super(newX, newY, newSX, newSY);
    }
    public void Shooting(){}
    public void GettingHit(){}
    @Override
    public void Death(){}
    @Override
    public void Movement(){
        if(direction == true){
            this.xypos.SetX(xypos.GetX() + 1);
        }else if(direction == false){
            this.xypos.SetX(xypos.GetX() - 1);
        }
    }
}
