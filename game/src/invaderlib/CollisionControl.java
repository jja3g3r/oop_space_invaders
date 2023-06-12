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
     * @param fortress The Fortress object representing the cover.
     * @return Returns true if an alien is removed due to collision, false otherwise.
     */
    public static boolean Collisionthing(Navy navy, DAKKA dakka, Player player, Fortress fortress){
        boolean alienRemoved = false;  // Flag to track if an alien is removed

        for(int i = dakka.table.size() - 1; i >= 0; i--){
            Sprite d = dakka.table.get(i);
            for(int j = navy.table.size()-1; j >= 0; j--){
                Sprite a = navy.table.get(j);
                if (d.xypos.GetY() <= a.xypos.GetY() + 16 && d.xypos.GetY() >= a.xypos.GetY() &&
                        d.xypos.GetX() <= a.xypos.GetX() + 24 && d.xypos.GetX() >= a.xypos.GetX()+8) {
                    a.Death();
                    d.Death();
                    alienRemoved = true;
                }
            }
            for(int j = 0; j < 4; j++){
                Sprite c = fortress.table.get(j);
                for(int x = 0; x < 48; x++) {
                    for (int y = 0; y < 32; y++) {
                        if((int)d.xypos.GetX() == (int)((Cover)c).GetCollisionMap()[x][y].GetX() &&
                                (int)d.xypos.GetY() == (int)((Cover)c).GetCollisionMap()[x][y].GetY()){
                            ((Cover) c).Death(x, y);
                            d.Death();
                        }
                    }
                }
            }
            if (d.xypos.GetY() <= player.xypos.GetY() + 16 && d.xypos.GetY() >= player.xypos.GetY() &&
                    d.xypos.GetX() <= player.xypos.GetX() + 31 && d.xypos.GetX() >= player.xypos.GetX()+1) {
                player.Death();
                d.Death();
                alienRemoved = true;
            }
        }

        return alienRemoved;  // Return the flag indicating if an alien is removed
    }
}
