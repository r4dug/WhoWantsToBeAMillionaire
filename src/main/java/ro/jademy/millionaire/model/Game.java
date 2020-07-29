package ro.jademy.millionaire.model;

import java.util.*;

public class Game {

    // 15 questions
    // 4 break points
    //                -> level [1,5]      -> difficulty 0
    //                -> level [6,10]     -> difficulty 1
    //                -> level [11,14]    -> difficulty 2
    //                -> level 15         -> difficulty 3

    // private static final List<Level> LEVELS = new ArrayList<Level>(); // not changing while gameplay - constant
    // static objects are firstly initialized
    private static final List<Level> LEVELS = Arrays.asList(

            new Level(1, 0, 100, 0),
            new Level(2, 0, 200, 0),
            new Level(3, 0, 500, 0),
            new Level(4, 0, 700, 0),
            new Level(5, 0, 1000, 0),
            new Level(6, 1, 2000, 1000),
            new Level(7, 1, 4000, 1000),
            new Level(8, 1, 8000, 1000),
            new Level(9, 1, 16000, 1000),
            new Level(10, 1, 32000, 1000),
            new Level(11, 2, 64000, 32000),
            new Level(12, 2, 125000, 32000),
            new Level(13, 2, 250000, 32000),
            new Level(14, 2, 500000, 32000),
            new Level(15, 3, 1000000, 500000)
    );

    private List<Question> difficultyZeroQuestions = new ArrayList<>();
    private List<Question> difficultyOneQuestions = new ArrayList<>();
    private List<Question> difficultyTwoQuestions = new ArrayList<>();
    private List<Question> difficultyThreeQuestions = new ArrayList<>();

    private int levelIndex = 0;
    private Level currentLevel = LEVELS.get(levelIndex); //reference to Level object

    private List<Lifeline> lifelines = new ArrayList<Lifeline>();

    private Scanner sc = new Scanner(System.in);


    public Game(List<Question> difficultyZeroQuestions, List<Question> difficultyOneQuestions, List<Question> difficultyTwoQuestions, List<Question> difficultyThreeQuestions) {
        this.difficultyZeroQuestions = difficultyZeroQuestions;
        this.difficultyOneQuestions = difficultyOneQuestions;
        this.difficultyTwoQuestions = difficultyTwoQuestions;
        this.difficultyThreeQuestions = difficultyThreeQuestions;

        lifelines.add(new Lifeline("50-50"));
        lifelines.add(new Lifeline("AskAudience"));
        lifelines.add(new Lifeline("CallAFriend"));

    }
    // questions will be different at every game instance

    public void startGameMenu() {

        System.out.println("\n\n\t*** Who wants to be a millionaire? ***");
        System.out.println("1.Play the game");
        System.out.println("2.Rules");
        System.out.println("3.Exit");

        menuOptions();
    }

    public void menuOptions() {
        System.out.println("\nChoose an option\n");
        String optionSelected = sc.nextLine();
        switch (optionSelected) {
            case "1":
                start();
                break;
            case "2":
                showRules();
                startGameMenu();
                break;
            case "3":
                System.exit(0);
                break;

            default:
                System.out.println("Choose a correct option.");
        }
    }


    private void showRules() {

        System.out.println("| ------------------RULES------------------ |");
        System.out.println("Who Wants to Be a Millionaire? is a quiz competition game.");
        System.out.println("Contestants have to correctly answer a series of multiple-choice questions in order to advance.");
        System.out.println("There are 15 questions in total and each question is worth a specific amount of money.");
        System.out.println("Questions are structured according to four different Levels with each level increasing in difficulty.");
        System.out.println("There are three ‘safe havens’ in the question structure (Questions five, ten and fifteen).");
        System.out.println("Each player will have 3 lifelines at the start of the game. (50-50 / Call a friend / Ask audience)");
        System.out.println("Good luck!");
        System.out.println("| ----------------------------------------- |");
    }

    public void start() {

        //TODO:
        //show welcome screen
        //optionally : show rules (rounds, lifelines, etc)
        //show current level question
        //read command from player
        // - if lifeline -> apply lifeline
        // - if end game -> take current money and walk away
        // - read answer -> check answer
        //        -if answer correct -> go to next level (set next level as current, set amount of money etc.
        //        -if answer incorrect -> end game (calculate end game sum, show bye-bye message etc.)

        do {
            showQuestion();
        }
        while (currentLevel.getNumber()<15);
    }

