import greenfoot.*;

/**
 * Ship - the player character. Moves left and right with the arrow
 * keys and fires bullets with the space bar. Tracks its own score
 * and lives as private fields, exposed only through getters.
 */
public class Ship extends Actor
{
    private int score = 0;
    private int lives = 3;
    private int shootCooldown = 0;

    public Ship()
    {
        GreenfootImage img = new GreenfootImage(50, 30);
        img.setColor(Color.BLUE);
        img.fillRect(15, 0, 20, 15);
        img.fillRect(0, 15, 50, 15);
        setImage(img);
    }

    public void act()
    {
        if (shootCooldown > 0) {
            shootCooldown = shootCooldown - 1;
        }

        if (Greenfoot.isKeyDown("left")) {
            setLocation(Math.max(25, getX() - 4), getY());
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(Math.min(getWorld().getWidth() - 25, getX() + 4), getY());
        }
        if (Greenfoot.isKeyDown("space") && shootCooldown == 0) {
            shoot();
            shootCooldown = 15;
        }
    }

    private void shoot()
    {
        Bullet bullet = new Bullet();
        getWorld().addObject(bullet, getX(), getY() - 20);
    }

    public void addScore(int amount)
    {
        score = score + amount;
    }

    public void loseLife()
    {
        lives = lives - 1;
    }

    public int getScore()
    {
        return score;
    }

    public int getLives()
    {
        return lives;
    }
}
