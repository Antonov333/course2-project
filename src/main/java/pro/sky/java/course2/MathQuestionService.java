package pro.sky.java.course2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@Scope(scopeName = "singleton")
public class MathQuestionService implements QuestionService {

    private Set<Question> questionSet = new HashSet<>();

    public MathQuestionService(Set<Question> questionSet) {
        this.questionSet = questionSet;
    }

    public MathQuestionService() {
    }

    public Set<Question> getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(Set<Question> questionSet) {
        this.questionSet = questionSet;
    }

    @PostConstruct
    public void init() {
        System.out.println("MathQuestionService init started");
    }

    @Override
    public Question remove(Question question) {
        if (questionSet.remove(question)) {
            return question;
        } else {
            throw new QuestionServiceException("Question missing");
        }
    }

    @Override
    public Set<Question> getAll() {
        Set<Question> q = questionSet;
        return q;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(questionSet);
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
        if (questionSet.add(question)) {
            return question;
        } else {
            throw new RuntimeException("Question already added");
        }
    }

    public Question removeQuestion(String problem,
                                   String answer) {
        Question question = new Question(problem, answer);
        return remove(question);
    }

    public void addDummyQuestions(int amount) {
        int oldSize = getAll().size();
        for (int i = oldSize + 1; i <= oldSize + amount; i++) {
            add(new Question("Math question #" + i, "Math answer #" + i));
        }
    }
}