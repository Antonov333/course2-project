package pro.sky.java.course2;

import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
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

/* private final TrayService trayService;

    public TrayController(TrayService trayService) {
        this.trayService = trayService;
    } */

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    public Set<Question> getQuestionSet() {
        Set<Question> questionSet = javaQuestionService.getQuestionSet();
        return questionSet;
    }

    public JavaQuestionService getJavaQuestions() {
        return javaQuestionService;
    }

    @GetMapping(path = "/java/load/{amount}")
    public Set<Question> load(@PathVariable int amount) {
        javaQuestionService.addDummyQuestions(amount);
        return javaQuestionService.getQuestionSet();
    }

    @GetMapping(path = "/java/add/")
    public Question add(@RequestParam(required = false, name = "problem") String problem,
                        @RequestParam(required = false, name = "answer") String answer) {
        return javaQuestionService.add(problem, answer);
    }

    @GetMapping(path = "/java/remove/")
    public Question remove(@RequestParam(required = false, name = "problem") String problem,
                           @RequestParam(required = false, name = "answer") String answer) {
        return javaQuestionService.removeQuestion(problem, answer);
    }

    @GetMapping(path = "/java/")
    public Set<Question> getAllQuestions() {
        return javaQuestionService.getAll();
    }

}
