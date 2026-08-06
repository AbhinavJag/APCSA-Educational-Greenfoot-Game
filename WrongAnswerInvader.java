import greenfoot.*;

/**
 * WrongAnswerInvader - a distractor answer. Shooting it costs a
 * life; letting it fall past the bottom has no penalty, since only
 * the correct answer needs to be caught.
 */
public class WrongAnswerInvader extends AnswerInvader
{
    public WrongAnswerInvader(String answerText)
    {
        super(answerText);
    }

    public void handleHit()
    {
        QuizWorld world = (QuizWorld) getWorld();
        world.wrongAnswerHit();
    }

    public void handleMissed()
    {
        // No penalty for letting a wrong answer fall past the bottom.
    }
}
