package pro.sky.java.course2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path = "/exam/")
public class MathQuestionController {

    private final MathQuestionService mathQuestionService;

    MathQuestionController(MathQuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping(path = "/math/")
    Set<Question> getAll() {
        return mathQuestionService.getAll();
    }
}
