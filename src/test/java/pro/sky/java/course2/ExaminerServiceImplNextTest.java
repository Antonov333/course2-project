package pro.sky.java.course2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.exam.ExaminerServiceImplNext;
import pro.sky.java.course2.javaquiz.JavaQuestionRepository;
import pro.sky.java.course2.javaquiz.JavaQuestionService;
import pro.sky.java.course2.mathquiz.MathQuestionRepository;
import pro.sky.java.course2.mathquiz.MathQuestionService;
import pro.sky.java.course2.question.Question;
import pro.sky.java.course2.utils.Randoms;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pro.sky.java.course2.utils.Randoms.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplNextTest {

    @Test
    public void qetQuestionsTest() {
        int amount = randomInt(1, 10);
        int javaQty = randomInt(10 * amount, 20 * amount);
        int mathQty = randomInt(10 * amount, 20 * amount);

        Collection<Question> javaQuestionSet = randomQuestionSet(javaQty);
        Collection<Question> mathQuestionSet = randomQuestionSet(mathQty);

        ExaminerServiceImplNext testExaminerServiceImplNext =
                new ExaminerServiceImplNext(
                        new JavaQuestionService(new JavaQuestionRepository(javaQuestionSet)),
                        new MathQuestionService(new MathQuestionRepository(mathQuestionSet)));

        Collection<Question> allQuestions = new HashSet<>();
        allQuestions.addAll(javaQuestionSet);
        allQuestions.addAll(mathQuestionSet);

        Collection<Question> testCollection = testExaminerServiceImplNext.getQuestions(amount);
        assertEquals(amount, testCollection.size());
        assertTrue(allQuestions.containsAll(testCollection));
    }
}
