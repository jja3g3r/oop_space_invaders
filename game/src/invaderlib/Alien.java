package invaderlib;

public class Alien extends Sprite{
    public static boolean direction;
    private boolean dead;
    Alien(float newX, float newY, float newSX, float newSY, Window newWindow){
        super(newX, newY, newSX, newSY, newWindow);
        direction = true;
        dead = false;
        placeholder = pWindow.loadImage("../blue.png");
    }
    public void Shoot(){}
    @Override
    public void Death(){
        xypos.SetX(20000);
        xypos.SetY(20000);
        dead = true;
    }
    @Override
    public void Movement(){
        if(direction == true){
            this.xypos.SetX(xypos.GetX() + 1);
        }else if(direction == false){
            this.xypos.SetX(xypos.GetX() - 1);
        }

    }
    public boolean LoseCheck(){return false;}
    public boolean GetDead(){return dead;}
}
