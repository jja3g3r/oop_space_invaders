package invaderlib;

/**
 * Represents the player sprite in the game.
 */
public class Player extends Sprite {
    public boolean direction;
    private long lastShotTime;
    private final long shootingDelay = 1000; // 1 second delay in milliseconds
    Player(float newX, float newY, Window newWindow){
        super(newX, newY,newWindow);
        alive1 = pWindow.loadImage("../pngs/gun.png");
        alive1.resize(32,16);
    }

    public void Time() {
    }

    @Override
    public void Death() {
    }
    /**
     * Updates the movement of the player based on the direction.
     * If the direction is true and the player's x-coordinate is within the game window's width minus 17,
     * the player moves to the right by 3 units.
     * If the direction is false and the player's x-coordinate is greater than or equal to 0,
     * the player moves to the left by 3 units.
     */
    @Override
    public void Movement() {
        if (direction == true && xypos.GetX() <= pWindow.GetWidth() - 17) {
            this.xypos.SetX(xypos.GetX() + 3);
        } else if (direction == false && xypos.GetX() >= 0) {
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

    public void GettingHit() {
    }
}