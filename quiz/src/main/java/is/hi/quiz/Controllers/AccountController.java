package is.hi.quiz.Controllers;

import is.hi.quiz.Persistance.Entities.Account;
import is.hi.quiz.Services.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class AccountController {
    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
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
        //for(Account a:accountService.findAll())System.out.println(a.username+a.password);
        if(result.hasErrors()){
            return "login";
        }
        Account exists = accountService.login(account);
        //System.out.println(exists);
        if(exists != null){
            session.setAttribute("LoggedInUser", exists);
            model.addAttribute("LoggedInUser", exists);
            return "LoggedInUser";
        }
        return "redirect:/";
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
