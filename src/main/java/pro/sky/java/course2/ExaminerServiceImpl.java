package pro.sky.java.course2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static pro.sky.java.course2.Randoms.randomInt;

@Service
@Scope(scopeName = "singleton")
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {

        int javaQuestionsQty = javaQuestionService.getAll().size();
        int mathQuestionsQty = mathQuestionService.getAll().size();

        if (amount > javaQuestionsQty) {
            throw new QuestionServiceException("not enough Java questions");
        }

        if (amount > mathQuestionsQty) {
            throw new QuestionServiceException("not enough Math questions");
        }

        Set<Question> questions = new HashSet<Question>();

        Question nextQuestion = new Question();
        int javaQuizAmount = randomInt(0, amount);

        int i = 1;
        for (; i <= javaQuizAmount; i++) {
            do {
                nextQuestion = javaQuestionService.getRandomQuestion();
            } while (questions.contains(nextQuestion));
            questions.add(nextQuestion);
        }

        for (; i <= amount; i++) {
            do {
                nextQuestion = mathQuestionService.getRandomQuestion();
            } while (questions.contains(nextQuestion));
            questions.add(nextQuestion);
        }

        return questions;
    }

    @Override
    public Collection<Question> getJavaQuestions(int amount) {
        return null;
    }

    @Override
    public Collection<Question> getMathQuestion(int amount) {
        return null;
    }
}
