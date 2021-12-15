package is.hi.smlyweb.Persistance.Repository;


import is.hi.smlyweb.Persistance.Entities.Scores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Scores,Long> {
    Scores save(Scores scores);
    //List <Scores> findByAccountIDOrderByScoreDesc(long accountID);
    List<Scores> findAll();
    List <Scores> findTop10ByOrderByScoreDesc();
}
