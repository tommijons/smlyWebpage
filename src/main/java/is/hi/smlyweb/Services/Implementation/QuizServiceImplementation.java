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
      /* quizRepository.deleteAll();
        scoreRepository.deleteAll();
        quizRepository.save(new Question(0, "What is a Smileycoin Wallet","A software that can receive and send Smileycoin transactions and store your private keys","It`s a flash drive with a special key on it","A software that can receive and send Smileycoin transactions and store your private keys","It`s a Smileycoin address","A database of all transactions made to your address"));quizRepository.save(new Question(0, "What is a Smileycoin address?","A string consisting of latin letters and numbers, which is used to receive funds into your Smileycoin wallet","A string consisting of latin letters and numbers, which is used to receive funds into your Smileycoin wallet","A unique identifier of a Smileycoin user in the system","A synonym for wallet","A synonym for transaction"));
        quizRepository.save(new Question(0, "What is a private key?","A string of letters and numbers, which is used to sign transactions that spend bitcoins in your wallet","Password to your wallet","A synonym for address","A string of letters and numbers, which is used to sign transactions that spend bitcoins in your wallet","Same as the public key"));
        quizRepository.save(new Question(0, "What is a transaction?","A message later written onto the Smileycoin blockchain that specifies the amounts being sent between addresses","A message later written onto the Smileycoin blockchain that specifies the amounts being sent between addresses","A transfer of funds into your bank account when you sell Smileycoin","A synonym to address","A group of addresses"));
        quizRepository.save(new Question(0, "What is a block?","It's a bunch of cryptographically verified transactions, bundled together and written on the blockchain","Newly mined smileycoins","A confirmation issued every 10 minutes by smileycoin miners, stating all recent transactions are valid","A Smileycoin transaction that has more than 1MB of data in it","It's a bunch of cryptographically verified transactions, bundled together and written on the blockchain"));
        quizRepository.save(new Question(0, "When is a Smileycoin transaction confirmed?","After it is included into the block","After 10 minutes passed since the transaction was made","After it is included into the block","After 60 minutes passed since the transaction was made","After the transaction is broadcasted onto the network"));
        quizRepository.save(new Question(0, "What is a transaction fee?","It's an amount of Smileycoin user pays to the miners to include the transaction into the block","It's an amount of Smileycoin user pays to the miners to include the transaction into the block","It's a fee that is paid to the exchange when you sell/buy bitcoins","It's a fee paid to wallet authors when sending a transaction","It's a fee deducted from each transaction and destroyed"));
        quizRepository.save(new Question(0, "What is a blockchain?","A sequence of blocks with all confirmed transactions, distributed and stored by each full node on the system","All transactions in Bitcoin including the ones in the mempool","All unconfirmed transactions","A sequence of blocks with all confirmed transactions, distributed and stored by each full node on the system","All confirmed transactions sorted by their date"));
        quizRepository.save(new Question(0, "What purpose do miners serve?","They collectively synchronize on a single history of transactions","They collectively synchronize on a single history of transactions","They create new Smileycoins","They have no purpose and are not really needed","They control how many new Smileycoins are issued every 10 minutes"));
        quizRepository.save(new Question(0, "What is proof of work?","It's a piece of data confirming that energy was spent mining a block and verifying the transactions in it","It's a term for a transaction that has been confirmed","It's a piece of data confirming that energy was spent mining a block and verifying the transactions in it","It's a term for a yet to be confirmed transaction","Amount of energy spent on mining the next block"));
        quizRepository.save(new Question(0, "What do you call a wallet that requires two or more keys to send a transaction?","A multisig wallet","A multi-key wallet","A multiwallet","2fa wallet","A multisig wallet"));
        quizRepository.save(new Question(0, "What is a public key?","Public key mathematically corresponds to a Smileycoin address","Public key mathematically corresponds to a Smileycoin address","Same as private key","Same as wallet password","Same as seed"));

        quizRepository.save(new Question(0, "What is scriptSig ?","A script which unlocks a UTXO for spending","A script which unlocks a UTXO for spending","A script which contains all UTXO","A script which controls how bitcoin can be spent","A script which verifies a private key"));
        quizRepository.save(new Question(0, "What is used to sign a transaction ?","Private key","Public key","vout","txid","Private key"));
        quizRepository.save(new Question(0, "What op code is used to write messages on a blockchain ?","OP_RETURN","OP_ADD","OP_HEX","OP_RETURN","OP_MESSAGE"));
        quizRepository.save(new Question(0, "What is UTXO ?","Unspent transaction output","Decoded hex string","Unspent transaction output","Transaction fee","Unverified transaction"));
        quizRepository.save(new Question(0, "What command can you use to see all unspent transaction outputs ?","listunspent","listall","listoutputs","listunspent","listtransactions"));
        quizRepository.save(new Question(0, "What is used to verify ownership of an amount to be spent ?","A public key","A public key","A private key","A txid","Owners address"));
        quizRepository.save(new Question(0, "What is a mempool ?","A collection of unconfirmed transactions","A collection of invalid transactions","A collection of transactions that are included in a block","A collection of confirmed transactions","A collection of unconfirmed transactions"));
        quizRepository.save(new Question(0, "What is op code is used to validate a signature ?","OP_CHECKSIG","OP_SHA1","OP_CHECKSIG","OP_VER","OP_VERIFY"));
        quizRepository.save(new Question(0, "What is scriptPubKey ?","A script which controls how bitcoin can be spent","A script which unlocks a UTXO for spending","A script which contains all UTXO","A script which controls how bitcoin can be spent","A script which verifies a private key"));
        quizRepository.save(new Question(0, "What kind of string is used to write data on the blockchain ?","A hex string","A binary string","An octal string","A hex string","A regular string"));
       */

        /*Questions about the commands
        quizRepository.save(new Question(0, "What statement about the command addchapter is true ?","It adds a new chapter to book chapter service","It adds a new chapter to book chapter service","It adds a new book chapter to library service","It's a trick question, the command doesn't exist","It adds a new chapter from a specified book to your wallet by donating some SMLYs from your wallet, you can read it in the blockchain"));
        quizRepository.save(new Question(0, "What statement about the command adddex is true ?","It adds a new DEX address to DEX service","It adds a new DEX service to DEX address","It adds a new DeX feature to the Samsung DeX feature","It adds a new DEX address to DEX service","It adds the old DEX service to DEX address"));
        quizRepository.save(new Question(0, "What statement about the command addmultisigaddress is true ?","It adds a nrequired-to-sign multisignature address to the wallet","One key is generated for the Smileycoin address and each n person uses that one key","If 'account' is not specified, it generates an error","If 'nrequired' is not specified it defaults to n=1","It adds a nrequired-to-sign multisignature address to the wallet"));
        quizRepository.save(new Question(0, "What statement about the command addnode is true ?","It attempts to add or remove a node from the addnode list","If the 'command' is subtraction then it subtracts a node from the list","If the 'command' is onechance then it has one chance to connect to the node","It attempts to add or remove a node from the addnode list","If the 'command' is addition then it adds a node to the list"));
        quizRepository.save(new Question(0, "What statement about the command addubi is true ?","It adds a new UBI recipient to UBI service.","It has three required fields, servicename, ubiaddress and ubiwallet","It adds a new UBI recipient to UBI service.","",""));
        quizRepository.save(new Question(0, "What statement about the command backupwallet is true ?","It safely copies wallet.dat to destination","It safely copies wallet.dat to destination","The destination field is only a path with filename",""The destination field is only a directory"","It rewrites wallet.dat"));
        quizRepository.save(new Question(0, "What statement about the command buycoupon is true ?","It purchases a coupon on the blockchain","It has two required fields, couponaddress and couponamount","It has no required field/s","There is no such command","It purchases a coupon on the blockchain"));
        */

        /*Questions about SmileyCoin specifically
        quizRepository.save(new Question(0, "How is the block reward split?","Miners fee, dividend and donation ?","It isn't split, it's used completely as the miners fee","Miners fee, dividend and donation","Miner's fee and donation","Miner's fee and dividend"));
        quizRepository.save(new Question(0, "Why was Smileycoin initially developed ?","It was initially made as a way to test reward mechanisms in tutor-web and for fun","It was initially made as a way to test reward mechanisms in canvas","It was initially made as a gag","It was initially made as a way to test students who want to learn about cryptocurrencies","It was initially made as a way to test reward mechanisms in tutor-web and for fun"));
        quizRepository.save(new Question(0, "What is a valid method to earn/get Smileycoins ?","Donating to Education in a Suitcase","Studying in canvas","Buy SMLY using trickery","Donating to Education in a Suitcase","By using a regular ATM"));
        quizRepository.save(new Question(0, "What is Smileycoin designed for ?","It's designed for education and charity","It's designed for education and charity","It's designed for education","It's designed for charity","It's designed for profit"));
        quizRepository.save(new Question(0, "When was Smileycoin launched ?","2014","2014","2012","2015","2013"));
        quizRepository.save(new Question(0, "What is true about Education in a Suitcase ?","It's a charity program","It's a charity program","It's an education program","It's an internship program","It's a teachers elective program"));
         */

        /*Questions about cryptocurrency in general
        quizRepository.save(new Question(0, "Who is the inventor of Bitcoin ?","The inventor is unknown","Steven Hawking","God","The inventor is unknown","John Moore"));
        quizRepository.save(new Question(0, "What is true about cryptojacking ?","It's when scammers use someone else's machine’s resources to mine cryptocurrencies","It's also called corrupt cryptomining","It's a made up word","It's a valid and honest why to earn/get more crypto","It's when scammers use someone else's machine’s resources to mine cryptocurrencies"));
        quizRepository.save(new Question(0, "Who is the largest crypto miner ?","China","China","America","Russia","England"));
        quizRepository.save(new Question(0, "What country hasn't banned crypto ?","China","Bangladesh","Ecuador","China","Nepal"));
        quizRepository.save(new Question(0, "What is the meaning of crypto ?","It is greek terminology for hidden or private","It is roman terminology for coins","It is egyptian terminology for mystery","It is latin terminology for money or payment","It is greek terminology for hidden or private"));
        quizRepository.save(new Question(0, "Which of these are real cryptocurrencies ?","Ethereum","Smolcoin","Ethereum","Lighttap","Poppy"));
         */
    }


    /****************************
     * Question number handling
     ****************************/

    @Override
    public List<Question> findAll() {
        return quizRepository.findAll();
    }

    @Override
    public Question save(Question question) {
        return null;
    }

    // When new quiz is played we reset number of questions that have been displayed/asked
    @Override
    public int resetNoOfQuestions() {
        return noOfQuestions = 0;
    }

    // Gets how many questions have been displayed/asked
    @Override
    public int getNoOfQuestions() {
        return noOfQuestions;
    }

    // We need to increment after each question to get to next question after answering question w. button click
    @Override
    public int incrementNoOfQuestion() {
        return noOfQuestions++;
    }

    // Answer handling
    @Override
    public void resetAnswers() {
        answers.clear();
        correctAnswers.clear();
    }
    @Override
    public void addAnswer(String answer, String correctAns) {
        answers.add(answer);
        correctAnswers.add(correctAns);
    }
    @Override
    public List<String> getAnswers() {
        return answers;
    }
    @Override
    public List<String> getCorrectAnswers() {
        return correctAnswers;
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


*/
    @Override
    public List<Scores> findAllScores() {
        return scoreRepository.findAll();
    }
    @Override
    public Scores saveScores(Scores scores) {
        return scoreRepository.save(scores);

    }
    public int getScore(){
        return score;
    }
    public int addScore(int points){
        return score+=points;
    }

    public int resetScore(){
        return score=0;
    }

}
