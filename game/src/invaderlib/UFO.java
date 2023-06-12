package invaderlib;

import java.util.Random;

/**
 * Represents a UFO sprite in the game.
 */
public class UFO extends Alien {
    /**
     * Constructs an Alien object.
     *
     * @param newX         The initial X position of the alien.
     * @param newY         The initial Y position of the alien.
     * @param newWindow    The Window object representing the game window.
     * @param newType      The type of the alien.
     * @param newNeighboor The neighboring alien.
     * @param newBottom    Determines if the alien is at the bottom row.
     */
    UFO(float newX, float newY, Window newWindow, int newType, Alien newNeighboor, boolean newBottom) {
        super(newX, newY, newWindow, newType, newNeighboor, newBottom);
    }

    /**
     * Constructs a UFO object.
     * @param newX The initial X position of the UFO.
     * @param newY The initial Y position of the UFO.
     * @param newSX The width of the UFO sprite.
     * @param newSY The height of the UFO sprite.
     * @param newWindow The Window object representing the game window.
     * @param newType The type of the UFO.
     * @param newNeighboor The neighboring UFO.
     * @param newBottom Determines if the UFO is at the bottom row.
     */


    @Override
    public void Paint() {

        alive1 = pWindow.loadImage("../pngs/Ufo.png");
        alive1.resize(60,25);
        pWindow.image(alive1, xypos.GetX(), xypos.GetY());
    }


    @Override
    public void Shooting() {

    }
}