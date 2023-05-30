# oop_space_invaders
https://app.diagrams.net/#G1at3EE6l8RtWnfuNxM5wd7_AaHinR6BgA

Health:
-int health
+void Losehealth()

Score:
-int score
+void Addpoints()

XYpos:
-double x
-double y

Game:
-Score score
-Health health
-Array(sprite) Enemy
+void Start()

Sprite:
-XYpos xypos
-XYpos sprite_position
-Health health
+void Time()
//todo
+void Movement()

Player extends Sprite:
+void Shoot()
+void Gettinghit()
//todo remove
+void Movement()

Alien extends Sprite:
-Health health
+void Shoot()
+void Death()
//todo remove
+void Move()

Cover extends Sprite:
+void Destruction()



