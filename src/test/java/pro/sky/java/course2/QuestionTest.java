package pro.sky.java.course2;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.question.Question;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class QuestionTest {

    @Test
    public void equalsTest() {
        Question question = new Question("problem", "answer");
        Question sameQuestion = new Question("problem", "same answer");
        Question differentQuestion = new Question("another problem", "answer");
        assertEquals(question, sameQuestion);
        assertNotEquals(question, differentQuestion);
    }

}
