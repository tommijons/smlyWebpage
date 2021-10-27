package is.hi.quiz.Controllers;

import is.hi.quiz.Services.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {
    private QuizService quizService;


    @RequestMapping("/")
    public String AccountController(){
        // Model of class structure that allows to insert data into templates and http session
        // Busniess logic
        // Add some data to the model
        // Call a method in service class
        return "home";
    }


}
