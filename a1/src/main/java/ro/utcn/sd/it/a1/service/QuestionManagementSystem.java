package ro.utcn.sd.it.a1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.utcn.sd.it.a1.exception.QuestionNotFoundException;
import ro.utcn.sd.it.a1.model.Question;

import ro.utcn.sd.it.a1.persistance.api.QuestionRepository;
import ro.utcn.sd.it.a1.persistance.api.RepositoryFactory;

import javax.transaction.Transactional;
import java.util.List;


@Component
@Service
@RequiredArgsConstructor
public class QuestionManagementSystem {
    private final RepositoryFactory repositoryFactory;



    @Transactional
    public List<Question> listQuestion() {

        return repositoryFactory.createQuestionRepository().findAll();
    }

    @Transactional
    public Question findById(int id) {

        return repositoryFactory.createQuestionRepository().findById(id).orElseThrow(QuestionNotFoundException::new);
    }

    @Transactional
    public Question addQuestion(Question question) {
        return repositoryFactory.createQuestionRepository().save(question);
    }

    @Transactional
    public void removeQuestion(int id) {
        QuestionRepository repository = repositoryFactory.createQuestionRepository();
        Question question = repository.findById(id).orElseThrow(QuestionNotFoundException::new);
        repository.remove(question);

    }


    @Transactional
    public List<Question> listQuestionByTitle(String title) {
        return repositoryFactory.createQuestionRepository().findByTitle(title);
    }

    @Transactional
    public List<Question> listQuestionByDate() {

        return repositoryFactory.createQuestionRepository().listByDate();
    }


}
