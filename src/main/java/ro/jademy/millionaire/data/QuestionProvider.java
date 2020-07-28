package ro.jademy.millionaire.data;

import ro.jademy.millionaire.model.Answer;
import ro.jademy.millionaire.model.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuestionProvider {

    public static List<Question> ALL_QUESTIONS = Arrays.asList(

            new Question("Which of these is a palindrome?", Arrays.asList(
                    new Answer("Cook"),
                    new Answer("9393"),
                    new Answer("13579")),

                    new Answer("Deed"), 0),
            new Question("Which of these countries is NOT part of the UK?", Arrays.asList(
                    new Answer("Scotland"),
                    new Answer("England"),
                    new Answer("Wales")),

                    new Answer("Ireland"), 0),
            new Question("Which continent is Ghana located in?", Arrays.asList(
                    new Answer("South America"),
                    new Answer("Antarctica"),
                    new Answer("North America")),

                    new Answer("Africa"), 0),
            new Question("How many circles appear in the Olympic logo?", Arrays.asList(
                    new Answer("Four"),
                    new Answer("Three"),
                    new Answer("Two")),

                    new Answer("Five"), 0),
            new Question("Which zodiac sign is not represented by a horned animal?", Arrays.asList(
                    new Answer("Aries"),
                    new Answer("Capricorn"),
                    new Answer("Taurus")),

                    new Answer("Virgo"), 0),
            new Question("Ballet originated in which country?", Arrays.asList(
                    new Answer("Brazil"),
                    new Answer("China"),
                    new Answer("France")),

                    new Answer("Italy"), 0),
            new Question("What is the first letter of the Greek alphabet?", Arrays.asList(
                    new Answer("Zed"),
                    new Answer("E"),
                    new Answer("Omega")),

                    new Answer("Alpha"), 0),
            new Question("Question 1?", Arrays.asList(
                    new Answer("one"),
                    new Answer("two"),
                    new Answer("three")),

                    new Answer("four"), 1),
            new Question("Globophobia is a fear of?", Arrays.asList(
                    new Answer("Lollipops"),
                    new Answer("Water"),
                    new Answer("Heights")),

                    new Answer("Balloons"), 1),
            new Question("Which instrument does not have strings?", Arrays.asList(
                    new Answer("Guitar"),
                    new Answer("Bass"),
                    new Answer("Cello")),

                    new Answer("Trombone"), 1),
            new Question("Which U.S. city is home to the Liberty Bell and Independence Hall?", Arrays.asList(
                    new Answer("Denver"),
                    new Answer("Seattle"),
                    new Answer("Washington D.C.")),

                    new Answer("Philadelphia"), 1),
            new Question("What is the first name of McDonald's mascot?", Arrays.asList(
                    new Answer("Susan"),
                    new Answer("George"),
                    new Answer("Karl")),

                    new Answer("Ronald"), 1),
            new Question("Which scientific unit is named after an Italian nobleman?", Arrays.asList(
                    new Answer("Pascal"),
                    new Answer("Ohm"),
                    new Answer("Hertz")),

                    new Answer("Volt"), 1),
            new Question("How many days make up a non-leap year in the Islamic calendar?", Arrays.asList(
                    new Answer("365"),
                    new Answer("400"),
                    new Answer("376")),

                    new Answer("354"), 1),
            new Question("Famous pediatrician and author Dr. Benjamin Spock won an Olympic gold medal in what sport?", Arrays.asList(
                    new Answer("Swimming"),
                    new Answer("Fencing"),
                    new Answer("Sailing")),

                    new Answer("Rowing"), 2),
            new Question("IBM's Deep Blue beat which of these chess players in 1997?", Arrays.asList(
                    new Answer("Anatoly Karpov"),
                    new Answer("Boris Spassky"),
                    new Answer("Bobby Fischer")),

                    new Answer("Garry Kasparov"), 2),
            new Question("New Zealand's Parliament building is known by what name?", Arrays.asList(
                    new Answer("The Basin"),
                    new Answer("Cake Tin"),
                    new Answer("Hornet's Nest")),

                    new Answer("The Beehive"), 2),
            new Question("According to the Population Reference Bureau, what is the approximate number of people who have ever lived on earth?", Arrays.asList(
                    new Answer("50 billion"),
                    new Answer("1 trillion"),
                    new Answer("5 trillion")),

                    new Answer("100 billion"), 2),
            new Question("During World War II, US soldiers used the first commercial aerosol cans to hold what?", Arrays.asList(
                    new Answer("Cleaning fluid"),
                    new Answer("Antiseptic"),
                    new Answer("Shaving cream")),

                    new Answer("Insecticide"), 2),
            new Question("Who is credited with inventing the first mass-produced helicopter?", Arrays.asList(
                    new Answer("Elmer Sperry"),
                    new Answer("Ferdinand von Zeppelin"),
                    new Answer("Gottlieb Daimler")),

                    new Answer("Igor Sikorsky"), 2),
            new Question("In the children’s book series, where is Paddington Bear originally from?", Arrays.asList(
                    new Answer("India"),
                    new Answer("Canada"),
                    new Answer("Iceland")),

                    new Answer("Peru"), 2),
            new Question("Which of the following landlocked countries is entirely contained within another country?", Arrays.asList(
                    new Answer("Burkina Faso"),
                    new Answer("Mongolia"),
                    new Answer("Luxembourg")),

                    new Answer("Lesotho"), 3),
            new Question("Which of the following men does not have a chemical element named for him?", Arrays.asList(
                    new Answer("Albert Einstein"),
                    new Answer("Niels Bohr"),
                    new Answer("Enrico Fermi")),

                    new Answer("Isaac Newton"), 3),
            new Question("Which insect shorted out an early supercomputer and inspired the term 'computer bug'?", Arrays.asList(
                    new Answer("Roach"),
                    new Answer("Fly"),
                    new Answer("Japanese beetle")),

                    new Answer("Moth"), 3),
            new Question("The Earth is approximately how many miles away from the Sun?", Arrays.asList(
                    new Answer("9.3 million"),
                    new Answer("39 million"),
                    new Answer("193 million")),

                    new Answer("93 million"), 3)

    );

    public static List<Question> getRandomQuestions(int nrOfQuestions, int difficulty) {

        //loop through all questions
        //get all questions of given difficulty
        //loop through sub-list until nrOfQuestions and select random items by index
        //return list

        List<Question> questionsOfDiff = new ArrayList<>();
        List<Question> questionsRandom = new ArrayList<>();

        for (Question question : QuestionProvider.ALL_QUESTIONS) {
            if (question.getDifficulty() == difficulty) {
                questionsOfDiff.add(question);
            }
        }
        Random random = new Random();
        for (int i = 0; i < nrOfQuestions; i++) {
            int randomIndex = random.nextInt(questionsOfDiff.size());
            questionsRandom.add(questionsOfDiff.remove(randomIndex));
        }
        return questionsRandom;
    }

}
