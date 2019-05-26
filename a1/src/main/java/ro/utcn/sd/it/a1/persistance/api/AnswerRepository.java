package ro.utcn.sd.it.a1.persistance.api;

import ro.utcn.sd.it.a1.model.Answer;

import java.util.List;
import java.util.Optional;


public interface AnswerRepository {
    List<Answer> findAll();

    Answer save(Answer ans);

    void remove(Answer answer);

    Optional<Answer> findById(int id);

    Answer edit(Answer answer);
}
