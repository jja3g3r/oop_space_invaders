package invaderlib;

public class Player extends Sprite{
    public boolean direction;
    private long lastShotTime;
    private final long shootingDelay = 1000; // 1 second delay in milliseconds
    Player(float newX, float newY, float newSX, float newSY, Window newWindow){
        super(newX, newY, newSX, newSY,newWindow);
        placeholder = pWindow.loadImage("../cannon.png");
    }
    public void Shooting(Window window) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastShotTime >= shootingDelay) {
            window.GetDakka().AddShoot(xypos, false);
            lastShotTime = currentTime; // Update last shot time
        }
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
