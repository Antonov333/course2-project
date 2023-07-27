package pro.sky.java.course2;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);

    Collection<Question> getJavaQuestions(int amount);

    Collection<Question> getMathQuestion(int amount);
}
