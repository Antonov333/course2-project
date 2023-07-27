package pro.sky.java.course2;

import org.junit.jupiter.api.Test;

public class JavaQuestionRepositoryTest {

    @Test
    public void test1() {
        JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository();
        System.out.println(javaQuestionRepository.getAll());
    }
}
