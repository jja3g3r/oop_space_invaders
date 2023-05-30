package invaderlib;

public class Game {
    private Score score;
    private Health health;
    //private Array(spritelib.Sprite) Enemies;
    Game(Score newScore, Health newHealth){
        this.SetScore(newScore).SetHealth(newHealth);
    }
    public void Start(){}
    private Game SetScore(Score newScore){
        this.score = newScore;
        return this;
    }
    private Game SetHealth(Health newHealth){
        this.health = newHealth;
        return this;
    }
}
