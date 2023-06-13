package invaderlib;

import java.util.Vector;

/**
 * Represents a fleet of alien sprites in the game.
 */
public class Navy extends SpriteTable {
    float basespeed = 1f;

    /**
     * Constructs a Navy object.
     *
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

        // Add a UFO on top of the navy fleet
        table.add(new UFO(5 * 30, 35 * y + 10, pWindow, 0, null, false));

        y++; // Adjust the starting height

        // Add regular aliens to the fleet
        for (int i = 0; i < 11; i++) {
            table.add(new Alien(i * 32, 35 * y + 50, pWindow, 0, null, false));
            a++;
        }
        y++;
        for (int i = 0; i < 22; i++) {
            if (i == 11) {
                y++;
            }
            table.add(new Alien((i % 11) * 32, 35 * y + 50, pWindow, 1, (Alien) table.get(a - 11), false));
            a++;
        }
        y++;
        boolean bottom = false;
        for (int i = 0; i < 22; i++) {
            if (i == 11) {
                y++;
                bottom = true;
            }
            table.add(new Alien((i % 11) * 32, 35 * y + 50, pWindow, 2, (Alien) table.get(a - 11), bottom));
            a++;
        }

        // Add the missing alien in the bottom right position
        //table.add(new Alien(11 * 30, 35 * y + 50, 10, 10, pWindow, 2, (Alien) table.get(a - 11), true));

        return this;
    }

    /**
     * Retrieves the count of dead aliens in the navy fleet.
     *
     * @return The count of dead aliens.
     */
    public int getDeadAlienCount() {
        int deadCount = 0;
        for (int i = 0; i < table.size(); i++) {
            Sprite sprite = table.get(i);
            if (sprite instanceof Alien) {
                Alien alien = (Alien) sprite;
                if (alien.GetDead()) {
                    deadCount++;
                }
            }
        }
        return deadCount;
    }

    /**
     * Executes the naval maneuver logic for the navy fleet.
     */
    public void NavalManouvre() {
        int deadAlien = getDeadAlienCount();

        boolean advance = false;
        boolean allAliensDead = true;

        // Adjust the loop limit to iterate over the entire vector
        for (int i = 0; i < table.size(); i++) {
            Sprite sprite = table.get(i);
            if (sprite instanceof Alien) {
                Alien alien = (Alien) sprite;
                alien.movementSpeed = basespeed + pWindow.level * 0.03f + deadAlien * 0.005f;

                if (!alien.GetDead()) {
                    allAliensDead = false;

                    if (alien.GetXYpos().GetX() + 30 >= pWindow.GetWidth()) {
                        alien.direction = false;
                        advance = true;
                    } else if (alien.GetXYpos().GetX() <= 0) {
                        alien.direction = true;
                        advance = true;
                    }
                }
            } else if (sprite instanceof UFO) {
                UFO ufo = (UFO) sprite;
                // Update the movement speed of the UFO (if needed)
                // Adjust the movement logic for the UFO

                // ... Rest of the UFO movement logic
            }
        }

        if (allAliensDead) {
            table.clear();
            pWindow.level++;
            Setships();
        }

        if (advance) {
            for (int i = 0; i < table.size(); i++) {
                Sprite sprite = table.get(i);
                if (sprite instanceof Alien) {
                    Alien alien = (Alien) sprite;
                    alien.GetXYpos().SetY(alien.GetXYpos().GetY() + 10);
                }
            }
        }

        for (int i = 0; i < table.size(); i++) {
            Sprite sprite = table.get(i);
            if (sprite instanceof Alien) {
                Alien alien = (Alien) sprite;
                alien.Movement();
                alien.Shooting();
            }
        }
    }
}
