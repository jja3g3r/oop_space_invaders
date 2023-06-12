package invaderlib;
/**
 * Represents the player sprite in the game.
 */
public class Player extends Sprite {
    public boolean direction;
    private long lastShotTime;
    private final long shootingDelay = 1000; // 1 second delay in milliseconds

    /**
     * Constructs a Player object.
     * @param newX The initial x-coordinate of the player.
     * @param newY The initial y-coordinate of the player.
     * @param newSX The width of the player.
     * @param newSY The height of the player.
     * @param newWindow The Window object representing the game window.
     */
    Player(float newX, float newY, float newSX, float newSY, Window newWindow) {
        super(newX, newY, newSX, newSY, newWindow);
        alive1 = pWindow.loadImage("../cannon.png");
        alive1.resize(20, 20);
    }

    public void Time() {
    }

    @Override
    public void Death() {
        pWindow.Death();
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

    public void Paint() {
    }

    /**
     * Handles shooting action of the player.
     */
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