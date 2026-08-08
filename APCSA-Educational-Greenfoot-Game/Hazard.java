import greenfoot.*;

/**
 * Hazard - a simple enemy that patrols back and forth between two
 * x-coordinates. Touching it costs the player a life.
 */
public class Hazard extends Actor
{
    private int minX;
    private int maxX;
    private int speed = 2;
    private int direction = 1;

    public Hazard(int minX, int maxX)
    {
        this.minX = minX;
        this.maxX = maxX;
        GreenfootImage img = new GreenfootImage("hazard.png");
        img.scale(40, 40);
        setImage(img);
    }

    public void act()
    {
        setLocation(getX() + speed * direction, getY());
        if (getX() <= minX || getX() >= maxX) {
            direction = direction * -1;
        }
    }
}
