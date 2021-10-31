package is.hi.quiz.Services.Implementation;
import is.hi.quiz.Persistance.Entities.Category;
import is.hi.quiz.Persistance.Entities.Question;
import is.hi.quiz.Persistance.Entities.Quiz;
import is.hi.quiz.Services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImplementation implements QuizService {
    // Here would be a Jpa link to QuizRepository
    private List<Question> questionRepository= new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private Quiz quiz;
    private int id_counter=0;
    private int id_counter2=0;
    private int noOfQuestions=0;

    @Autowired
    public QuizServiceImplementation() {
        // Dummy data. To be removed when JPA added.
        questionRepository.add(new Question(0, "Question 1 - Category 0", "OptionA", "OptionA", "OptionB", "OptionC", "OptionD"));
        questionRepository.add(new Question(0, "Question 2 - Category 0", "OptionA", "OptionA", "OptionB", "OptionC", "OptionD"));
        questionRepository.add(new Question(0, "Question 3 - Category 0", "OptionA", "OptionA", "OptionB", "OptionC", "OptionD"));
        questionRepository.add(new Question(1, "Question 1 - Category 1", "OptionA", "OptionA", "OptionB", "OptionC", "OptionD"));
        questionRepository.add(new Question(1, "Question 2 - Category 1", "OptionA", "OptionA", "OptionB", "OptionC", "OptionD"));
        questionRepository.add(new Question(1, "Question 3 - Category 1", "OptionA", "OptionA", "OptionB", "OptionC", "OptionD"));
        questionRepository.add(new Question(2, "Question 1 - Category 2", "OptionA", "OptionA", "OptionB", "OptionC", "OptionD"));
        questionRepository.add(new Question(2, "Question 2 - Category 2", "OptionA", "OptionA", "OptionB", "OptionC", "OptionD"));
        questionRepository.add(new Question(2, "Question 3 - Category 2", "OptionA", "OptionA", "OptionB", "OptionC", "OptionD"));
        questionRepository.add(new Question(3, "Question 1 - Category 3", "OptionA", "OptionA", "OptionB", "OptionC", "OptionD"));
        questionRepository.add(new Question(3, "Question 2 - Category 3", "OptionA", "OptionA", "OptionB", "OptionC", "OptionD"));
        questionRepository.add(new Question(3, "Question 3 - Category 3", "OptionA", "OptionA", "OptionB", "OptionC", "OptionD"));

        categories.add(new Category(0, "Category 0", questionRepository));
        categories.add(new Category(1, "Category 1", questionRepository));
        categories.add(new Category(2, "Category 2", questionRepository));
        categories.add(new Category(3, "Category 3", questionRepository));

        //quiz=new Quiz(categories,)

        // Jpa gives each question an ID but here we add manually.
        for (Question q : questionRepository) {
            q.setID(id_counter);
            id_counter++;
        }
        for (Category c : categories) {
            c.setID(id_counter2);
            id_counter2++;
        }
        // Add questions from dummy question db to relevant categories to make a "question package" for each category.
        for (int j = 0; j < categories.size(); j++) {
            List<Question> questionList = new ArrayList<>();
            for (int i = 0; i < questionRepository.size(); i++) {
                if (categories.get(j).getCategoryID() == questionRepository.get(i).getCategoryID()) {
                    questionList.add(questionRepository.get(i));
                }
            }
            categories.get(j).setQuestions(questionList);
        }


    }
    @Override
    public List <Category> findAllCategories(){
        return categories;
    }

    // Get questions by category
    @Override
    public List <Question> findByCategory(int categoryID) {
        List <Question> quiz = new ArrayList<>();
        for(Question q: questionRepository){
            if((categoryID) == q.getCategoryID()){
                quiz.add(q);
            }
        }
        return quiz;

    }

    @Override
    public Quiz getQuiz(int categoryID,int noOfplayers) {
        for(Category c: categories) {
            if (categoryID == c.getID()) {
                quiz = new Quiz(c, noOfplayers);
                return quiz;
            }
        }
        return null;
    }

    @Override
    public int resetNoOfQuestions(){
        return noOfQuestions=0;
    }
    @Override
    public int getNoOfQuestions(){
        return noOfQuestions;
    }
    @Override
    public int incrementNoOfQuestion(){
        return noOfQuestions++;
    }

    // We probably won't need this one.
    @Override
    public List<Question> findAll() {
        return questionRepository;
    }
   // Or this one
    @Override
    public Question findById(long ID) {
        for(Question q: questionRepository){
            if(q.getID()==ID){
                return q;
            }
        }
        return null;
    }
    // Admin required for this action
    @Override
    public Question save(Question question) {
        question.setID(id_counter);
        id_counter++;
        questionRepository.add(question);
        return question;
    }
    // Admin required for this action
    @Override
    public void delete(Question question) {
        questionRepository.remove(question);
    }
}
