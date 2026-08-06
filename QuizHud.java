import greenfoot.*;

/**
 * QuizHud - sits at the top of the world and shows the ship's score
 * and lives, plus the prompt for the question currently active.
 */
public class QuizHud extends Actor
{
    public QuizHud()
    {
        setImage(new GreenfootImage(1, 1));
    }

    public void act()
    {
        World world = getWorld();
        if (!(world instanceof QuizWorld)) {
            return;
        }
        QuizWorld quizWorld = (QuizWorld) world;
        Ship ship = quizWorld.getShip();

        GreenfootImage img = new GreenfootImage(500, 50);
        img.setColor(new Color(0, 0, 0, 180));
        img.fill();
        img.setColor(Color.WHITE);
        img.setFont(new Font("SansSerif", true, false, 16));
        img.drawString("Score: " + ship.getScore() + "   Lives: " + ship.getLives(), 10, 20);
        img.drawString(quizWorld.getCurrentPrompt() + " = ?", 10, 42);
        setImage(img);
    }
}
