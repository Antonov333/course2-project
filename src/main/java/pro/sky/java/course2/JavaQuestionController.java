package pro.sky.java.course2;

import org.springframework.web.bind.annotation.*;

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

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    public Set<Question> getQuestionSet() {
        Set<Question> questionSet = javaQuestionService.getAll();
        return questionSet;
    }

    public JavaQuestionService getJavaQuestions() {
        return javaQuestionService;
    }

    @GetMapping(path = "/java/load/{amount}")
    public Set<Question> load(@PathVariable int amount) {
        javaQuestionService.addDummyQuestions(amount);
        return (Set<Question>) javaQuestionService.getQuestionStorage().getAll();
    }

    @GetMapping(path = "/java/add/")
    public Question add(@RequestParam(required = false, name = "problem") String problem,
                        @RequestParam(required = false, name = "answer") String answer) {
        return javaQuestionService.add(problem, answer);
    }

    @GetMapping(path = "/java/remove/")
    public Question remove(@RequestParam(required = false, name = "problem") String problem,
                           @RequestParam(required = false, name = "answer") String answer) {
        return javaQuestionService.remove(problem, answer);
    }

    @GetMapping(path = "/java/")
    public Set<Question> getAllQuestions() {
        return javaQuestionService.getAll();
    }

}
