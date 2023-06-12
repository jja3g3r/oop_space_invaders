package invaderlib;

import java.util.Random;

/**
 * Represents a UFO sprite in the game.
 */
public class UFO extends Alien {
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
    public UFO(float newX, float newY, float newSX, float newSY, Window newWindow, int newType, Alien newNeighboor, boolean newBottom) {
        super(newX, newY, newSX, newSY, newWindow, newType, newNeighboor, newBottom);
    }

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