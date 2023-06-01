package invaderlib;

public class Player extends Sprite{
    Player(float newX, float newY, float newSX, float newSY){
        super(newX, newY, newSX, newSY);
    }
    public void Shooting(){}
    public void GettingHit(){}
    @Override
    public void Death(){}
    @Override
    public void Movement(){}
}
