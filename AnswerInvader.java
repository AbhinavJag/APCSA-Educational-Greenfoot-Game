import greenfoot.*;

/**
 * AnswerInvader - falls from the top of the screen carrying one
 * possible answer to the current question. CorrectAnswerInvader and
 * WrongAnswerInvader both extend this and override handleHit() /
 * handleMissed() differently depending on whether they were the
 * right choice.
 */
public abstract class AnswerInvader extends Actor
{
    private int dropSpeed = 2;

    public AnswerInvader(String answerText)
    {
        buildImage(answerText);
    }

    private void buildImage(String answerText)
    {
        int width = Math.max(70, answerText.length() * 10 + 20);
        GreenfootImage img = new GreenfootImage(width, 30);
        img.setColor(new Color(255, 140, 0));
        img.fill();
        img.setColor(Color.BLACK);
        img.drawRect(0, 0, width - 1, 29);
        img.setFont(new Font("SansSerif", true, false, 14));
        img.drawString(answerText, 8, 20);
        setImage(img);
    }

    public void act()
    {
        setLocation(getX(), getY() + dropSpeed);
        if (getY() > 600) {
            handleMissed();
        }
    }

    public abstract void handleHit();
    public abstract void handleMissed();
}
