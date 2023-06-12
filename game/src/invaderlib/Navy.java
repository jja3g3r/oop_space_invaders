package invaderlib;
import java.util.Vector;

public class Navy extends SpriteTable{
    Navy(Window newWindow){
        super(newWindow);
        Setships();
    }
    private Navy Setships() {
        table = new Vector<>();
        int a = 0;
        int y = 0;
        for(int i = 0; i < 11; i++){
            table.add(new Alien(i * 30, 35 * y + 50, 10,10,pWindow,0, null, false));
            a++;
        }
        y++;
        for(int i = 0; i < 22; i++){
            if(i == 11){y++;}
            table.add(new Alien((i % 11) * 30, 35 * y+ 50, 10,10,pWindow,1, (Alien)table.get(a-11), false));
            a++;
        }
        y++;
        boolean bottom = false;
        for(int i = 0; i < 22; i++){
            if(i == 11){
                y++;
                bottom = true;}
            table.add(new Alien((i % 11) * 30, 35 * y+ 50, 10,10,pWindow,2,(Alien)table.get(a-11), bottom));
            a++;
        }
        return this;
    }
    public void NavalManouvre() {
        boolean advance = false;
        boolean allAliensDead = true; // Track if all aliens are dead
        for (int i = 0; i < 55; i++) {
            Alien alien = (Alien) table.get(i);
            if (!alien.GetDead()) {
                allAliensDead = false; // At least one alien is alive

                if (alien.GetXYpos().GetX() + 30 >= pWindow.GetWidth()) {
                    alien.direction = false;
                    advance = true;
                } else if (alien.GetXYpos().GetX() <= 0) {
                    alien.direction = true;
                    advance = true;
                }
            }
        }
        if (allAliensDead) {
            table.clear(); // Clear the existing alien sprites
            Setships(); // Create a new navy
        }

        if (advance) {
            // Increase movement speed of all aliens by 0.05
            for (int i = 0; i < 55; i++) {
                Alien alien = (Alien) table.get(i);
                alien.movementSpeed += 0.05f;
                alien.GetXYpos().SetY(alien.GetXYpos().GetY() + 10);
            }
        }

        for (int i = 0; i < 55; i++) {
            Alien alien = (Alien) table.get(i);
            alien.Movement();
            alien.Shooting();
        }
    }

}
