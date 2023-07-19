package pro.sky.java.course2;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/exam/")
public class JavaController {
/*
1. Пользователь обращается к некому эндпоинту по адресу (”/exam/get/{amount}”)
2. Пользователь получает ответ в виде списка случайных вопросов-ответов, количество которых равно amount
из прошлого шага
3. Пользователь должен иметь возможность добавить, получить и удалить вопросы из хранилища вопросов
(”/exam/java/(add/remove/find)”)
 */

    Set<Question> questionSet = new HashSet<>();

    JavaQuestionService javaQuestions = new JavaQuestionService(questionSet);

    @GetMapping(path = "/get/{amount}")
    public List<Question> get(@PathVariable int amount) {
        return javaQuestions.getQuestions(amount);
    }

    @GetMapping(path = "/java/load/{amount}")
    public Set<Question> load(@PathVariable int amount) {
        Set<Question> questions = JavaQuestionService.dummyQuestionGenerator("Java", amount);
        javaQuestions.setQuestionSet(questions);
        return questions;
    }

    @GetMapping(path = "/java/add/")
    public Question add(@RequestParam(required = false, name = "problem") String problem,
                        @RequestParam(required = false, name = "answer") String answer) {
        return javaQuestions.add(problem, answer);
    }

    @GetMapping(path = "/java/remove/")
    public Question remove(@RequestParam(required = false, name = "problem") String problem,
                           @RequestParam(required = false, name = "answer") String answer) {
        return javaQuestions.removeQuestion(problem, answer);
    }

    @GetMapping(path = "/java/")
    public Set<Question> getAllQuestions() {
        return javaQuestions.getAll();
    }

}
