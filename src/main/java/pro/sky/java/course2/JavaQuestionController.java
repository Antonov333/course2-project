package pro.sky.java.course2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path = "/exam/")
public class JavaQuestionController {
/*
1. Пользователь обращается к некому эндпоинту по адресу (”/exam/get/{amount}”)
2. Пользователь получает ответ в виде списка случайных вопросов-ответов, количество которых равно amount
из прошлого шага
3. Пользователь должен иметь возможность добавить, получить и удалить вопросы из хранилища вопросов
(”/exam/java/(add/remove/find)”)
 */

    private final QuestionService service;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService service) {
        this.service = service;
    }

    public Set<Question> getQuestionSet() {
        Set<Question> questionSet = (Set<Question>) service.getAll();
        return questionSet;
    }

    public QuestionService getJavaQuestions() {
        return service;
    }

    @GetMapping(path = "/java/add/")
    public Question add(@RequestParam(required = false, name = "problem") String problem,
                        @RequestParam(required = false, name = "answer") String answer) {
        return service.add(problem, answer);
    }

    @GetMapping(path = "/java/remove/")
    public Question remove(@RequestParam(required = false, name = "problem") String problem,
                           @RequestParam(required = false, name = "answer") String answer) {
        return service.remove(problem, answer);
    }

    @GetMapping(path = "/java/")
    public Set<Question> getAllQuestions() {
        return (Set<Question>) service.getAll();
    }

}
