package invaderlib;

import java.util.Vector;

/**
 * Represents a fleet of alien sprites in the game.
 */
public class Navy extends SpriteTable {
    float basespeed = 1f;

    /**
     * Constructs a Navy object.
     * @param newWindow The Window object representing the game window.
     */
    Navy(Window newWindow) {
        super(newWindow);
        Setships();
    }

    private Navy Setships() {
        table = new Vector<>();
        int a = 0;
        int y = 0;
        for (int i = 0; i < 11; i++) {
            table.add(new Alien(i * 30, 35 * y + 50, 10, 10, pWindow, 0, null, false));
            a++;
        }
        y++;
        for (int i = 0; i < 22; i++) {
            if (i == 11) {
                y++;
            }
            table.add(new Alien((i % 11) * 30, 35 * y + 50, 10, 10, pWindow, 1, (Alien) table.get(a - 11), false));
            a++;
        }
        y++;
        boolean bottom = false;
        for (int i = 0; i < 22; i++) {
            if (i == 11) {
                y++;
                bottom = true;
            }
            table.add(new Alien((i % 11) * 30, 35 * y + 50, 10, 10, pWindow, 2, (Alien) table.get(a - 11), bottom));
            a++;
        }
        return this;
    }

    /**
     * Retrieves the count of dead aliens in the fleet.
     * @return The number of dead aliens.
     */
    public int getDeadAlienCount() {
        int deadCount = 0;
        for (int i = 0; i < table.size(); i++) {
            Alien alien = (Alien) table.get(i);
            if (alien.GetDead()) {
                deadCount++;
            }
        }
        return deadCount;
    }

    /**
     * Performs the naval maneuver by updating the movement and shooting actions of the fleet.
     */
    public void NavalManouvre() {
        int deadAlien = getDeadAlienCount();

        boolean advance = false;
        boolean allAliensDead = true; // Track if all aliens are dead
        for (int i = 0; i < 55; i++) {
            Alien alien = (Alien) table.get(i);
            alien.movementSpeed = basespeed + pWindow.level * 0.03f + deadAlien * 0.005f; // Increases movement speed per dead alien
            if (!alien.GetDead()) {
                allAliensDead = false; // At least one alien is alive

                if (alien.GetXYpos().GetX() + 30 >= pWindow.GetWidth()) {
                    alien.direction = false;
                    advance = true;
                } else if (alien.GetXYpos().GetX() <= 0) {
                    alien.direction = true;
                    advance = true;
                }
            }
        }
        if (allAliensDead) {
            table.clear();
            pWindow.level++; // Clear the existing alien sprites
            Setships(); // Create a new navy
        }

        if (advance) {
            // Increase movement speed of all aliens by 0.05
            for (int i = 0; i < 55; i++) {
                Alien alien = (Alien) table.get(i);
                alien.GetXYpos().SetY(alien.GetXYpos().GetY() + 10);
            }
        }

        for (int i = 0; i < 55; i++) {
            Alien alien = (Alien) table.get(i);
            alien.Movement();
            alien.Shooting();
        }
    }

}