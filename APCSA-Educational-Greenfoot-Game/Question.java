/**
 * Question - a simple data holder for one quiz question: a prompt,
 * the correct answer, and a set of wrong answers to mix in with it.
 */
public class Question
{
    private String prompt;
    private String correctAnswer;
    private String[] wrongAnswers;

    public Question(String prompt, String correctAnswer, String[] wrongAnswers)
    {
        this.prompt = prompt;
        this.correctAnswer = correctAnswer;
        this.wrongAnswers = wrongAnswers;
    }

    public String getPrompt()
    {
        return prompt;
    }

    public String getCorrectAnswer()
    {
        return correctAnswer;
    }

    public String[] getWrongAnswers()
    {
        return wrongAnswers;
    }
}
