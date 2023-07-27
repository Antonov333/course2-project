package pro.sky.java.course2.exam;

import pro.sky.java.course2.question.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);

}
