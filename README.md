# oop_space_invaders
https://app.diagrams.net/#G1at3EE6l8RtWnfuNxM5wd7_AaHinR6BgA

Health:
-int health
+void Losehealth()

Score:
-int score
+void Addpoints()
+void DisplayScore()

XYpos:
-double x
-double y

Window:
-int speed
-Score score
-Health health
-Array(Sprite) Enemy
+bool WinCheck()


ScoreTable:
-Window pWindow
-Array(Sprite) table
+void Start()

Sprite:
-Window pWindow
-XYpos xypos
-XYpos sprite_position
+void Time()
+void Death()
+void Movement()

Player extends Sprite:
+void Shooting()
+void Gettinghit()

Alien extends Sprite:
+void Shooting()
+bool LoseCheck()

Shoot extends Sprite:
+void CollisionCheck()


//not for now
Cover extends Sprite:
+void Destruction()



