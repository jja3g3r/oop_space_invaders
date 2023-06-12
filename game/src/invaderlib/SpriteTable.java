package invaderlib;

import java.util.Vector;

public abstract class SpriteTable {
    protected Window pWindow;
    protected Vector<Sprite> table;
    SpriteTable(Window newWindow){SetWindow(newWindow);}
    private SpriteTable SetWindow(Window newWindow){this.pWindow = newWindow; return this;}
}
