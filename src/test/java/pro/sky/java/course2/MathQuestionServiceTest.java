package pro.sky.java.course2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.mathquiz.MathQuestionService;
import pro.sky.java.course2.question.Question;
import pro.sky.java.course2.question.QuestionRepository;
import pro.sky.java.course2.question.QuestionServiceException;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.utils.Randoms.randomInt;
import static pro.sky.java.course2.utils.Randoms.randomQuestionSet;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {
    @Mock
    QuestionRepository questionRepositoryMock;

    @InjectMocks
    MathQuestionService testMathQuestionServiceMocked;

    @Test
    public void removeQuestionArgTest() {
        Collection<Question> testQuestionCollection = randomQuestionSet(randomInt(20, 40));
        Question testQuestion = testQuestionCollection.iterator().next();
        when(questionRepositoryMock.getAll()).thenReturn(testQuestionCollection);
        when(questionRepositoryMock.remove(testQuestion)).thenReturn(testQuestion);
        assertEquals(testQuestion, testMathQuestionServiceMocked.remove(testQuestion));
        testQuestionCollection.remove(testQuestion);
        assertThrows(QuestionServiceException.class, () -> testMathQuestionServiceMocked.remove(testQuestion));
    }

    @Test
    public void removeStringArgsTest() {
        Collection<Question> testQuestionCollection = randomQuestionSet(randomInt(20, 40));
        Question testQuestion = testQuestionCollection.iterator().next();
        String testProblem = testQuestion.getProblem();
        String testAnswer = testQuestion.getAnswer();
        when(questionRepositoryMock.getAll()).thenReturn(testQuestionCollection);
        when(questionRepositoryMock.remove(testQuestion)).thenReturn(testQuestion);
        assertEquals(testQuestion, testMathQuestionServiceMocked.remove(testProblem, testAnswer));
        testQuestionCollection.remove(testQuestion);
        assertThrows(QuestionServiceException.class, () -> testMathQuestionServiceMocked.remove(testQuestion));
    }

    @Test
    public void getAllTest() {
        Collection<Question> testQuestionCollection = randomQuestionSet(randomInt(20, 40));
        when(questionRepositoryMock.getAll()).thenReturn(testQuestionCollection);
        assertEquals(testQuestionCollection, testMathQuestionServiceMocked.getAll());
    }

    @Test
    public void addStringArgs() {
        Collection<Question> testQuestionCollection = randomQuestionSet(randomInt(20, 40));
        Question testQuestion = testQuestionCollection.iterator().next();
        String testProblem = testQuestion.getProblem();
        String testAnswer = testQuestion.getAnswer();
        when(questionRepositoryMock.getAll()).thenReturn(testQuestionCollection);
        assertThrows(QuestionServiceException.class, () -> testMathQuestionServiceMocked.add(testProblem, testAnswer));
        testQuestionCollection.remove(testQuestion);
        when(questionRepositoryMock.add(testQuestion)).thenReturn(testQuestion);
        assertEquals(testQuestion, testMathQuestionServiceMocked.add(testProblem, testAnswer));
    }

    @Test
    public void addQuestionArg() {
        Collection<Question> testQuestionCollection = randomQuestionSet(randomInt(20, 40));
        Question testQuestion = testQuestionCollection.iterator().next();
        when(questionRepositoryMock.getAll()).thenReturn(testQuestionCollection);
        assertThrows(QuestionServiceException.class, () -> testMathQuestionServiceMocked.add(testQuestion));
        testQuestionCollection.remove(testQuestion);
        when(questionRepositoryMock.add(testQuestion)).thenReturn(testQuestion);
        assertEquals(testQuestion, testMathQuestionServiceMocked.add(testQuestion));
    }

}
