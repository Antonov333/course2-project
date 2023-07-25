package pro.sky.java.course2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Scope(scopeName = "singleton")
public class JavaQuestionService implements QuestionService {

    private Set<Question> questionSet = new HashSet<>();

    public JavaQuestionService(Set<Question> questionSet) {
        this.questionSet = questionSet;
    }

    public JavaQuestionService() {
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

    @Override
    public Question add(String problem, String answer) {
        return add(new Question(problem, answer));
    }

    @Override
    public Question add(Question question) {
        if (questionSet.add(question)) {
            return question;
        } else {
            throw new QuestionServiceException("Question already added");
        }
    }

    public Question remove(String problem,
                           String answer) {
        Question question = new Question(problem, answer);
        return remove(question);
    }

    public int getQtyOfNumbers() {
        if (questionSet == null) {
            return -1;
        }
        return questionSet.size();
    }

    public Set<Question> loadJavaQuestions() {
        Set javaQuestions = new HashSet<>( // https://www.javatpoint.com/corejava-interview-questions
//                              https://www.softwaretestinghelp.com/core-java-interview-questions/
                Arrays.asList(
                        new Question("Q #1) What is JAVA?", "Java is a high-level programming language and is platform-independent.\n" +
                                "Java is a collection of objects. It was developed by Sun Microsystems. There are a lot of applications, websites, and games that are developed using Java."),
                        new Question("Q #2) What are the features of JAVA?", "Features of Java are as follows:\n" +
                                "OOP concepts\n" +
                                "Object-oriented\n" +
                                "Inheritance\n" +
                                "Encapsulation\n" +
                                "Polymorphism\n" +
                                "Abstraction\n" +
                                "Platform independent: A single program works on different platforms without any modification.\n" +
                                "High Performance: JIT (Just In Time compiler) enables high performance in Java. JIT converts the bytecode into machine language and then JVM starts the execution.\n" +
                                "Multi-threaded: A flow of execution is known as a Thread. JVM creates a thread which is called the main thread. The user can create multiple threads by extending the thread class or by implementing the Runnable interface."),
                        new Question(
                                "Q",
                                "A"
                        )
                ));
        return javaQuestions;
    }

    public void addDummyQuestions(int amount) {
        int oldSize = getQtyOfNumbers();
        for (int i = oldSize + 1; i <= oldSize + amount; i++) {
            add(new Question("Java question #" + i, "Java answer #" + i));
        }
    }
}