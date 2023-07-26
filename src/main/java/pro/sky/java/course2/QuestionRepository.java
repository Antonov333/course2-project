package pro.sky.java.course2;

import java.util.Collection;

public interface QuestionRepository {

    // QuestionRepository с методами add, remove и getAll

    Question add(Question question);

    Question add(String problem, String answer);

    Question remove(Question question);

    Question remove(String problem, String answer);

    Collection<Question> getAll();

}
