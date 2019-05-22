package ro.utcn.sd.it.a1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.utcn.sd.it.a1.dto.QuestionDTO;
import ro.utcn.sd.it.a1.exception.QuestionNotFoundException;
import ro.utcn.sd.it.a1.model.Question;

import ro.utcn.sd.it.a1.persistance.api.QuestionRepository;
import ro.utcn.sd.it.a1.persistance.api.RepositoryFactory;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Component
@Service
@RequiredArgsConstructor
public class QuestionManagementSystem {
    private final RepositoryFactory repositoryFactory;


    @Transactional
    public List<QuestionDTO> listQuestion() {

        return repositoryFactory.createQuestionRepository().findAll().stream()
                .map(this::updateUserOfQuestion)
                .map(QuestionDTO::ofEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public Question updateUserOfQuestion(Question question){
        question.setAuthor(repositoryFactory.createUserRepository().findById(question.getAuthor().getId()).get());
        return question;

    }

    @Transactional
    public Question findById(int id) {

        return repositoryFactory.createQuestionRepository().findById(id).orElseThrow(QuestionNotFoundException::new);
    }

    @Transactional
    public QuestionDTO addQuestion(QuestionDTO dto) {
        Question question=new Question();
        question.setId(dto.getId());
        question.setAuthor(repositoryFactory.createUserRepository().findByName(dto.getAuthor()));
        question.setDate_time(dto.getDate_time());
        question.setText(dto.getText());
        question.setTitle(dto.getTitle());
        question.setTag(dto.getTag());
        question.setTag(repositoryFactory.createTagRepository().save(question.getTag()));
        return QuestionDTO.ofEntity(repositoryFactory.createQuestionRepository().save(question));
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
