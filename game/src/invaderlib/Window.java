package invaderlib;

import processing.core.PApplet;

public class Window extends PApplet {
    private Score score;
    private Health health;
    private int speed, width = 500, height = 600;
    private Navy navy;
    private DAKKA dakka;
    private Player player;

    private int currentScore = 0;
    public int level = 1;

    public boolean WinCheck() {
        if (navy.getDeadAlienCount() == navy.table.size()) {
            level++;
            System.out.println("Level: " + level);
            return true;
        }
        return false;
    }

    @Override
    public void setup() {
        navy = new Navy(this);
        dakka = new DAKKA(this);
        player = new Player(200, 550, 10, 10, this);

        System.out.println("Level: " + level);
    }

    @Override
    public void settings() {
        setSize(width, height);
    }

    public void keyPressed() {
        if (!looping) {
            if (keyCode == BACKSPACE) {
                resetGame();
                loop(); // Restart the game loop
            }
            return;
        }

        if (key == 'd') {
            player.direction = true;
            player.Movement();
        } else if (key == 'a') {
            player.direction = false;
            player.Movement();
        } else if (key == 'w') {
            player.Shooting();
        } else if (keyCode == BACKSPACE) {
            resetGame();
        }
    }

    @Override
    public void draw() {
        background(0);
        textAlign(LEFT);
        textSize(16);
        fill(255);
        text("Level: " + level, 10, 20);




    // Display the score at the top right corner
        textAlign(RIGHT);
        textSize(16);
        fill(255);
        text("Score: " + currentScore, width - 10, 20);

        navy.NavalManouvre();

        // Draw the navy sprites
        for (int i = 0; i < 55; i++) {
            Alien alien = (Alien) navy.table.get(i);
            if (!alien.GetDead()) {
                alien.Paint();

                // Check if an alien reaches the player
                if (alien.GetXYpos().GetY() >= 540) {
                    // End the game and display the score
                    textAlign(CENTER);
                    textSize(32);
                    fill(255);
                    text("Game Over", width / 2, height / 2);
                    text("Score: " + currentScore, width / 2, height / 2 + 40);
                    text("Press BACKSPACE to restart", width / 2, height / 2 + 80);
                    noLoop(); // Stop the game loop
                }
            }
        }

        // Move and draw the dakka sprites
        for (Sprite x : dakka.table) {
            x.Movement();
            x.Paint();
        }

        // Draw the player sprite
        image(player.alive1, player.GetXYpos().GetX(), player.GetXYpos().GetY());

        // Perform collision control
        boolean alienRemoved = CollisionControl.Collisionthing(navy, dakka, player);

        // If an alien is removed, increment the score by one
        if (alienRemoved) {
            currentScore++;
        }
    }

    public int GetWidth() {
        return this.width;
    }

    public int GetHeight() {
        return this.height;
    }

    public DAKKA GetDakka() {
        return this.dakka;
    }

    private void resetGame() {
        currentScore = 0;
        level = 1;
        // Reset any other necessary game state variables and objects
        navy = new Navy(this);
        dakka = new DAKKA(this);
        player = new Player(200, 550, 10, 10, this);
    }


}
