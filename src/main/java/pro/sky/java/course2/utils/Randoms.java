package pro.sky.java.course2.utils;

import com.thedeanda.lorem.LoremIpsum;
import pro.sky.java.course2.question.Question;
import pro.sky.java.course2.question.QuestionServiceException;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Randoms {

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

    public static Set<Question> randomQuestionSetGenerator(int numberOfQuestions) {
        Set<Question> dummyQuestions = new HashSet<>();
        if (numberOfQuestions <= 0) {
            throw new QuestionServiceException("numberOfDummyQuestions must be over zero");
        }

        Question question = new Question();

        for (int i = 1; i <= numberOfQuestions; i++) {
            question = new Question(randomPhrase(3, 5) + "?",
                    randomPhrase(5, 15));
            dummyQuestions.add(question);
        }
        return dummyQuestions;
    }
}