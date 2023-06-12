package invaderlib;

import java.util.Vector;

/**
 * Represents a collection of shoots in the game, named after the iconic "DAKKA" from Warhammer 40K.
 * "DAKKA" is an onomatopoeic term in the Warhammer 40K universe that represents the sound of rapid and intense gunfire.
 */
public class DAKKA extends SpriteTable {
    DAKKA(Window newWindow) {
        super(newWindow);
        SetTable();
    }

    /**
     * Adds a shoot to the DAKKA collection.
     * @param xypos The XY position of the shoot.
     * @param updown Determines if the shoot moves up or down.
     */
    public void AddShoot(XYpos xypos, boolean updown) {
        if (updown) {
            table.add(new Shoot(xypos.GetX()+15, xypos.GetY()+21, updown,pWindow));
        } else {
            table.add(new Shoot(xypos.GetX(), xypos.GetY() - 1, updown, pWindow));
        }
    }

    private DAKKA SetTable() {
        table = new Vector<>();
        return this;
    }
}
