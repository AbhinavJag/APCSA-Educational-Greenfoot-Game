import greenfoot.*;

/**
 * CorrectAnswerInvader - the one invader per round carrying the
 * right answer. Shooting it scores a point and advances the quiz;
 * letting it fall past the bottom costs a life instead.
 */
public class CorrectAnswerInvader extends AnswerInvader
{
    public CorrectAnswerInvader(String answerText)
    {
        super(answerText);
    }

    public void handleHit()
    {
        QuizWorld world = (QuizWorld) getWorld();
        world.correctAnswerHit();
    }

    public void handleMissed()
    {
        QuizWorld world = (QuizWorld) getWorld();
        world.correctAnswerMissed();
    }
}
