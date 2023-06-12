package invaderlib;

public class Player extends Sprite{
    public boolean direction;
    private long lastShotTime;
    private final long shootingDelay = 1000; // 1 second delay in milliseconds
    Player(float newX, float newY, Window newWindow){
        super(newX, newY,newWindow);
        alive1 = pWindow.loadImage("../cannon.png");
        alive1.resize(20,20);
    }
    public void Time(){}
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
    @Override
    public void Paint(){}
    public void Shooting() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastShotTime >= shootingDelay) {
            pWindow.GetDakka().AddShoot(xypos, false);
            lastShotTime = currentTime; // Update last shot time
        }
    }
    public void GettingHit(){}
}
