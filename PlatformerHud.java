import greenfoot.*;

/**
 * PlatformerHud - a slim status bar pinned to the top of the
 * screen, sized to exactly match the world width. Shows score,
 * level, streak, high score, the current question, a shrinking
 * timer bar, and lives drawn as small icons.
 */
public class PlatformerHud extends Actor
{
    public PlatformerHud()
    {
        setImage(new GreenfootImage(1, 1));
    }

    public void act()
    {
        World world = getWorld();
        if (!(world instanceof PlatformerWorld)) {
            return;
        }
        PlatformerWorld platWorld = (PlatformerWorld) world;
        Player player = platWorld.getPlayer();

        GreenfootImage img = new GreenfootImage(platWorld.getWidth(), 60);
        img.setColor(new Color(0, 0, 0, 180));
        img.fill();
        img.setColor(Color.WHITE);
        img.setFont(new Font("SansSerif", true, false, 16));
        img.drawString("Score: " + player.getScore() + "   Level: " + platWorld.getLevel()
            + "   Streak: " + player.getStreak() + "   High: " + platWorld.getHighScore(), 10, 20);

        if (platWorld.isGameOver()) {
            img.drawString("Game over, press UP to play again", 10, 42);
        }
        else {
            img.drawString("Jump to: " + platWorld.getCurrentPrompt() + " = ?", 10, 42);
        }

        drawLivesIcons(img, player.getLives(), platWorld.getWidth());

        if (!platWorld.isGameOver()) {
            drawTimerBar(img, platWorld.getTimeFraction());
        }

        setImage(img);
    }

    private void drawLivesIcons(GreenfootImage img, int lives, int worldWidth)
    {
        GreenfootImage heart = new GreenfootImage("heart_full.png");
        heart.scale(22, 22);
        for (int i = 0; i < lives; i++) {
            int x = worldWidth - 35 - (i * 26);
            img.drawImage(heart, x, 4);
        }
    }

    private void drawTimerBar(GreenfootImage img, double fraction)
    {
        int barWidth = (int) (250 * fraction);
        if (barWidth > 75) {
            img.setColor(Color.GREEN);
        }
        else if (barWidth > 35) {
            img.setColor(Color.YELLOW);
        }
        else {
            img.setColor(Color.RED);
        }
        img.fillRect(380, 30, Math.max(barWidth, 0), 15);
        img.setColor(Color.WHITE);
        img.drawRect(380, 30, 250, 15);
    }
}
