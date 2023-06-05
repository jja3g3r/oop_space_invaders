package invaderlib;

import processing.core.PApplet;
public class Window extends PApplet {
    private Score score;
    private Health health;
    private int speed, width = 400, height = 600;
    private Navy navy;
    private Player player;
    private boolean WinCheck(){
        return false;
    }
    @Override
    public void setup(){
        navy = new Navy(this);
        for(int i = 0; i < 55; i++){
            navy.ships[i].placeholder = loadImage("../Placeholder.png");
        }
        player = new Player(200,550,10,10,this);
        player.placeholder = loadImage("../Placeholder.png");
    }
    @Override
    public void settings(){
        setSize(width,height);
    }
    @Override
    public void keyPressed(){
        if(key == 'd'){
            player.direction = true;
            player.Movement();
        }else if(key == 'a'){
            player.direction = false;
            player.Movement();
        }
    }
    @Override
    public void draw(){
        background(0);
        navy.NavalManouvre();
        for(int i = 0; i < 55; i++){
            image(navy.ships[i].placeholder, navy.ships[i].GetXYpos().GetX(), navy.ships[i].GetXYpos().GetY());
        }
        image(player.placeholder,player.GetXYpos().GetX(),player.GetXYpos().GetY());
    }
    public int GetWidth(){return this.width;}
    public int GetHeight(){return this.height;}
}
