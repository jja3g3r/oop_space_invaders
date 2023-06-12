package invaderlib;

import java.util.Vector;

public class Cover extends Sprite{
    private Vector<XYpos> collisionMap, destroMap;
    private Vector<Vector<XYpos>> collisionMapV2;
    private XYpos[][] collisionMapV3;
    Cover(float newX, float newY, Window newWindow){
        super(newX, newY, newWindow);
        this.SetCMap();
        alive1 = pWindow.loadImage("../pngs/cover.png");
        alive1.resize(48,32);
        deadp = pWindow.loadImage("../pngs/black.png");
        deadp.resize(4,4);
    }
    public void Time(){}
    public void Death(){}
    public void Death(final int x, final int y){
        if(collisionMapV3[x][y].GetY() < 1000){
            collisionMapV3[x][y].SetY(collisionMapV3[x][y].GetY() + 2000);
            if(x < 47){
                collisionMapV3[x+1][y].SetY(collisionMapV3[x+1][y].GetY() + 2000);
            }
            if(y < 31){
                collisionMapV3[x][y+1].SetY(collisionMapV3[x][y+1].GetY() + 2000);
            }
            if(x < 47 && y < 31) {
                collisionMapV3[x + 1][y + 1].SetY(collisionMapV3[x+1][y+1].GetY() + 2000);
            }
        }
    }
    public void Movement(){}
    public void Paint(){
        pWindow.image(alive1, xypos.GetX(), xypos.GetY());
        for(int i = 0; i < 48; i++){
            for(int j = 0; j < 32; j++){
                if(collisionMapV3[i][j].GetY() > 1000){
                    pWindow.image(deadp, collisionMapV3[i][j].GetX(),collisionMapV3[i][j].GetY()-2001);
                }
            }
        }
    }

    public final XYpos[][] GetCollisionMap(){return this.collisionMapV3;}
    public final Vector<XYpos> GetDestroMap(){return this.destroMap;}

    private void SetCMap(){
        collisionMapV3 = new XYpos[48][32];
        float x = xypos.GetX();
        float y = xypos.GetY();
        for(int i = 0; i < 48; i++){
            for(int j = 0; j < 32; j++){
                collisionMapV3[i][j] = new XYpos(x + i, y + j);
            }
        }
    }
}
