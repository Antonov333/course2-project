package pro.sky.java.course2;

import java.util.Collection;
import java.util.Set;

public class JavaQuestionService implements QuestionService {

    private Set<Question> questionSet;

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
    public Question add(String problem, String answer) {
        return null;
    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}
