package is.hi.smlyweb.Controllers;

import is.hi.smlyweb.Persistance.Entities.Scores;
import is.hi.smlyweb.Services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
    @Autowired
    public HomeController() {
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/basics")
    public String basics(){
        return "basics";
    }

    @GetMapping("/related")
    public String related(){
        return "related";
    }

    @GetMapping("/team")
    public String team(){
        return "team";
    }





}
