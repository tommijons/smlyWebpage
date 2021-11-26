package is.hi.smlyweb.Services.Implementation;

import is.hi.smlyweb.Persistance.Entities.*;
import is.hi.smlyweb.Persistance.Repository.QuizRepository;
import is.hi.smlyweb.Persistance.Repository.ScoreRepository;
import is.hi.smlyweb.Services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImplementation implements QuizService {
    private QuizRepository quizRepository;
    private ScoreRepository scoreRepository;
    private int noOfQuestions = 0;
    private int score=0;
    private List<String> answers = new ArrayList<>();
    private List<String> correctAnswers= new ArrayList<>();

    @Autowired
    public QuizServiceImplementation(QuizRepository quizRepository, ScoreRepository scoreRepository) {
        this.quizRepository = quizRepository;
        this.scoreRepository = scoreRepository;
    }

    @Override
    public List<Question> findAll() {
        return quizRepository.findAll();
    }
/*
    @Override
    public Question findById(long ID) {
        return null;
    }

    @Override
    public Question save(Question question) {
        return null;
    }

    @Override
    public void delete(Question question) {

    }

    @Override
    public List<Scores> findByAccountID(long accountID) {
        return null;
    }

    @Override
    public Scores saveScores(Scores scores) {
        return null;
    }

    @Override
    public List<Scores> findAllScores() {
        return null;
    }*/
}
