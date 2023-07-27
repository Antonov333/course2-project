package pro.sky.java.course2;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;

@Service
public class MathQuestionRepository implements QuestionRepository {

    private Collection<Question> questionCollection = new HashSet<>();

    MathQuestionRepository() {
    }

    MathQuestionRepository(Collection<Question> questionCollection) {
        this.questionCollection = questionCollection;
    }

    @Override
    public Question add(Question question) {
        checkQuestion(question);
        questionCollection.add(question);
        return question;
    }

    private void checkQuestion(Question question) {
        if (question == null || questionCollection.contains(question)) {
            throw new QuestionServiceException("question is null or already added");
        }
    }


    @Override
    public Question add(String problem, String answer) {
        Question question = new Question(problem, answer);
        return add(question);
    }

    @Override
    public Question remove(Question question) {
        if (!questionCollection.contains(question)) {
            throw new QuestionServiceException("question is missing");
        }
        questionCollection.remove(question);
        return question;
    }

    @Override
    public Question remove(String problem, String answer) {
        Question question = new Question(problem, answer);
        return remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        Collection<Question> questions = new HashSet<>();
        questions = questionCollection;
        return questions;
    }

    @PostConstruct
    public void loadMathQuestions() {
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

    @Override
    public String toString() {
        return "MathQuestionRepository{" +
                "questionCollection=" + questionCollection +
                '}';
    }
}
