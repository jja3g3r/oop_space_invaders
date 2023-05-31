package invaderlib;

public class Alien extends Sprite{
    Alien(XYpos newXYpos, XYpos newSpritePos){
        super(newXYpos, newSpritePos);
    }
    public void Shoot(){}
    @Override
    public void Death(){}
    @Override
    public void Movement(){}
    public boolean LoseCheck(){return false;}
}
