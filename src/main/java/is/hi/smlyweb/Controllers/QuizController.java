package is.hi.smlyweb.Controllers;
import is.hi.smlyweb.Persistance.Entities.*;
import is.hi.smlyweb.Services.QuizService;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {
    private QuizService quizService;
    private StopWatch stopWatch =new StopWatch();
    public int counter=0;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
        stopWatch.start();
    }


    @GetMapping("/quiz")
    public String getQuestions(Model model,Scores scores){
        // Security dót sov það sé ekki hægt setja allt í input
        //String safe = Jsoup.clean(unsafe, Whitelist.basic());

        if(quizService.getNoOfQuestions()==0)quizService.resetAnswers();
        Question nextQuestion;
        int score=quizService.getScore();
        nextQuestion = getNextQuestion();

        // One player answer lists to be displayed for one player game
        List<String>correctAnswers =quizService.getCorrectAnswers();
        List<String>answers =quizService.getAnswers();
        System.out.println(stopWatch.getTime(TimeUnit.SECONDS));
        // Make lists for the correct questions to their answered to be matched in thymeleaf
        List<Question> questions = quizService.findAll();
        model.addAttribute("questions",nextQuestion);
        model.addAttribute("counter",counter);
        model.addAttribute("userscore",score);
        model.addAttribute("answers",answers);
        model.addAttribute("correctanswers",correctAnswers);
        model.addAttribute("time",stopWatch.getTime(TimeUnit.SECONDS));
        return "quiz";
    }

    // Helper function to check if answer is correct and adds scores and statistics
    @RequestMapping(value="/quiz",method=RequestMethod.POST)
    public String checkAnswer(@RequestParam(value = "option", required = false) String option,Question question, BindingResult result,Model model,Scores scores){
        List<Question> allQuestions = quizService.findAll();
        String questionAnswer = allQuestions.get(quizService.getNoOfQuestions()).getCorrectAnswer();
        quizService.addAnswer(option, questionAnswer);
        if(questionAnswer.equals(option)){
                quizService.addScore(100);
        }
        quizService.incrementNoOfQuestion();
        return"redirect:/quiz";
    }

    // Helper function to get next question when button is clicked and keeps count of questions.
    // Param is the id of chosen category.
    // Returns: A question object
    public Question getNextQuestion(){
        List<Question> allQuestions = quizService.findAll();
        if(quizService.getNoOfQuestions()< allQuestions.size()){
            Question question = allQuestions.get(quizService.getNoOfQuestions());
            // Increment to get next question

            counter=allQuestions.indexOf(question)+1;
            return question;
        }
        quizService.resetNoOfQuestions();
        quizService.resetScore();
        stopWatch.stop();
        return null;
    }

    @RequestMapping(value = "/scores", method = RequestMethod.GET)
    public String scores(Scores scores, Model model){
        model.addAttribute("scores",quizService.findAllScores());
        return "scores";
    }

    @RequestMapping(value="/scores",method=RequestMethod.POST)
    public String postResults(Scores scores, BindingResult result, Model model){
        if(result.hasErrors()){
            return "redirect:/";
        }
        if(!scores.getUsername().isEmpty())quizService.saveScores(scores);

        return "redirect:/scores";
    }
}
