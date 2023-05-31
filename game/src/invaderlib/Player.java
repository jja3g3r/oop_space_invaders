package invaderlib;

public class Player extends Sprite{
    Player(XYpos newXYpos, XYpos newSpritePos){
        super(newXYpos, newSpritePos);
    }
    public void Shooting(){}
    public void GettingHit(){}
    @Override
    public void Death(){}
    @Override
    public void Movement(){}
}
