package invaderlib;

public class CollisionControl {
    public static boolean Collisionthing(Navy navy, DAKKA dakka, Player player){
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
