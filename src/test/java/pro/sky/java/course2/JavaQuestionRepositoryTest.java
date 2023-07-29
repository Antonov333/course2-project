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
    public void addTest() {
        Collection<Question> testQuestionCollection = randomQuestionSet(randomInt(10, 50));
        JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository(testQuestionCollection);
        Question testQuestion;
        do {
            testQuestion = randomQuestion();
        }
        while (testQuestionCollection.contains(testQuestionCollection));
        assertFalse(javaQuestionRepository.getAll().contains(testQuestion));
        assertEquals(testQuestion, javaQuestionRepository.add(testQuestion));
        Question finalTestQuestion = testQuestion;
        assertThrows(QuestionServiceException.class, () -> javaQuestionRepository.add(finalTestQuestion));

    }

}
