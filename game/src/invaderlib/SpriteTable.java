package invaderlib;

import java.util.Vector;

/**
 * Represents a table of sprites in the game.
 */
public abstract class SpriteTable {
    protected Window pWindow;
    protected Vector<Sprite> table;

    /**
     * Initializes a new instance of the SpriteTable class.
     * @param newWindow The window associated with the sprite table.
     */
    SpriteTable(Window newWindow) {
        SetWindow(newWindow);
    }

    /**
     * Sets the window associated with the sprite table.
     * @param newWindow The new window.
     * @return The updated SpriteTable object.
     */
    private SpriteTable SetWindow(Window newWindow) {
        this.pWindow = newWindow;
        return this;
    }
}