package is.hi.quiz.Controllers;

import is.hi.quiz.Persistance.Entities.Question;
import is.hi.quiz.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import is.hi.quiz.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class QuizController {

    private QuestionService questionService;
    int i=0;

    @Autowired
    public QuizController(QuestionService questionService){
        this.questionService = questionService;
    }

    @RequestMapping("/")
    public String AccountController(Model model){
        // Model of class structure that allows to insert data into templates and http session
        // Business logic
       //List<Question> allQuestions = questionService.findAll();
        Question nextQuestion;
     //  if(getNextQuestion()!=null) {
           // Call a method in service class
           // Add some data to the model
           nextQuestion = getNextQuestion();
           model.addAttribute("questions", nextQuestion);
           return "displayQuestions";
     //  }
       //return "home";
    }
    //@RequestMapping(value="/nextQuestion",method = RequestMethod.GET)
    // Handles the questions, displays next question when one of the answer buttons is clicked.
    public Question getNextQuestion(){
        List<Question> allQuestions = questionService.findByCategory( 2);
        if(i < allQuestions.size()){
            Question question = allQuestions.get(i);
            // Increment to get next question
            i++;
            return question;
        }
      return null;
    }
    @RequestMapping(value="/addquestion",method=RequestMethod.GET)
    public String addQuestion(Question question){
        return "newQuestion";
    }
    @RequestMapping(value="/addquestion",method=RequestMethod.POST)
        public String addQuestion(Question question, BindingResult result,Model model){
        if(result.hasErrors()){
            return "newQuestion";
        }
        questionService.save(question);
        return "redirect:/";
    }

    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public String deleteQuestion(@PathVariable("id")long id,Model model){
        Question questionToDelete = questionService.findById(id);
        questionService.delete(questionToDelete);
        return "redirect:/";
    }
}
