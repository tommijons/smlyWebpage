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
        quizRepository.save(new Question(0, "What is a Smileycoin Wallet","A software that can receive and send Smileycoin transactions and store your private keys","It`s a flash drive with a special key on it","A software that can receive and send Smileycoin transactions and store your private keys","It`s a Smileycoin address","A database of all transactions made to your address"));
        quizRepository.save(new Question(0, "What is a Smileycoin address?","A string consisting of latin letters and numbers, which is used to receive funds into your Smileycoin wallet","A string consisting of latin letters and numbers, which is used to receive funds into your Smileycoin wallet","A unique identifier of a Smileycoin user in the system","A synonym for wallet","A synonym for transaction"));
        quizRepository.save(new Question(0, "What is a private key?","A string of letters and numbers, which is used to sign transactions that spend bitcoins in your wallet","Password to your wallet","A synonym for address","A string of letters and numbers, which is used to sign transactions that spend bitcoins in your wallet","Same as the public key"));
        quizRepository.save(new Question(0, "What is a transaction?","A message later written onto the Smileycoin blockchain that specifies the amounts being sent from a certain address(es) to another","A message later written onto the Smileycoin blockchain that specifies the amounts being sent from a certain address(es) to another","A transfer of funds into your bank account when you sell Smileycoin","A synonym to address","A group of addresses"));
        quizRepository.save(new Question(0, "What is a block?","It's a bunch of cryptographically verified transactions, bundled together and written on the blockchain","Newly mined smileycoins","A confirmation issued every 10 minutes by smileycoin miners, stating all recent transactions are valid","A Smileycoin transaction that has more than 1MB of data in it","It's a bunch of cryptographically verified transactions, bundled together and written on the blockchain"));
        quizRepository.save(new Question(0, "When is a Smileycoin transaction confirmed?","After it is included into the block","After 10 minutes passed since the transaction was made","After it is included into the block","After 60 minutes passed since the transaction was made","After the transaction is broadcasted onto the network"));
        quizRepository.save(new Question(0, "What is a transaction fee?","It's an amount of Smileycoin user pays to the miners to include the transaction into the block","It's an amount of Smileycoin user pays to the miners to include the transaction into the block","It's a fee that is paid to the exchange when you sell/buy bitcoins","It's a fee paid to wallet authors when sending a transaction","It's a fee deducted from each transaction and destroyed"));
        quizRepository.save(new Question(0, "What is a blockchain?","A sequence of blocks with all the data (confirmed transactions) in it distributed and stored by each full node on the system","All transactions in Bitcoin including the ones in the mempool","All unconfirmed transactions","A sequence of blocks with all the data (confirmed transactions) in it distributed and stored by each full node on the system","All confirmed transactions sorted by their date"));
        quizRepository.save(new Question(0, "What purpose do miners serve?","They collectively synchronize on a single history of transactions","They collectively synchronize on a single history of transactions","They create new Smileycoins","They have no purpose and are not really needed","They control how many new Smileycoins are issued every 10 minutes"));
        quizRepository.save(new Question(0, "What is proof of work?","It's a piece of data confirming that energy was spent mining a block and verifying the transactions in it","It's a term for a transaction that has been confirmed","It's a piece of data confirming that energy was spent mining a block and verifying the transactions in it","It's a term for a yet to be confirmed transaction","Amount of energy spent on mining the next block"));
        quizRepository.save(new Question(0, "What do you call a wallet that requires two or more keys to send a transaction?","A multisig wallet","A multi-key wallet","A multiwallet","2fa wallet","A multisig wallet"));
        quizRepository.save(new Question(0, "What is a public key?","Public key mathematically corresponds to a Smileycoin address","Public key mathematically corresponds to a Smileycoin address","Same as private key","Same as wallet password","Same as seed"));
    }

    @Override
    public List<Question> findAll() {
        return quizRepository.findAll();
    }
    @Override
    public Question save(Question question) {
        return null;
    }
    @Override
    public int getNoOfQuestions() {
        return noOfQuestions;
    }
    @Override
    public int incrementNoOfQuestion() {
        return noOfQuestions++;
    }


/*
    @Override
    public Question findById(long ID) {
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
