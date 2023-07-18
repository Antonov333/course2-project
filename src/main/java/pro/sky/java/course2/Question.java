package pro.sky.java.course2;

import java.util.Objects;

public class Question {
    private String problem;
    private String answer;

    public Question() {
    }

    public Question(String problem, String answer) {
        this.problem = problem;
        this.answer = answer;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(problem, question.problem) && Objects.equals(answer, question.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(problem, answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "problem='" + problem + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
