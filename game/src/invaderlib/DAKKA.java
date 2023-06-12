package invaderlib;

import java.util.Vector;

public class DAKKA extends SpriteTable{
    DAKKA(Window newWindow){
        super(newWindow);
        SetTable();
    }
    public void AddShoot(XYpos xypos, boolean updown) {
        if (updown) {
            table.add(new Shoot(xypos.GetX()+15, xypos.GetY()+21, updown,pWindow));
        } else {
            table.add(new Shoot(xypos.GetX(), xypos.GetY()-1, updown, pWindow));
        }
    }
    private DAKKA SetTable(){
        table = new Vector<>();
        return this;
    }
}
