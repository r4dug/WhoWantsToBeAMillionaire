package ro.jademy.millionaire;

import ro.jademy.millionaire.data.QuestionProvider;
import ro.jademy.millionaire.model.Answer;
import ro.jademy.millionaire.model.Game;
import ro.jademy.millionaire.model.Question;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        //1. define objects
        // define properties
        // define methods

        //2. define interactions


        //initialize questions
        List<Question> difficultyZeroQuestion = QuestionProvider.getRandomQuestions(5, 0);
        List<Question> difficultyOneQuestion = QuestionProvider.getRandomQuestions(5, 1);
        List<Question> difficultyTwoQuestion = QuestionProvider.getRandomQuestions(4, 2);
        List<Question> difficultyThreeQuestion = QuestionProvider.getRandomQuestions(1, 3);

        //initialize game
        Game game = new Game(difficultyZeroQuestion, difficultyOneQuestion, difficultyTwoQuestion, difficultyThreeQuestion);

        //start game
        game.showWelcomeScreen();

    }
}
