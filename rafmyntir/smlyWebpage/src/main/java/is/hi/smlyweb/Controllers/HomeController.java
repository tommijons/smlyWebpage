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
    QuizService qs;
    @Autowired
    public HomeController(QuizService qs) {
        this.qs=qs;
    }

    @GetMapping("/")
    public String home(){
        qs.resetNoOfQuestions();
        return "home";
    }

    @GetMapping("/about")
    public String about(){
        qs.resetNoOfQuestions();
        return "about";
    }

    @GetMapping("/basics")
    public String basics(){
        qs.resetNoOfQuestions();
        return "basics";
    }

    @GetMapping("/related")
    public String related(){
        qs.resetNoOfQuestions();
        return "related";
    }

    @GetMapping("/team")
    public String team(){
        qs.resetNoOfQuestions();
        return "team";
    }
    @GetMapping("/basics/transaction")
    public String transaction(){
        return "transaction";
    }
    @GetMapping("/basics/multisig")
    public String multisig(){
        return "multisig";
    }
    @GetMapping("/basics/blockchain")
    public String blockchain(){
        return "blockchain";
    }
    @GetMapping("/basics/command-line-wallet")
    public String commandLineWallet(){
        return "commandLineWallet";
    }
    @GetMapping("/basics/wallet")
    public String wallet(){
        return "basics";
    }

    @GetMapping("/donate")
    public String donate(){
        qs.resetNoOfQuestions();
        return "donate";
    }
}
