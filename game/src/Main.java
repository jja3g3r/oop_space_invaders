import processing.core.PApplet;

public class Main extends PApplet
{
    public static void main( String[] args )
    {
        // start the processing-application
        PApplet.main( Main.class );
    }

    /**
     * settings
     * sets the window-size
     */

    @Override
    public void settings()
    {
        setSize( 800, 600 );
    }

    @Override
    public void setup()
    {
        super.setup();
    }

    @Override
    public void draw()
    {
        background( 255 );
    }
}