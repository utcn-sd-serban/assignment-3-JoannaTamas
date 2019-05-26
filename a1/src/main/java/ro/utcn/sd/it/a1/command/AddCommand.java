package ro.utcn.sd.it.a1.command;

import ro.utcn.sd.it.a1.dto.QuestionDTO;
import ro.utcn.sd.it.a1.event.QuestionCreatedEvent;
import ro.utcn.sd.it.a1.model.Question;
import ro.utcn.sd.it.a1.persistance.api.QuestionRepository;
import ro.utcn.sd.it.a1.persistance.api.RepositoryFactory;

public class AddCommand implements Command {
    private RepositoryFactory repositoryFactory;
    private QuestionRepository questionRepository;

    public AddCommand(QuestionRepository qRepository){

        this.questionRepository=qRepository;
    }


    @Override
    public QuestionDTO execute(QuestionDTO dto) {
        Question question = new Question();
        question.setId(dto.getId());
        question.setAuthor(repositoryFactory.createUserRepository().findByName(dto.getAuthor()));
        question.setDate_time(dto.getDate_time());
        question.setText(dto.getText());
        question.setTitle(dto.getTitle());
        question.setTag(dto.getTag());
        question.setTag(repositoryFactory.createTagRepository().save(question.getTag()));
        QuestionDTO output = QuestionDTO.ofEntity(repositoryFactory.createQuestionRepository().save(question));
        return output;
    }
}
