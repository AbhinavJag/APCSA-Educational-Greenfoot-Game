import greenfoot.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * QuizWorld - spawns one CorrectAnswerInvader and several
 * WrongAnswerInvaders per round, based on the current question from
 * QuestionBank. Shooting the correct one scores a point and moves
 * to the next question; missing it or shooting a wrong one costs a
 * life.
 */
public class QuizWorld extends World
{
    private Ship ship;

    public QuizWorld()
    {
        super(700, 600, 1);
        ship = new Ship();
        addObject(ship, 350, 560);
        addObject(new QuizHud(), 250, 30);

        spawnQuestionInvaders();
    }

    private void spawnQuestionInvaders()
    {
        Question q = QuestionBank.getCurrentQuestion();

        ArrayList<String> answers = new ArrayList<String>();
        answers.add(q.getCorrectAnswer());
        for (String wrong : q.getWrongAnswers()) {
            answers.add(wrong);
        }
        Collections.shuffle(answers);

        int spacing = getWidth() / (answers.size() + 1);
        for (int i = 0; i < answers.size(); i++) {
            String answer = answers.get(i);
            AnswerInvader invader;
            if (answer.equals(q.getCorrectAnswer())) {
                invader = new CorrectAnswerInvader(answer);
            }
            else {
                invader = new WrongAnswerInvader(answer);
            }
            addObject(invader, spacing * (i + 1), 40);
        }
    }

    public void correctAnswerHit()
    {
        ship.addScore(1);
        QuestionBank.nextQuestion();
        clearInvaders();
        spawnQuestionInvaders();
    }

    public void wrongAnswerHit()
    {
        ship.loseLife();
        if (ship.getLives() <= 0) {
            clearInvaders();
            Greenfoot.stop();
        }
    }

    public void correctAnswerMissed()
    {
        ship.loseLife();
        if (ship.getLives() <= 0) {
            clearInvaders();
            Greenfoot.stop();
        }
        else {
            QuestionBank.nextQuestion();
            clearInvaders();
            spawnQuestionInvaders();
        }
    }

    private void clearInvaders()
    {
        removeObjects(getObjects(AnswerInvader.class));
    }

    public Ship getShip()
    {
        return ship;
    }

    public String getCurrentPrompt()
    {
        return QuestionBank.getCurrentQuestion().getPrompt();
    }
}
