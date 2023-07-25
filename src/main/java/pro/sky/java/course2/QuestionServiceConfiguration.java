package pro.sky.java.course2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class QuestionServiceConfiguration {


    JavaQuestionService javaQuestionServiceBean() {
        return new JavaQuestionService();
    }

    MathQuestionService mathQuestionService() {
        return new MathQuestionService();
    }
}
