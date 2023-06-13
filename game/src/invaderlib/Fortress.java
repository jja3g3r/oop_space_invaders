package invaderlib;

import java.util.Vector;

/**
 * Represents the fortress in the game, providing cover for the player.
 */
public class Fortress extends SpriteTable {
    /**
     * Constructs a Fortress object.
     *
     * @param newWindow The Window object representing the game window.
     */
    Fortress(Window newWindow) {
        super(newWindow);
        SetCovers();
    }

    private Fortress SetCovers() {
        table = new Vector<>();
        table.add(new Cover(100 - 24, 500, pWindow));
        table.add(new Cover(200 - 24, 500, pWindow));
        table.add(new Cover(300 - 24, 500, pWindow));
        table.add(new Cover(400 - 24, 500, pWindow));
        return this;
    }
}
