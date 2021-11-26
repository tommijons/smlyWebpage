package is.hi.smlyweb.Controllers;
import is.hi.smlyweb.Persistance.Entities.*;
import is.hi.smlyweb.Services.AccountService;
import is.hi.smlyweb.Services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import is.hi.smlyweb.Services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {
    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }


    @GetMapping("/quiz")
    public String style(){
        System.out.println("QUESTION: "+quizService.findAll().get(0).getQuestionText());
        return "quiz";
    }
}
