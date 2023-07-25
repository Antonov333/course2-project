package pro.sky.java.course2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Scope(scopeName = "singleton")
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(@Qualifier(value = "mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    public QuestionService getQuestionService() {
        return questionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {

        int questionsQty = questionService.getAll().size();

        if (amount > questionsQty) {
            throw new QuestionServiceException("not enough questions");
        }

        Set<Question> questions = new HashSet<Question>();

        if (amount == questionsQty) {
            questions = (Set<Question>) questionService.getAll();
            return questions;
        }
        Question nextQuestion = new Question();
        for (int i = 1; i <= amount; i++) {
            do {
                nextQuestion = questionService.getRandomQuestion();
            } while (questions.contains(nextQuestion));
            questions.add(nextQuestion);
        }
        return questions;
    }
}
