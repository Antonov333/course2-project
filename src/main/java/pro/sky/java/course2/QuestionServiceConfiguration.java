package pro.sky.java.course2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class QuestionServiceConfiguration {

    JavaQuestionRepository javaQuestionRepository() {
        return new JavaQuestionRepository();
    }

}
