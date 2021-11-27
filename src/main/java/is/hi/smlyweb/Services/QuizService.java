package is.hi.smlyweb.Services;

import is.hi.smlyweb.Persistance.Entities.*;
import is.hi.smlyweb.Persistance.Entities.Question;
import is.hi.smlyweb.Persistance.Entities.Scores;

import java.util.List;

public interface QuizService {
    // Question Stuff
    List<Question> findAll();
    Question save(Question question);
    int incrementNoOfQuestion();
    int getNoOfQuestions();
   /* Question findById(long ID);

    void delete(Question question);


    // Scores
    List <Scores> findByAccountID(long accountID);
    Scores saveScores(Scores scores);
    List <Scores> findAllScores();*/


}
