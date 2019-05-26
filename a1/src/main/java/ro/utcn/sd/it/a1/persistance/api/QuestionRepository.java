package ro.utcn.sd.it.a1.persistance.api;

import ro.utcn.sd.it.a1.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository {

    Question save(Question question);


    Optional<Question> findById(int id);

    List<Question> findByTitle(String title);

    void remove(Question question);

    List<Question> findAll();


    List<Question> listByDate();
}
