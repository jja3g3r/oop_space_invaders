package invaderlib;

public class Navy {
    public Alien[] ships;
    Navy(){
        this.Setships();
    }
    private Navy Setships(){
        this.ships = new Alien[55];
        int y = 0;
        for(int i = 0; i < 55; i++){
            if(i % 11 == 0){
                y++;
            }
            ships[i] = new Alien((i%11)*16,10*y,10,10);
        }
        return this;
    }
    public void NavalManouvre(){
        boolean advance = false;
        for(int i = 0; i < 55; i++){
            if(ships[i].GetXYpos().GetX() + 16 >= 400){
                ships[i].direction = false;
                advance = true;
            }else if(ships[i].GetXYpos().GetX() <= 0) {
                ships[i].direction = true;
                advance = true;
            }
        }
        for(int i = 0; i < 55; i++){
            if(advance == true){
                ships[i].GetXYpos().SetY(ships[i].GetXYpos().GetY() + 10);
            }
            ships[i].Movement();

        }
    }
}
