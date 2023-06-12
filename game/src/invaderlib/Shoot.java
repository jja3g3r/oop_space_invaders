package invaderlib;

import java.util.Random;

/**
 * Represents a shoot in the game.
 */
public class Shoot extends Sprite {
    private boolean updown;
    private int tick;
    public Shoot(float xPos, float yPos, boolean newUPDOWN,Window pWindow){
        super(xPos, yPos, pWindow);
        updown = newUPDOWN;
        tick = 1;
        if (updown) {
            Random rand = new Random();
            int r = rand.nextInt(3);
            switch (r) {
                case 0:
                    ammo1 = pWindow.loadImage("../pngs/ammo1a.png");
                    ammo2 = pWindow.loadImage("../pngs/ammo1b.png");
                    ammo3 = pWindow.loadImage("../pngs/ammo1c.png");
                    ammo4 = pWindow.loadImage("../pngs/ammo1d.png");
                    break;
                case 1:
                    ammo1 = pWindow.loadImage("../pngs/ammo2a.png");
                    ammo2 = pWindow.loadImage("../pngs/ammo2b.png");
                    ammo3 = pWindow.loadImage("../pngs/ammo2c.png");
                    ammo4 = pWindow.loadImage("../pngs/ammo2d.png");
                    break;
                case 2:
                    ammo1 = pWindow.loadImage("../pngs/ammo3a.png");
                    ammo2 = pWindow.loadImage("../pngs/ammo3b.png");
                    ammo3 = pWindow.loadImage("../pngs/ammo3c.png");
                    ammo4 = pWindow.loadImage("../pngs/ammo3d.png");
                    break;
            }
            deadp = pWindow.loadImage("../pngs/ammodead.png");
            ammo1.resize(6,16);
            ammo2.resize(6,16);
            ammo3.resize(6,16);
            ammo4.resize(6,16);
        }else{
            ammo1 = pWindow.loadImage("../pngs/ammop.png");
            ammo1.resize(2,16);
            xypos.SetX(xypos.GetX()+16);
        }
    }

    public void Time() {}

    @Override
    public void Death() {
        xypos.SetX(20000);
        xypos.SetY(20000);
    }

    @Override
    public void Movement() {
        if (updown) {
            this.xypos.SetY(xypos.GetY() + 5);
        } else if (!updown) {
            this.xypos.SetY(xypos.GetY() - 5);
        }
    }
    @Override
    public void Paint(){
        if(tick % 40 < 10){
            pWindow.image(ammo1, xypos.GetX(), xypos.GetY());
        } else if (tick % 40 < 20) {
            pWindow.image(ammo2, xypos.GetX(), xypos.GetY());
        } else if (tick % 40 < 30) {
            pWindow.image(ammo3, xypos.GetX(), xypos.GetY());
        } else {
            pWindow.image(ammo4, xypos.GetX(), xypos.GetY());
        }
        if (updown) {
            tick++;
        }
    }
}