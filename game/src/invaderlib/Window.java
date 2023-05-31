package invaderlib;

import processing.core.PApplet;
public class Window extends PApplet {
    private Score score;
    private Health health;
    private int speed;
    private Sprite[] Enemys;
    private boolean WinCheck(){
        return false;
    }
    @Override
    public void settings(){
        setSize(800,600);
    }
    @Override
    public void draw(){
        background(255);
    }
}
