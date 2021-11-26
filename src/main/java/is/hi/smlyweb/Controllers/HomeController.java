package is.hi.smlyweb.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


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
        return "about";
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
