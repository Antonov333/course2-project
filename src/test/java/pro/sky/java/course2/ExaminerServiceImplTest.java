package pro.sky.java.course2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.exam.ExaminerServiceImpl;
import pro.sky.java.course2.javaquiz.JavaQuestionService;
import pro.sky.java.course2.question.QuestionServiceException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {


    @Mock
    JavaQuestionService javaQuestionServiceMock;

    @Test
    public void getQuestionsTest() {
        ExaminerServiceImpl examinerServiceImpl = new ExaminerServiceImpl(javaQuestionServiceMock, javaQuestionService, mathQuestionService);
        int questionQtyForMock = 3;
        when(javaQuestionServiceMock.getQtyOfNumbers()).thenReturn(questionQtyForMock);
        Assertions.assertThrows(QuestionServiceException.class, () -> examinerServiceImpl.getQuestions(questionQtyForMock + 1));

        /*HashSet<Question> testQuestionSetFull =
                randomQuestionSet(questionQtyForMock * randomInt(20, 30));

        Set<Question> questionsForMock = randomQuestionSet(questionQtyForMock);

        testQuestionSetFull.addAll(questionsForMock);

        System.out.println("questionsForMock = " + questionsForMock);

        System.out.println("testQuestionSetFull = " + testQuestionSetFull);

        Iterator<Question> questionIterator = questionsForMock.iterator();

     when(javaQuestionServiceMock.getAll()).thenReturn(testQuestionSetFull);
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(questionIterator.next());
        when(javaQuestionServiceMock.getQtyOfNumbers()).thenReturn(testQuestionSetFull.size());

        Set<Question> actualQuestionSet =  examinerServiceImpl.getQuestions(questionQtyForMock) ;

        System.out.println("questionQtyForMock = " + questionQtyForMock);
        System.out.println("questionsForMock = " + questionsForMock);

        System.out.println(actualQuestionSet);

        assertEquals(questionsForMock,actualQuestionSet); */

    }


}
