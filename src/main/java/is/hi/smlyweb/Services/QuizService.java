package is.hi.smlyweb.Services;

import is.hi.smlyweb.Persistance.Entities.*;
import is.hi.smlyweb.Persistance.Entities.Question;
import is.hi.smlyweb.Persistance.Entities.Scores;

import java.util.List;

public interface QuizService {
    // Question Stuff
    List<Question> findAll();
    Question save(Question question);
   /* Question findById(long ID);*/

    //void delete(Question question);

     // Question helper stuff
    int getNoOfQuestions();
    int resetNoOfQuestions();
    int incrementNoOfQuestion();
    //int resetScore();
    int addScore(int score);
    int getScore();
    void addAnswer(String answer, String correctAns);
    void resetAnswers();
    List<String> getAnswers();
    List<String> getCorrectAnswers();

    List <Scores> findAllScores();
    int resetScore();
    Scores saveScores(Scores scores);

}
