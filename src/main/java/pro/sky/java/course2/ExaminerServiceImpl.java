package pro.sky.java.course2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExaminerServiceImpl implements ExaminerService {

    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public QuestionService getQuestionService() {
        return questionService;
    }

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {

        int questionsQty = questionService.getAll().size();

        if (amount > questionsQty) {
            throw new QuestionServiceException("not enough questions");
        }

        Collection<Question> questions = new HashSet<Question>();

        if (amount == questionsQty) {
            questions = (Set<Question>) questionService.getAll();
            return (Set<Question>) questions;
        }

        for (int i = 1; i <= amount; i++) {
            Question nextQuestion = new Question();
            do {
                nextQuestion = questionService.getRandomQuestion();
            }
            while (questions.contains(nextQuestion));
            questions.add(questionService.getRandomQuestion());
        }

        return (Set<Question>) questions;
    }
}
