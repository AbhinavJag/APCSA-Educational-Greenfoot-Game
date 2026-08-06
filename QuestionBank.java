import java.util.ArrayList;

/**
 * QuestionBank - holds the shared pool of quiz questions and hands
 * out the current one. Every AnswerInvader that spawns reads from
 * this same static source, so the whole world always agrees on what
 * question is currently active.
 */
public class QuestionBank
{
    private static ArrayList<Question> questions = buildQuestions();
    private static int currentIndex = 0;

    private static ArrayList<Question> buildQuestions()
    {
        ArrayList<Question> list = new ArrayList<Question>();
        list.add(new Question("2 + 2", "4", new String[]{"3", "5", "22"}));
        list.add(new Question("5 x 6", "30", new String[]{"11", "60", "25"}));
        list.add(new Question("Capital of France", "Paris", new String[]{"London", "Berlin", "Rome"}));
        list.add(new Question("H2O is", "Water", new String[]{"Salt", "Oxygen", "Sugar"}));
        list.add(new Question("10 - 3", "7", new String[]{"6", "13", "3"}));
        list.add(new Question("Largest planet", "Jupiter", new String[]{"Earth", "Mars", "Saturn"}));
        list.add(new Question("9 / 3", "3", new String[]{"6", "27", "1"}));
        list.add(new Question("Author of Hamlet", "Shakespeare", new String[]{"Dickens", "Austen", "Twain"}));
        return list;
    }

    public static Question getCurrentQuestion()
    {
        return questions.get(currentIndex);
    }

    public static void nextQuestion()
    {
        currentIndex = (currentIndex + 1) % questions.size();
    }
}
