package pro.sky.java.course2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.randomData.randomInt;
import static pro.sky.java.course2.randomData.randomPhrase;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    Question questionMock;

    @InjectMocks
    JavaQuestionService javaQuestionServiceMocked;

    @Test
    public void JavaQuestionTest() {
        JavaQuestionRepository questionSet = new JavaQuestionRepository();
        Question question1 = new Question("Java Test Question #1", "Java Test Answer #1");
        questionSet.add(question1);
        JavaQuestionService javaQuestionService = new JavaQuestionService(questionSet);
        assertEquals(questionSet, javaQuestionService.getQuestionStorage());
    }

    @Test
    public void JavaQuestionNoArgsTest() {
        Set<Question> questionSet = new HashSet<>();
        Set<Question> emptyQuestionSet = new HashSet<>();
        Question question1 = new Question("Java Test Question #1", "Java Test Answer #1");
        questionSet.add(question1);
        JavaQuestionService javaQuestionService = new JavaQuestionService(questionStorage);
        assertEquals(emptyQuestionSet, javaQuestionService.getQuestionStorage());
    }

    @Test
    public void removeTest() {
        Question question1 = new Question("Java Test Question #1", "Java Test Answer #1");
        Question question2 = new Question("Java Test Question #2", "Java Test Answer #2");
        JavaQuestionRepository questionSet = new JavaQuestionRepository();
        questionSet.add(question1);
        questionSet.add(question2);
        JavaQuestionService javaQuestionService = new JavaQuestionService(questionStorage);
        javaQuestionService.setQuestionStorage(questionSet);
        assertEquals(questionSet, javaQuestionService.getQuestionStorage());
        assertEquals(question2, javaQuestionService.remove(question2));
        assertThrows(QuestionServiceException.class, () -> javaQuestionService.remove(question2));
    }


    private static Set<Question> randomQuestionSetGenerator(int numberOfQuestions) {
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

    @Test
    public void getAllTest() {
        Set<Question> testQuestionSet = new HashSet<>();
        testQuestionSet = randomQuestionSetGenerator(15);
        JavaQuestionService javaQuestionService = new JavaQuestionService(questionStorage);
        for (Question q : testQuestionSet
        ) {
            javaQuestionService.add(q);
        }
        assertEquals(testQuestionSet, javaQuestionService.getAll());
    }

    @Test
    public void getRandomQuestionTest() {
        JavaQuestionService javaQuestionService =
                new JavaQuestionService(
                        new JavaQuestionRepository(randomQuestionSetGenerator(randomInt(10, 20))));
        Question question = javaQuestionService.getRandomQuestion();
        assertTrue(javaQuestionService.getAll().contains(question));
    }

    @Test
    public void removeStringArgsTest() {
        JavaQuestionService javaQuestionService =
                new JavaQuestionService(
                        new JavaQuestionRepository(randomQuestionSetGenerator(randomInt(10, 20))));
        String testProblem = randomPhrase(3, 5);
        String testAnswer = randomPhrase(5, 15);
        Question testQuestion = new Question(testProblem, testAnswer);
        assertEquals(testQuestion, javaQuestionService.add(testQuestion));
        assertEquals(testQuestion, javaQuestionService.remove(testQuestion));
        assertThrows(QuestionServiceException.class, () -> javaQuestionService.remove(testQuestion));
    }

    @Test
    public void addQuestionArgTest() {
        JavaQuestionService javaQuestionService =
                new JavaQuestionService(
                        new JavaQuestionRepository(randomQuestionSetGenerator(randomInt(10, 20))));
        String testProblem = randomPhrase(3, 5);
        String testAnswer = randomPhrase(5, 15);
        Question testQuestion = new Question(testProblem, testAnswer);
        assertEquals(testQuestion, javaQuestionService.add(testQuestion));
        assertTrue(javaQuestionService.getAll().contains(testQuestion));
        assertThrows(QuestionServiceException.class, () -> javaQuestionService.add(testQuestion));
    }

    @Test
    public void addStringArgsTest() {
        JavaQuestionService javaQuestionService =
                new JavaQuestionService(new JavaQuestionRepository(
                        randomQuestionSetGenerator(randomInt(10, 20))));
        String testProblem = randomPhrase(3, 5);
        String testAnswer = randomPhrase(5, 15);
        Question testQuestion = new Question(testProblem, testAnswer);
        assertEquals(testQuestion, javaQuestionService.add(testProblem, testAnswer));
        assertTrue(javaQuestionService.getAll().contains(testQuestion));
        assertThrows(QuestionServiceException.class, () -> javaQuestionService.add(testProblem, testAnswer));
    }


}
