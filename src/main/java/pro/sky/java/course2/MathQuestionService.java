package pro.sky.java.course2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Scope(scopeName = "singleton")
public class MathQuestionService implements QuestionService {

    private final QuestionRepository questionStorage;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questionStorage) {
        this.questionStorage = questionStorage;
    }

    @Override
    public Question remove(Question question) {
        if (questionStorage.getAll().contains(question)) {
            return questionStorage.remove(question);
        } else {
            throw new QuestionServiceException("Question missing");
        }
    }

    @Override
    public Question remove(String problem, String answer) {
        return remove(new Question(problem, answer));
    }

    @Override
    public Set<Question> getAll() {
        Set<Question> q = (Set<Question>) questionStorage.getAll();
        return q;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(questionStorage.getAll());
        Question question = new Question();
        int index = randomInt(0, list.size() - 1);
        return list.get(index);
    }

    private Random random() {
        return new Random();
    }

    private int randomInt(int a, int b) {
        return random().nextInt(a, b);
    }

    public List<Question> getQuestions(int amount) {
        return null;
    }

    @Override
    public Question add(String problem, String answer) {
        return add(new Question(problem, answer));
    }

    @Override
    public Question add(Question question) {
        if (!questionStorage.getAll().contains(question)) {
            return questionStorage.add(question);
        } else {
            throw new RuntimeException("Question already added");
        }
    }
}