    private void showQuestion() {
        Question question;
        List<Answer> allAnswers;

            switch (currentLevel.getDifficultyLevel()) {
                case 0:
                    question = difficultyZeroQuestions.get(0);
                    allAnswers = printQuestion(question);
                    System.out.println();
                    System.out.println("Press L for Lifeline / W for Walkaway");
                   userAnswer(allAnswers,difficultyZeroQuestions);
                   currentLevel=LEVELS.get(++levelIndex);
                //applyLifeline(lifelines.get(0), allAnswers, question.getCorrectAnswer());
                    break;
                case 1:
                    question = difficultyOneQuestions.get(0);
                    allAnswers = printQuestion(question);
                    System.out.println();
                    System.out.println("Press L for Lifeline / W for Walkaway");
                    userAnswer(allAnswers,difficultyOneQuestions);
                    // applyLifeline(lifelines.get(0), allAnswers, question.getCorrectAnswer());
                    break;
                case 2:
                    question = difficultyTwoQuestions.get(0);
                    allAnswers = printQuestion(question);
                    System.out.println();
                    System.out.println("Press L for Lifeline / W for Walkaway");
                    userAnswer(allAnswers,difficultyTwoQuestions);
                    //applyLifeline(lifelines.get(0), allAnswers, question.getCorrectAnswer());
                    break;
                case 3:
                    question = difficultyThreeQuestions.get(levelIndex);
                    allAnswers = printQuestion(question);
                    System.out.println();
                    System.out.println("Press L for Lifeline / W for Walkaway");
                    userAnswer(allAnswers,difficultyThreeQuestions);
                    //applyLifeline(lifelines.get(0), allAnswers, question.getCorrectAnswer());
                    break;
                default:
                    System.out.println("Unknown difficulty level");
                    break;
            }

    }

    private List<Answer> printQuestion(Question question) {
        System.out.println(question.getText());
        System.out.println();

        List<Answer> allAnswers = new ArrayList<>(question.getWrongAnswers());
        allAnswers.add(question.getCorrectAnswer());
        // randomize list
        Collections.shuffle(allAnswers);

        for (int i = 0; i < allAnswers.size(); i++) {
            System.out.println(((char) (65 + i)) + ". " + allAnswers.get(i).getText());
        }

        return allAnswers;
    }

    private void applyLifeline(Lifeline lifeline, List<Answer> allAnswers, Answer correctAnswer) {

        if (lifeline.getName().equals("50-50")) {
            // print all answers except two random WRONG answers
            Random rnd = new Random();
            List<Answer> answerListCopy = new ArrayList<>(allAnswers);
            answerListCopy.remove(correctAnswer);
            answerListCopy.remove(rnd.nextInt(answerListCopy.size()));
            answerListCopy.remove(rnd.nextInt(answerListCopy.size()));

            for (int i = 0; i < allAnswers.size(); i++) {
                Answer answer = allAnswers.get(i);
                if (answer.equals(correctAnswer) || answerListCopy.contains(answer)) {
                    System.out.println(((char) (65 + i)) + ". " + allAnswers.get(i).getText());
                } else {
                    System.out.println(((char) (65 + i)) + ". ");
                }
            }
        }

        lifeline.setUsed(true);
    }

    public boolean userAnswer ( List<Answer> allAnswers, List<Question> questionList) {

        boolean isCorrectAnswer=false;
        String userChoice= sc.nextLine();
        switch (userChoice) {

            case "A":
                isCorrectAnswer = verifyCorrectAnswer(0, allAnswers, questionList);
                break;
            case "B":
                isCorrectAnswer = verifyCorrectAnswer(1, allAnswers, questionList );
                break;
            case "C":
                isCorrectAnswer = verifyCorrectAnswer(2, allAnswers, questionList );
                break;
            case "D":
                isCorrectAnswer = verifyCorrectAnswer(3, allAnswers, questionList);
                break;

/*            case "L":
                applyLifeline(lifelines.get(0), allAnswers, question.getCorrectAnswer());
                break;*/
            case "W":
                System.out.println("Reward: " + currentLevel.getReward());
                isCorrectAnswer=false;
                break;

            default:
                System.out.println("Input not recognized. Please enter a valid input!");


        }

        return isCorrectAnswer;
    }


    private boolean verifyCorrectAnswer(int index, List<Answer> allAnswers, List<Question> questionList) {
        boolean isCorrectAnswer;
        if (allAnswers.get(index).getText().equals
                (questionList.get(0).getCorrectAnswer().getText())) {
            isCorrectAnswer = true;
            System.out.println("Correct answer! Advance to the next round. \n");
            questionList.remove(0);
        } else {
            System.out.println("Wrong answer! Game is ending. \n ");
            System.out.println("Reward Checkpoint: " + currentLevel.getRewardWalkAway());
            isCorrectAnswer = false;
            System.exit(0);
        }
        return isCorrectAnswer;
    }

    private boolean answerQuestion(List<Question> questionList, List<Answer> allAnswers) {
        boolean isCorrectAnswer;

        isCorrectAnswer = userAnswer(allAnswers, questionList);
        return isCorrectAnswer;
    }



    public void endGame(Answer playerInput) {

    }
}