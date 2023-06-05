package invaderlib;

public class Alien extends Sprite{
    public static boolean direction;
    Alien(float newX, float newY, float newSX, float newSY, Window newWindow){
        super(newX, newY, newSX, newSY, newWindow);
        direction = true;
    }
    public void Shoot(){}
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
    public boolean LoseCheck(){return false;}
}
