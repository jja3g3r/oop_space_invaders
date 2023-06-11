package invaderlib;

import java.util.Vector;

public class DAKKA extends SpriteTable{
    DAKKA(Window newWindow){
        super(newWindow);
        SetTable();
    }
    public void AddShoot(XYpos xypos, boolean updown){
        table.add(new Shoot(xypos,xypos,updown,pWindow));
    }
    private DAKKA SetTable(){
        table = new Vector<>();
        return this;
    }
}
