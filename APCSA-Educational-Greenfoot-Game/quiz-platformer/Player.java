import greenfoot.*;

/**
 * Player - the player character. Applies simple gravity each frame,
 * lands on Platform or AnswerPlatform actors below it, and can jump
 * with the space bar while grounded. Score, lives, and streak are
 * private fields exposed only through getters and dedicated update
 * methods.
 */
public class Player extends Actor
{
    private static final int GRAVITY = 1;
    private static final int MAX_FALL_SPEED = 14;
    private static final int JUMP_VELOCITY = -17;
    private static final int MOVE_SPEED = 4;

    private int velocityY = 0;
    private int score = 0;
    private int lives = 3;
    private int streak = 0;
    private int invulnerableTimer = 0;

    public Player()
    {
        GreenfootImage img = new GreenfootImage("player_idle.png");
        img.scale(40, 46);
        setImage(img);
    }

    public void act()
    {
        if (invulnerableTimer > 0) {
            invulnerableTimer = invulnerableTimer - 1;
        }

        handleMovement();
        applyGravity();

        if (invulnerableTimer == 0) {
            checkHazard();
        }
    }

    private void handleMovement()
    {
        if (Greenfoot.isKeyDown("left")) {
            setLocation(Math.max(20, getX() - MOVE_SPEED), getY());
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(Math.min(getWorld().getWidth() - 20, getX() + MOVE_SPEED), getY());
        }
        if (Greenfoot.isKeyDown("space") && isOnSolidGround()) {
            velocityY = JUMP_VELOCITY;
        }
    }

    private void applyGravity()
    {
        velocityY = Math.min(velocityY + GRAVITY, MAX_FALL_SPEED);

        if (velocityY >= 0) {
            int checkOffset = getImage().getHeight() / 2 + velocityY;

            AnswerPlatform answerPlat = (AnswerPlatform) getOneObjectAtOffset(0, checkOffset, AnswerPlatform.class);
            if (answerPlat != null) {
                landOn(answerPlat);
                answerPlat.onLanded();
                return;
            }

            Platform ground = (Platform) getOneObjectAtOffset(0, checkOffset, Platform.class);
            if (ground != null) {
                landOn(ground);
                return;
            }
        }

        setLocation(getX(), getY() + velocityY);
    }

    private void landOn(Actor platform)
    {
        int myHalfHeight = getImage().getHeight() / 2;
        int platformHalfHeight = platform.getImage().getHeight() / 2;
        setLocation(getX(), platform.getY() - platformHalfHeight - myHalfHeight);
        velocityY = 0;
    }

    private boolean isOnSolidGround()
    {
        int checkOffset = getImage().getHeight() / 2 + 4;
        Actor ground = getOneObjectAtOffset(0, checkOffset, Platform.class);
        Actor answerPlat = getOneObjectAtOffset(0, checkOffset, AnswerPlatform.class);
        return ground != null || answerPlat != null;
    }

    private void checkHazard()
    {
        Hazard hazard = (Hazard) getOneIntersectingObject(Hazard.class);
        if (hazard != null) {
            PlatformerWorld world = (PlatformerWorld) getWorld();
            world.hazardHit();
            invulnerableTimer = 60;
        }
    }

    public void correctHit()
    {
        streak = streak + 1;
        int bonus = 1 + (streak / 3);
        score = score + bonus;
    }

    public void miss()
    {
        streak = 0;
        lives = lives - 1;
    }

    public void reset()
    {
        score = 0;
        lives = 3;
        streak = 0;
        velocityY = 0;
        invulnerableTimer = 0;
    }

    public int getScore()
    {
        return score;
    }

    public int getLives()
    {
        return lives;
    }

    public int getStreak()
    {
        return streak;
    }
}
