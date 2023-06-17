package invaderlib;

/**
 * Controls the collision detection between Navy, DAKKA, and Player objects.
 */
public class CollisionControl {
    /**
     * Detects and handles collisions between Navy, DAKKA, and Player objects.
     *
     * @param navy     The Navy object representing the fleet of aliens.
     * @param dakka    The DAKKA object representing the collection of shots.
     * @param player   The Player object representing the player's spaceship.
     * @param fortress The Fortress object representing the cover.
     * @return Returns true if an alien is removed due to collision, false otherwise.
     */
    public static boolean Collisionthing(Navy navy, DAKKA dakka, Player player, Fortress fortress) {
        boolean alienRemoved = false;  // Flag to track if an alien is removed

        for (int i = dakka.table.size() - 1; i >= 0; i--) {
            Shoot d = (Shoot) dakka.table.get(i);

            // Check for collisions between shots and aliens
            if(!d.GetUPDOWN()){
                for (int j = navy.table.size() - 1; j >= 0; j--) {
                    Alien a = (Alien) navy.table.get(j);
                    if (d.xypos.GetY() <= a.xypos.GetY() + 16 && d.xypos.GetY() >= a.xypos.GetY() &&
                            d.xypos.GetX() <= a.xypos.GetX() + 24 && d.xypos.GetX() >= a.xypos.GetX() + 8) {
                        a.Death();
                        d.Death();
                        alienRemoved = true;
                    }
                }
            }

            // Check for collisions between shots and cover blocks
            for (int j = 0; j < 4; j++) {
                Cover c = (Cover) fortress.table.get(j);
                for (int x = 0; x < 48; x++) {
                    for (int y = 0; y < 32; y++) {
                        if ((int) d.xypos.GetX() == (int)  c.GetCollisionMap()[x][y].GetX() &&
                                (int) d.xypos.GetY() == (int) c.GetCollisionMap()[x][y].GetY()) {
                            c.Death(x, y);
                            d.Death();
                        }
                    }
                }
            }

            // Check for collisions between shots and the player's spaceship
            if(d.GetUPDOWN()){
                if (d.xypos.GetY() <= player.xypos.GetY() + 16 && d.xypos.GetY() >= player.xypos.GetY() &&
                        d.xypos.GetX() <= player.xypos.GetX() + 31 && d.xypos.GetX() >= player.xypos.GetX() + 1) {
                    player.Death();
                    d.Death();
                    alienRemoved = true;
                }
            }

        }

        return alienRemoved;  // Return the flag indicating if an alien is removed
    }
}
