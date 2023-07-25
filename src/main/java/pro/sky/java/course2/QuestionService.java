package pro.sky.java.course2;

import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;

public interface QuestionService {

    Question add(String problem, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

}
