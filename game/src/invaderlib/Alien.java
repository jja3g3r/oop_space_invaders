package invaderlib;

import java.util.Random;

/**
 * Represents an alien sprite in the game.
 */
public class Alien extends Sprite {
    private Alien neighboor;
    public static boolean direction;
    private boolean dead, bottom;
    private int tick, type;

    /**
     * Constructs an Alien object.
     *
     * @param newX      The initial X position of the alien.
     * @param newY      The initial Y position of the alien.
     * @param newWindow The Window object representing the game window.
     * @param newType   The type of the alien.
     * @param newNeighboor The neighboring alien.
     * @param newBottom Determines if the alien is at the bottom row.
     */
    Alien(float newX, float newY, Window newWindow, int newType, Alien newNeighboor, boolean newBottom) {
        super(newX, newY, newWindow);
        direction = true;
        dead = false;
        tick = 0;
        type = newType;
        neighboor = newNeighboor;
        bottom = newBottom;
        switch (type) {
            case 0:
                alive1 = pWindow.loadImage("../pngs/Alien1a.png");
                alive2 = pWindow.loadImage("../pngs/Alien1b.png");
                break;
            case 1:
                alive1 = pWindow.loadImage("../pngs/Alien2a.png");
                alive2 = pWindow.loadImage("../pngs/Alien2b.png");
                break;
            case 2:
                alive1 = pWindow.loadImage("../pngs/Alien3a.png");
                alive2 = pWindow.loadImage("../pngs/Alien3b.png");
        }
        deadp = pWindow.loadImage("../pngs/Aliendead.png");
        alive1.resize(32, 16);
        alive2.resize(32, 16);
    }

    /**
     * Performs time-related functionality for the alien.
     */
    public void Time() {
        // TODO: Implement time-related functionality for the alien
    }

    @Override
    public void Death() {
        if (bottom) {
            if (null != neighboor) {
                if (!neighboor.dead) {
                    neighboor.bottom = true;
                    bottom = false;
                } else if (null != neighboor.neighboor) {
                    if (!neighboor.neighboor.dead) {
                        neighboor.neighboor.bottom = true;
                        bottom = false;
                    }
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
        // Calculate the updated movement speed
        if (direction) {
            this.xypos.SetX(xypos.GetX() + movementSpeed);
        } else {
            this.xypos.SetX(xypos.GetX() - movementSpeed);
        }
    }

    @Override
    public void Paint() {
        if (tick % 40 < 20) {
            pWindow.image(alive1, xypos.GetX(), xypos.GetY());
        } else {
            pWindow.image(alive2, xypos.GetX(), xypos.GetY());
        }
        tick++;
    }

    /**
     * Initiates shooting action by the alien.
     */
    public void Shooting() {
        if (bottom) {
            Random rand = new Random();
            int n = rand.nextInt(400);
            if (n == 0) {
                pWindow.GetDakka().AddShoot(xypos, true);
            }
        }
    }

    /**
     * Checks if the alien has reached the player's spaceship.
     *
     * @return Returns false as aliens cannot reach the player's spaceship.
     */
    public boolean LoseCheck() {
        return false;
    }

    /**
     * Retrieves the status of the alien's life.
     *
     * @return Returns true if the alien is dead, false otherwise.
     */
    public boolean GetDead() {
        return dead;
    }

    /**
     * Retrieves the status of the alien's position at the bottom row.
     *
     * @return Returns true if the alien is at the bottom row, false otherwise.
     */
    public boolean GetBottom() {
        return bottom;
    }
}
