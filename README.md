# oop_space_invaders
All der Code, außer Main.java, ist meines Wissens im Pfad
oop_space_invaders/game/src/invaderlib

Die Bilder die Benutzt werden sind in
oop_space_invaders/game/src/pngs

Sprite:
-Window pWindow
-XYpos xypos
+PImage alive1, alive2, deadp, ammo1, ammo2, ammo3, ammo4
+Time()
+Death()
+Movement()
+Paint()

Alien extends Sprite:
-Alien neighboor
+static boolean direction
-boolean dead, bottom
-int tick, type
+float movementSpeed
+Shooting()

Cover extends Sprite:
-XYpos[][] collisionMapV3

Player extends Sprite:
+boolean direction
-long lastShotTime
-final long shootingDelay
+Shooting()

Shoot extends Sprite:
-boolean updown
-int tick

UFO extends Alien:

SpriteTable:
-Window pWindow
-Vector<Sprite> table

Navy extends SpriteTable:
-float basespeed
-Setships()
+getDeadAlienCount()
+NavalManouvre()

Fortress extends SpriteTable:
-SetCovers()

DAKKA extends SpriteTable:
+AddShoot()

CollisionControl:
+static Collisionthing()

XYpos:
-float x, y

Window extends PApplet:
-int width, height
-Navy navy
-DAKKA dakka
-Player player
-Fortress fortress
-int currentsScore
+int level
+Death()
-resetGame()



