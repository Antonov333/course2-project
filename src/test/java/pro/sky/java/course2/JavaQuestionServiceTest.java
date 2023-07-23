package pro.sky.java.course2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    Question questionMock;

    @InjectMocks
    JavaQuestionService javaQuestionServiceMocked;

    @Test
    public void JavaQuestionTest() {
        Set<Question> questionSet = new HashSet<>();
        Question question1 = new Question("Java Test Question #1", "Java Test Answer #1");
        questionSet.add(question1);
        JavaQuestionService javaQuestionService = new JavaQuestionService(questionSet);
        assertEquals(questionSet, javaQuestionService.getQuestionSet());
    }

    @Test
    public void JavaQuestionNoArgsTest() {
        Set<Question> questionSet = new HashSet<>();
        Set<Question> emptyQuestionSet = new HashSet<>();
        Question question1 = new Question("Java Test Question #1", "Java Test Answer #1");
        questionSet.add(question1);
        JavaQuestionService javaQuestionService = new JavaQuestionService();
        assertEquals(emptyQuestionSet, javaQuestionService.getQuestionSet());
    }

    @Test
    public void removeTest() {
        Question question1 = new Question("Java Test Question #1", "Java Test Answer #1");
        Question question2 = new Question("Java Test Question #2", "Java Test Answer #2");
        Set<Question> questionSet = new HashSet<>(Arrays.asList(question1, question2));
        JavaQuestionService javaQuestionService = new JavaQuestionService();
        javaQuestionService.setQuestionSet(questionSet);
        assertEquals(questionSet, javaQuestionService.getQuestionSet());
        assertEquals(question2, javaQuestionService.remove(question2));
        assertThrows(QuestionServiceException.class, () -> javaQuestionService.remove(question2));
    }

    @Test
    public void getAllTest() {

    }
}
