package is.hi.quiz.Controllers;

import is.hi.quiz.Persistance.Entities.Account;
import is.hi.quiz.Persistance.Entities.Question;
import is.hi.quiz.Services.AccountService;
import is.hi.quiz.Services.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AccountController {
    AccountService accountService;
    QuizService quizService;

    public AccountController(AccountService accountService, QuizService quizService) {
        this.accountService = accountService;
        this.quizService = quizService;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signupGET(Account account){
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPOST(Account account, BindingResult result, Model model){
        if(result.hasErrors()){
            return "redirect:/signup";
        }
        Account exists = accountService.findByUsername(account.getUsername());
        if(exists == null){
            accountService.save(account);
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(Account account){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(Account account, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            return "login";
        }
        Account exists = accountService.login(account);
        List<Question> allQuestions = quizService.findAll();
        if(exists != null){
            session.setAttribute("LoggedInUser", exists);
            model.addAttribute("LoggedInUser",exists);
            model.addAttribute("questions",allQuestions);
            if(exists.isAdmin()){
                //model.addAttribute("admin",exists);
                return "redirect:/admin";
            }
            else return "LoggedInUser";
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
        public String adminPage(Model model, Account account){
        List <Question> questions = quizService.findAll();
        model.addAttribute("questions",questions);
        return "admin";
    }

    @RequestMapping("/")
    public String AccountController(){
        // Model of class structure that allows to insert data into templates and http session
        // Busniess logic
        // Add some data to the model
        // Call a method in service class
        return "home";
    }


}
