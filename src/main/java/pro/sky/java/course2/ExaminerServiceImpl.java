package pro.sky.java.course2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Scope(scopeName = "singleton")
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    public QuestionService getJavaQuestionService() {
        return javaQuestionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {

        int questionsQty = javaQuestionService.getQtyOfNumbers();

        if (amount > questionsQty) {
            throw new QuestionServiceException("not enough questions");
        }

        Set<Question> questions = new HashSet<Question>();

        if (amount == questionsQty) {
            questions = javaQuestionService.getAll();
            return questions;
        }
        Question nextQuestion = new Question();
        for (int i = 1; i <= amount; i++) {
            do {
                nextQuestion = javaQuestionService.getRandomQuestion();
            } while (questions.contains(nextQuestion));
            questions.add(nextQuestion);
        }
        return questions;
    }
}
