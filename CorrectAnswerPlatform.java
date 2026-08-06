import greenfoot.*;

/**
 * CorrectAnswerPlatform - landing on this scores a point and
 * advances to the next question/level.
 */
public class CorrectAnswerPlatform extends AnswerPlatform
{
    public CorrectAnswerPlatform(String answerText)
    {
        super(answerText);
    }

    public void onLanded()
    {
        PlatformerWorld world = (PlatformerWorld) getWorld();
        world.correctAnswerLanded();
    }
}
