# oop_space_invaders
https://app.diagrams.net/#G1at3EE6l8RtWnfuNxM5wd7_AaHinR6BgA

Health:
-unsigned int health
+Losehealth()

Score:
-unsigned int score
+Addpoints()

XYpos:
-double x
-double y

Game:
-Score score
-Health health
-Array(sprite) Enemy
+Start()

Sprite:
-XYpos xypos
-XYpos sprite_position
+time()

Player extends Sprite:
-Health health
+Shoot()
+Movement()
+Gettinghit()

Alien extends Sprite:
-Health health
+Shoot()
+Death()
+Move()

Cover extends Sprite:
+Destruction()



