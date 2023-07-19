package pro.sky.java.course2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path = "/exam/")
public class ExamController {

    private ExaminerService examinerService;

    @GetMapping(path = "/get/{amount}")
    Set<Question> getQuestions(@PathVariable int amount) {
        examinerService.getQuestions(amount);
    }
}
