import greenfoot.*;

/**
 * Bullet - travels upward from the ship and checks for a collision
 * with an AnswerInvader on every frame.
 */
public class Bullet extends Actor
{
    private int speed = 6;

    public Bullet()
    {
        GreenfootImage img = new GreenfootImage(4, 12);
        img.setColor(Color.YELLOW);
        img.fill();
        setImage(img);
    }

    public void act()
    {
        setLocation(getX(), getY() - speed);
        checkHit();
        if (getY() < 0) {
            getWorld().removeObject(this);
        }
    }

    private void checkHit()
    {
        AnswerInvader invader = getOneIntersectingObject(AnswerInvader.class);
        if (invader != null) {
            invader.handleHit();
            getWorld().removeObject(invader);
            getWorld().removeObject(this);
        }
    }
}
