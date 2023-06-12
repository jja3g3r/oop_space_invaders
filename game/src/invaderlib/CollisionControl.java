package invaderlib;

/**
 * Controls the collision detection between Navy, DAKKA, and Player objects.
 */
public class CollisionControl {

    /**
     * Detects and handles collisions between Navy, DAKKA, and Player objects.
     * @param navy The Navy object representing the fleet of aliens.
     * @param dakka The DAKKA object representing the collection of shoots.
     * @param player The Player object representing the player's spaceship.
     * @return Returns true if an alien is removed due to collision, false otherwise.
     */
    public static boolean Collisionthing(Navy navy, DAKKA dakka, Player player) {
        boolean alienRemoved = false;  // Flag to track if an alien is removed

        for (int i = navy.table.size() - 1; i >= 0; i--) {
            Sprite a = navy.table.get(i);

            for (int j = dakka.table.size() - 1; j >= 0; j--) {
                Sprite d = dakka.table.get(j);

                if (d.xypos.GetY() <= a.xypos.GetY() + 20 && d.xypos.GetY() >= a.xypos.GetY() &&
                        d.xypos.GetX() <= a.xypos.GetX() + 20 && d.xypos.GetX() >= a.xypos.GetX()) {
                    a.Death();
                    d.Death();
                    alienRemoved = true;  // Set the flag to true when an alien is removed
                }
            }
        }

        return alienRemoved;  // Return the flag indicating if an alien is removed
    }
}
