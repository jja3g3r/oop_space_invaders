package invaderlib;

import processing.core.PApplet;
public class Window extends PApplet {
    private Score score;
    private Health health;
    private int speed, width = 400, height = 600;
    private Navy navy;
    private DAKKA dakka;
    private Player player;
    private boolean WinCheck(){
        return false;
    }
    @Override
    public void setup(){
        navy = new Navy(this);
        dakka = new DAKKA(this);
        player = new Player(200,550,10,10,this);
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
        }else if(key == 'w'){
            player.Shooting(this);
        }
    }
    @Override
    public void draw(){
        background(0);
        navy.NavalManouvre();
        for(int i = 0; i < 55; i++){
            image(navy.table.get(i).placeholder, navy.table.get(i).GetXYpos().GetX(), navy.table.get(i).GetXYpos().GetY(),20,20);
        }
        for(Sprite x : dakka.table){
            x.Movement();
            image(x.placeholder,x.GetXYpos().GetX(),x.GetXYpos().GetY(),20,20);
        }
        image(player.placeholder,player.GetXYpos().GetX(),player.GetXYpos().GetY(),20,20);

    }
    public int GetWidth(){return this.width;}
    public int GetHeight(){return this.height;}
    public DAKKA GetDakka(){return this.dakka;}
}
