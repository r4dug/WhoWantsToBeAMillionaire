package ro.jademy.millionaire;

import ro.jademy.millionaire.data.QuestionProvider;
import ro.jademy.millionaire.model.Game;
import ro.jademy.millionaire.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        //1. define objects
        // define properties
        // define methods

        //2. define interactions

        //initialize questions

        //List<Question> difficultyZeroQuestion = new ArrayList<>();
        List<Question> difficultyZeroQuestion = getRandomQuestions(5, 0);
        List<Question> difficultyOneQuestion = getRandomQuestions(5, 1);
        List<Question> difficultyTwoQuestion = getRandomQuestions(4, 2);
        List<Question> difficultyThreeQuestion = getRandomQuestions(1, 3);

        //initialize game
        Game game = new Game(difficultyZeroQuestion, difficultyOneQuestion, difficultyTwoQuestion, difficultyThreeQuestion);

        // TODO:
        //start game
        //game.start();
    }

    private static List<Question> getRandomQuestions(int nrOfQuestions, int difficulty) {
        //TODO:
        //loop through all questions
        //get all questions of given difficulty
        //loop through sub-list until nrOfQuestions and select random items by index
        //return list

        List<Question> questionsDiff = new ArrayList<>();
        List<Question> randomQuestions = new ArrayList<>();

        for (Question question : QuestionProvider.ALL_QUESTIONS) {
            if (question.getDifficulty() == difficulty) {
                questionsDiff.add(question);
            }
        }

        Random random = new Random();

        for (int i = 0; i < nrOfQuestions; i++) {

            int randomIndex = random.nextInt(questionsDiff.size());
            randomQuestions.add(questionsDiff.remove(randomIndex));
        }

        return randomQuestions;
    }
}
