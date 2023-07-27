package pro.sky.java.course2.javaquiz;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.question.Question;
import pro.sky.java.course2.question.QuestionRepository;
import pro.sky.java.course2.question.QuestionService;

import java.util.*;

@Service
@Scope(scopeName = "singleton")
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository questionStorage;

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionStorage) {
        this.questionStorage = questionStorage;
    }

    public QuestionRepository getQuestionStorage() {
        return questionStorage;
    }

    @Override
    public Question remove(Question question) {
        return questionStorage.remove(question);
    }

    @Override
    public Set<Question> getAll() {
        Set<Question> q = (Set<Question>) questionStorage.getAll();
        return q;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>((Collection) questionStorage.getAll());
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

    @Override
    public Question add(String problem, String answer) {
        return questionStorage.add(new Question(problem, answer));
    }

    @Override
    public Question add(Question question) {
        return questionStorage.add(question);
    }

    public Question remove(String problem,
                           String answer) {
        return questionStorage.remove(problem, answer);
    }

    public int getQtyOfNumbers() {
        if (questionStorage == null) {
            return -1;
        }
        return questionStorage.getAll().size();
    }

    public void addDummyQuestions(int amount) {
        int oldSize = getQtyOfNumbers();
        for (int i = oldSize + 1; i <= oldSize + amount; i++) {
            add(new Question("Java question #" + i, "Java answer #" + i));
        }
    }
}