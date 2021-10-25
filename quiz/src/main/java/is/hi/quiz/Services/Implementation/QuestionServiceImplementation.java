package is.hi.quiz.Services.Implementation;
import is.hi.quiz.Persistance.Entities.Category;
import is.hi.quiz.Persistance.Entities.Question;
import is.hi.quiz.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImplementation implements QuestionService {
    // Here would be a Jpa link to repository
    private List<Question> questionRepository= new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private int id_counter=0;

    @Autowired
    public QuestionServiceImplementation() {
        // Dummy data. To be removed when JPA added.
        questionRepository.add(new Question(1,"Hvað er uppáhalds maturinn þinn?","Kjúklingur","Hamborgari","Pizza","Kjúklingur","Ostrur"));
        questionRepository.add(new Question(1,"Hver er forseti Íslands ?","Guðni Th","Guðni Th","Óli Grís","Vigga Finn","Holy B"));
        questionRepository.add(new Question(1,"Hver er höfuðborg Danmerkur ?","Kaupmannahöfn","Álaborg","Kaupmannahöfn","Esbjerg","Roskilde"));
        questionRepository.add(new Question(2,"Hvað er klukkan?","21:00","16:30","12:00","21:00","19:45"));
        questionRepository.add(new Question(2,"Hvert er hæsta fjall heims ?","Everest","Treveste","Estever","Vesterne","Everest"));
        questionRepository.add(new Question(2,"Hver er best/ur ?","Ég","Ég","Hann","Hún","Þú"));

        categories.add(new Category(1,"Landafræði"));
        categories.add(new Category(1,"Íþróttir"));
        categories.add(new Category(1,"Skemmtun"));
        categories.add(new Category(1,"Tölvuleikir"));
    // jpa gives each question an ID but here we add manually.
        for(Question q: questionRepository){
            q.setID(id_counter);
            id_counter++;
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
