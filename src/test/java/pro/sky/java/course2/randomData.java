package pro.sky.java.course2;

import com.thedeanda.lorem.LoremIpsum;

import java.util.HashSet;
import java.util.Random;

public class randomData {

    public static String randomPhrase(int origin, int bound) {
        return new LoremIpsum().getWords(origin, bound);
    }

    public static int randomInt(int origin, int bound) {
        return new Random().nextInt(origin, bound);
    }

    public static HashSet<Question> randomQuestionSet(int numberOfQuestions) {
        HashSet<Question> questionSet = new HashSet<>(numberOfQuestions);
        for (int i = 0; i < numberOfQuestions; i++) {
            questionSet.add(new Question(randomPhrase(3, 5), randomPhrase(5, 15)));
        }
        return questionSet;
    }

    public static Question randomQuestion() {
        return new Question(randomPhrase(3, 5) + "?", randomPhrase(5, 15));
    }
}

/*
private int randomInt(int origin, int bound) {
        return (new Random()).nextInt(origin,bound);
    }

    private static String randomPhrase(int origin, int bound){
        Lorem lorem = new LoremIpsum();
        return lorem.getWords(origin,bound);
    }
 */