package is.hi.quiz.Controllers;

import is.hi.quiz.Persistance.Entities.Category;
import is.hi.quiz.Persistance.Entities.Question;
import is.hi.quiz.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class GameStateController {
    private QuestionService questionService;
    public int noOfQuestions;

    @Autowired
    public GameStateController(QuestionService questionService){
        this.questionService = questionService;
    }

    // Lists available categories for the quiz
    // Returns: Template for category page
    @RequestMapping("/")
    public String AccountController(Model model){
        noOfQuestions=0;
        List<Category> allCategories = questionService.findAllCategories();
        model.addAttribute("categories", allCategories);
        return "home";
    }

    // Todo: Show high scores
    // Todo: Check for 1 or 2 player game
}
