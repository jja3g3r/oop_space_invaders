package invaderlib;

public class Health {
    private int health;
    Health(int newHealth){this.SetHealth(newHealth);}
    public void Losehealth(){}
    private Health SetHealth(int newHealth){this.health = newHealth; return this;}
}
