package invaderlib;
import java.util.Random;

public class Alien extends Sprite{
    private Alien neighboor;
    public static boolean direction;
    private boolean dead, bottom;
    private int tick,type;
    Alien(float newX, float newY, float newSX, float newSY, Window newWindow,int newType, Alien newNeighboor, boolean newBottom){
        super(newX, newY, newSX, newSY, newWindow);
        direction = true;
        dead = false;
        tick = 0;
        type = newType;
        neighboor = newNeighboor;
        bottom = newBottom;
        switch (type){
            case 0: alive1 = pWindow.loadImage("../pngs/Alien1a.png");
                    alive2 = pWindow.loadImage("../pngs/Alien1b.png");
                    break;
            case 1: alive1 = pWindow.loadImage("../pngs/Alien2a.png");
                    alive2 = pWindow.loadImage("../pngs/Alien2b.png");
                    break;
            case 2: alive1 = pWindow.loadImage("../pngs/Alien3a.png");
                    alive2 = pWindow.loadImage("../pngs/Alien3b.png");
        }
        deadp = pWindow.loadImage("../pngs/Aliendead.png");
        alive1.resize(30,17);
        alive2.resize(30,17);
    }
    public void Time(){}
    @Override
    public void Death(){
        if(bottom){
            if(null != neighboor){
                if(!neighboor.dead){
                    neighboor.bottom = true;
                    bottom = false;
                }else if(!neighboor.neighboor.dead){
                    neighboor.neighboor.bottom = true;
                    bottom = false;
                }
            }
        }
        xypos.SetX(20000);
        xypos.SetY(20000);
        dead = true;
    }
    public float movementSpeed = 1.0f;
    @Override
    public void Movement() {
        ; // Calculate the updated movement speed
        if (direction == true) {
            this.xypos.SetX(xypos.GetX() + movementSpeed);
        } else if (direction == false) {
            this.xypos.SetX(xypos.GetX() - movementSpeed);
        }
    }

    @Override
    public void Paint(){
        if(tick % 40 < 20){
            pWindow.image(alive1, xypos.GetX(), xypos.GetY());
        }else{
            pWindow.image(alive2, xypos.GetX(),xypos.GetY());
        }
        tick++;
    }
    public void Shooting() {
        if(bottom){
            Random rand = new Random();
            int n = rand.nextInt(280);
            if(n == 0){
                pWindow.GetDakka().AddShoot(xypos, true);
            }
        }
    }
    public boolean LoseCheck(){return false;}

    public boolean GetDead(){return dead;}
    public boolean GetBottom(){return bottom;}
}
