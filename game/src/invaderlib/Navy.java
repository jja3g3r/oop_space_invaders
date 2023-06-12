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
            table.add(new Alien(i * 32, 35 * y + 50,pWindow,0, null, false));
            a++;
        }
        y++;
        for(int i = 0; i < 22; i++){
            if(i == 11){y++;}
            table.add(new Alien((i % 11) * 32, 35 * y+ 50,pWindow,1, (Alien)table.get(a-11), false));
            a++;
        }
        y++;
        boolean bottom = false;
        for(int i = 0; i < 22; i++){
            if(i == 11){
                y++;
                bottom = true;}
            table.add(new Alien((i % 11) * 32, 35 * y+ 50,pWindow,2,(Alien)table.get(a-11), bottom));
            a++;
        }
        return this;
    }
    public void NavalManouvre() {
        boolean advance = false;
        boolean allAliensDead = true; // Track if all aliens are dead
        for (int i = 0; i < 55; i++) {
            if (((Alien) table.get(i)).GetDead() == false) {
                allAliensDead = false; // At least one alien is alive

                if (table.get(i).GetXYpos().GetX() + 32 >= pWindow.GetWidth()) {
                    ((Alien) table.get(i)).direction = false;
                    advance = true;
                } else if (table.get(i).GetXYpos().GetX() <= 0) {
                    ((Alien) table.get(i)).direction = true;
                    advance = true;
                }
            }
        }
        if (allAliensDead) {
            table.clear(); // Clear the existing alien sprites
            Setships(); // Create a new navy
        }
        for (int i = 0; i < 55; i++) {
            if (advance == true) {
                table.get(i).GetXYpos().SetY(table.get(i).GetXYpos().GetY() + 10);
            }
            table.get(i).Movement();
            ((Alien) table.get(i)).Shooting();
        }
    }
}
