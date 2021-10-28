package is.hi.quiz.Services.Implementation;

import is.hi.quiz.Persistance.Entities.Account;
import is.hi.quiz.Persistance.Entities.Category;
import is.hi.quiz.Persistance.Entities.Question;
import is.hi.quiz.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImplementation implements AccountService {
    // Here would be a Jpa link to AccountRepository
    private List<Account> accountRepository= new ArrayList<>();
    private int id_counter=0;

    @Autowired
    public AccountServiceImplementation(){
        // Dummy data. To be removed when JPA added.
        accountRepository.add(new Account("user","123","user@email.com","User",false));
        accountRepository.add(new Account("admin","123","admin@email.com","Admin",true));

    // jpa gives each question an ID but here we add manually.
        for(Account a: accountRepository){
        a.setID(id_counter);
        id_counter++;
        }
    }

    @Override
    public List<Account> findAll() {
        return accountRepository;
    }

    @Override
    public Account findById(long ID) {
        for(Account a: accountRepository){
            if(a.getID()==ID){
                return a;
            }
        }
        return null;
    }

    @Override
    public Account save(Account account) {
        account.setID(id_counter);
        id_counter++;
        account.isAdmin=false;
        accountRepository.add(account);
        return account;
    }

    @Override
    public void delete(Account account) {
        accountRepository.remove(account);
    }

    @Override
    public Account findByUsername(String username) {
        for(Account a: accountRepository){
            if((username).equals(a.getUsername())){
                return a;
            }
        }
        return null;
        //return accountRepository.findByUsername(username);
    }

    @Override
    public Account login(Account account) {
        Account doesExist = findByUsername(account.getUsername());
        if(doesExist != null){
            if(doesExist.getPassword().equals(account.getPassword())){
                return doesExist;
            }
        }
        return null;
    }
}
