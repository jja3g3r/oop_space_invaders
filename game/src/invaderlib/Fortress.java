package invaderlib;

import java.util.Vector;

public class Fortress extends SpriteTable {
    Fortress(Window newWindow){
        super(newWindow);
        this.SetCovers();
    }
    private Fortress SetCovers(){
        table = new Vector<>();
        table.add(new Cover(100-24,500,pWindow));
        table.add(new Cover(200-24,500,pWindow));
        table.add(new Cover(300-24,500,pWindow));
        table.add(new Cover(400-24,500,pWindow));
        return this;
    }
}
