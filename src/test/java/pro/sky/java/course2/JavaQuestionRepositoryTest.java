package pro.sky.java.course2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.javaquiz.JavaQuestionRepository;
import pro.sky.java.course2.question.Question;
import pro.sky.java.course2.question.QuestionServiceException;
import pro.sky.java.course2.utils.Randoms;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.utils.Randoms.*;


public class JavaQuestionRepositoryTest {

    @Test
    public void addQuestionArgTest() {
        Collection<Question> testQuestionCollection = randomQuestionSet(randomInt(10, 50));
        JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository(testQuestionCollection);
        Question testQuestion;
        do {
            testQuestion = randomQuestion();
        } while (testQuestionCollection.contains(testQuestion));
        assertFalse(javaQuestionRepository.getAll().contains(testQuestion));
        assertEquals(testQuestion, javaQuestionRepository.add(testQuestion));
        Question finalTestQuestion = testQuestion;
        assertThrows(QuestionServiceException.class, () -> javaQuestionRepository.add(finalTestQuestion));

    }

    private Question getQuestion(String problem, String answer) {
        return new Question(problem, answer);
    }

    @Test
    public void addStringArgsTest() {
        Collection<Question> testQuestionCollection = randomQuestionSet(randomInt(10, 50));
        JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository(testQuestionCollection);
        String testProblem;
        String testAnswer;
        Question testQuiz;
        do {
            testProblem = randomPhrase(3, 5);
            testAnswer = randomPhrase(5, 15);
            testQuiz = getQuestion(testProblem, testAnswer);
        }
        while (testQuestionCollection.contains(testQuiz));
        assertFalse(javaQuestionRepository.getAll().contains(testQuiz));
        assertEquals(testQuiz, javaQuestionRepository.add(testProblem, testAnswer));
        Question finalTestQuestion = testQuiz;
        String finalTestAnswer = testAnswer;
        String finalTestProblem = testProblem;
        assertThrows(QuestionServiceException.class, () -> javaQuestionRepository.add(finalTestProblem, finalTestAnswer));
    }

    @Test
    public void removeQuestionArgTest() {
        Collection<Question> testQuestionCollection = randomQuestionSet(randomInt(10, 50));
        JavaQuestionRepository testJavaQuestionRepository = new JavaQuestionRepository(testQuestionCollection);
        Question testQuiz;

        testQuiz = testQuestionCollection.iterator().next();

        assertEquals(testQuiz, testJavaQuestionRepository.remove(testQuiz));
        assertThrows(QuestionServiceException.class, () -> testJavaQuestionRepository.remove(testQuiz));

    }

    @Test

    public void removeStringArgsTest() {
        Collection<Question> testQuestionCollection = randomQuestionSet(randomInt(10, 50));
        JavaQuestionRepository testJavaQuestionRepository = new JavaQuestionRepository(testQuestionCollection);
        Question testQuiz;

        testQuiz = testQuestionCollection.iterator().next();
        String testProblem = testQuiz.getProblem();
        String testAnswer = testQuiz.getAnswer();

        assertEquals(testQuiz, testJavaQuestionRepository.remove(testProblem, testAnswer));
        assertThrows(QuestionServiceException.class, () -> testJavaQuestionRepository.remove(testProblem, testAnswer));
    }

    @Test
    public void getAllTest() {
        Collection<Question> testQuestionCollection = randomQuestionSet(randomInt(10, 50));
        JavaQuestionRepository testJavaQuestionRepository = new JavaQuestionRepository(testQuestionCollection);
        assertEquals(testQuestionCollection, testJavaQuestionRepository.getAll());
    }

}
