import processing.core.PApplet;
import processing.core.PImage;
import spritelib.Point;
import spritelib.SingleSprite;
/*
public class Main {
    public static void main(String[] args){PApplet.main("invaderlib.Window");}
}
*/


    public class Main extends PApplet
    {
        PImage ballImage;
        SingleSprite aSingleSprite;
        Point drawpoint = new Point( 100, 100 );
        public static void main( String[] args )
        {
            PApplet.main( Main.class );
        }
        @Override
        public void settings()
        {
            setSize( 800, 600 );
        }
        @Override
        public void setup()
        {
            super.setup();
            ballImage = loadImage( "ball.png" );
            aSingleSprite = new SingleSprite( ballImage );
        }
        @Override
        public void draw()
        {
            background( 255 );
            aSingleSprite.draw( this, drawpoint );
        }
    }
