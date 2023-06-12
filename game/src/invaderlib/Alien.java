package invaderlib;

public class Alien extends Sprite{
    public static boolean direction;
    private boolean dead, bottom;
    private int tick,type;
    Alien(float newX, float newY, float newSX, float newSY, Window newWindow,int newType){
        super(newX, newY, newSX, newSY, newWindow);
        direction = true;
        dead = false;
        tick = 0;
        type = newType;
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
    @Override
    public void Paint(){
        if(tick % 40 < 20){
            pWindow.image(alive1, xypos.GetX(), xypos.GetY());
        }else{
            pWindow.image(alive2, xypos.GetX(),xypos.GetY());
        }
        tick++;
    }
    public void Shoot(){}
    public boolean LoseCheck(){return false;}

    public boolean GetDead(){return dead;}
    public boolean GetBottom(){return bottom;}
}
