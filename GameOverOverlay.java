import greenfoot.*;

/**
 * GameOverOverlay - a dedicated actor centered in the world that
 * only becomes visible once the game is over. Kept separate from
 * PlatformerHud so the two images never fight over the same actor
 * position and size.
 */
public class GameOverOverlay extends Actor
{
    public GameOverOverlay()
    {
        clearImage();
    }

    public void act()
    {
        World world = getWorld();
        if (!(world instanceof PlatformerWorld)) {
            return;
        }
        PlatformerWorld platWorld = (PlatformerWorld) world;
        Player player = platWorld.getPlayer();

        if (platWorld.isGameOver()) {
            GreenfootImage img = new GreenfootImage(420, 140);
            img.setColor(new Color(0, 0, 0, 210));
            img.fill();
            img.setColor(Color.WHITE);
            img.setFont(new Font("SansSerif", true, false, 20));
            img.drawString("Out of lives!", 20, 35);
            img.drawString("Final score: " + player.getScore(), 20, 70);
            img.drawString("High score: " + platWorld.getHighScore(), 20, 100);
            img.drawString("Press UP to play again", 20, 130);
            setImage(img);
        }
        else {
            clearImage();
        }
    }

    private void clearImage()
    {
        GreenfootImage empty = new GreenfootImage(1, 1);
        empty.setTransparency(0);
        setImage(empty);
    }
}
