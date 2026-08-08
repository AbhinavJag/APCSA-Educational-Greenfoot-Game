import greenfoot.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * PlatformerWorld - a ground platform sits at the bottom, and one
 * question's worth of answer platforms float above it. Landing on
 * the correct one scores a point and advances to the next question;
 * landing on a wrong one, touching the Hazard, or running out the
 * round timer all cost a life. On game over, pressing the up arrow
 * starts a new round without a full scenario reset.
 */
public class PlatformerWorld extends World
{
    private static final int ROUND_TIME = 600;

    private Player player;
    private int roundTimer;
    private boolean gameOver = false;
    private int highScore = 0;

    public PlatformerWorld()
    {
        super(700, 600, 1);
        buildBackground();

        Platform ground = new Platform(700, 40);
        addObject(ground, 350, 580);

        player = new Player();
        addObject(player, 60, 540);

        addObject(new Hazard(300, 550), 400, 560);

        addObject(new PlatformerHud(), 350, 30);
        addObject(new GameOverOverlay(), 350, 300);

        roundTimer = ROUND_TIME;
        spawnQuestionPlatforms();
    }

    private void buildBackground()
    {
        GreenfootImage bg = new GreenfootImage(getWidth(), getHeight());
        bg.setColor(new Color(120, 180, 255));
        bg.fill();
        setBackground(bg);
    }

    public void act()
    {
        if (gameOver) {
            if (Greenfoot.isKeyDown("up")) {
                restart();
            }
            return;
        }

        roundTimer = roundTimer - 1;
        if (roundTimer <= 0) {
            missRound();
        }
    }

    public int getLevel()
    {
        return 1 + player.getScore() / 4;
    }

    private void spawnQuestionPlatforms()
    {
        Question q = QuestionBank.getCurrentQuestion();

        ArrayList<String> answers = new ArrayList<String>();
        answers.add(q.getCorrectAnswer());
        for (String wrong : q.getWrongAnswers()) {
            answers.add(wrong);
        }
        Collections.shuffle(answers);

        int platformY = Math.max(180, 480 - Math.min(getLevel() * 15, 260));
        int spacing = getWidth() / (answers.size() + 1);

        for (int i = 0; i < answers.size(); i++) {
            String answer = answers.get(i);
            AnswerPlatform platform;
            if (answer.equals(q.getCorrectAnswer())) {
                platform = new CorrectAnswerPlatform(answer);
            }
            else {
                platform = new WrongAnswerPlatform(answer);
            }
            addObject(platform, spacing * (i + 1), platformY);
        }

        roundTimer = ROUND_TIME;
    }

    public void correctAnswerLanded()
    {
        player.correctHit();
        advanceRound();
    }

    public void wrongAnswerLanded()
    {
        player.miss();
        if (player.getLives() <= 0) {
            endGame();
        }
        else {
            clearPlatforms();
            spawnQuestionPlatforms();
        }
    }

    public void hazardHit()
    {
        player.miss();
        if (player.getLives() <= 0) {
            endGame();
        }
    }

    private void missRound()
    {
        player.miss();
        if (player.getLives() <= 0) {
            endGame();
        }
        else {
            advanceRound();
        }
    }

    private void advanceRound()
    {
        QuestionBank.nextQuestion();
        clearPlatforms();
        spawnQuestionPlatforms();
    }

    private void endGame()
    {
        gameOver = true;
        if (player.getScore() > highScore) {
            highScore = player.getScore();
        }
        clearPlatforms();
    }

    private void restart()
    {
        player.reset();
        player.setLocation(60, 540);
        gameOver = false;
        clearPlatforms();
        spawnQuestionPlatforms();
    }

    private void clearPlatforms()
    {
        removeObjects(getObjects(AnswerPlatform.class));
    }

    public Player getPlayer()
    {
        return player;
    }

    public String getCurrentPrompt()
    {
        return QuestionBank.getCurrentQuestion().getPrompt();
    }

    public boolean isGameOver()
    {
        return gameOver;
    }

    public int getHighScore()
    {
        return highScore;
    }

    public double getTimeFraction()
    {
        return Math.max(0, (double) roundTimer / ROUND_TIME);
    }
}
