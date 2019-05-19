package ro.utcn.sd.it.a1.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.utcn.sd.it.a1.exception.AnswerNotFoundException;
import ro.utcn.sd.it.a1.model.Answer;
import ro.utcn.sd.it.a1.model.User;
import ro.utcn.sd.it.a1.persistance.api.AnswerRepository;
import ro.utcn.sd.it.a1.persistance.api.RepositoryFactory;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Service
@RequiredArgsConstructor
public class AnswerManagementSystem {
    private final RepositoryFactory repositoryFactory;

    @Transactional
    public Answer addAnswer(Answer answer) {

        return repositoryFactory.createAnswerRepository().save(answer);
    }

    @Transactional
    public Answer findById(int id) {

        return repositoryFactory.createAnswerRepository().findById(id).orElseThrow(AnswerNotFoundException::new);
    }


    @Transactional
    public void removeAnswer(int id, User user) {
        AnswerRepository repository = repositoryFactory.createAnswerRepository();
        Answer answer = repository.findById(id).orElseThrow(AnswerNotFoundException::new);
        if (user.getId() == answer.getAuthor().getId()) {
            repository.remove(answer);
        }

    }


    @Transactional
    public List<Answer> listAnswer() {

        return repositoryFactory.createAnswerRepository().findAll();
    }

    @Transactional
    public Answer editAnswer(Answer answer){
        return repositoryFactory.createAnswerRepository().edit(answer);
    }
}
