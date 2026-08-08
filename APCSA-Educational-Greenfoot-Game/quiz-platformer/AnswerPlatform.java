import greenfoot.*;

/**
 * AnswerPlatform - a floating platform labeled with one possible
 * answer to the current question. CorrectAnswerPlatform and
 * WrongAnswerPlatform both extend this and override onLanded()
 * differently depending on whether they were the right choice.
 */
public abstract class AnswerPlatform extends Actor
{
    public AnswerPlatform(String answerText)
    {
        buildImage(answerText);
    }

    private void buildImage(String answerText)
    {
        int width = Math.max(90, answerText.length() * 10 + 20);
        int height = 36;

        GreenfootImage tile = new GreenfootImage("block_tile.png");
        tile.scale(36, height);

        GreenfootImage img = new GreenfootImage(width, height);
        for (int x = 0; x < width; x = x + 36) {
            img.drawImage(tile, x, 0);
        }

        img.setColor(Color.BLACK);
        img.setFont(new Font("SansSerif", true, false, 13));
        img.drawString(answerText, 8, height - 8);
        setImage(img);
    }

    public abstract void onLanded();
}
