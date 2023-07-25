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

    @PostConstruct
    public void loadMathQuestion() {
        add("First Fundamental Theorem Of Calculus",
                "for a function f , an antiderivative or indefinite integral F may be obtained as the integral of f over an interval with a variable upper bound. This implies the existence of antiderivatives for continuous functions");

        add("Second Fundamental Theorem Of Calculus",
                "integral of a function f over a fixed interval is equal to the change of any antiderivative F between the ends of the interval.");

        add("Fundamental Theorem Of Arithmetic",
                "every integer greater than 1 can be represented uniquely as a product of prime numbers, up to the order of the factors");

        add("Fundamental Theorem Of Algebra",
                "every non-constant single-variable polynomial with complex coefficients has at least one complex root");

        add("Pythagorean Theorem",
                "a² + b² = c² where c is the hypotenuse while a and b are the legs of the triangle");

        add("Isoperimetric Theorem A",
                "Among all planar regions with a given perimeter p, the circle encloses the greatest area");

        add("Fermat's Last Theorem",
                "If an integer n is greater than 2, then the equation a^n + b^n = c^n has no solutions in non-zero integers a, b, and c");

        add("Theorem (Law) Of Large Numbers (LlN)",
                "the average of the results obtained from a large number of trials should be close to the expected value and tends to become closer to the expected value as more trials are performed");

        add("Pythagorean Trigonometric Identity", "(sin x)^2 + (cos x)^2 = 1");

        add("Fermat's Little Theorem",
                "if p is a prime number, then for any integer a, the number {a^{p}-a} is an integer multiple of p");

    }
}