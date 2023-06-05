package invaderlib;

public class CollisionControl {
    public static void Collisionthing(Navy navy, DAKKA dakka, Player player){
        for(Sprite a : navy.table){
            for(Sprite d : dakka.table){
                if(d.xypos.GetY() <= a.xypos.GetY() + 20 && d.xypos.GetY() >= a.xypos.GetY() && d.xypos.GetX() <= a.xypos.GetX()+20 && d.xypos.GetX() >= a.xypos.GetX()){
                    a.Death();
                    d.Death();
                }
            }
        }
    }
}
