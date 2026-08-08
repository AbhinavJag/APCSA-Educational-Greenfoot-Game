import greenfoot.*;

/**
 * WrongAnswerPlatform - landing on this costs a life. The platform
 * gets cleared away as part of the round reset, so it plays like a
 * crumbling platform: the player lands, then the floor is gone on
 * the very next frame's re-layout.
 */
public class WrongAnswerPlatform extends AnswerPlatform
{
    public WrongAnswerPlatform(String answerText)
    {
        super(answerText);
    }

    public void onLanded()
    {
        PlatformerWorld world = (PlatformerWorld) getWorld();
        world.wrongAnswerLanded();
    }
}
