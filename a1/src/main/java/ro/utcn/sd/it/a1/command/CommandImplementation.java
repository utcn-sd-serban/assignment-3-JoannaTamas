package ro.utcn.sd.it.a1.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.utcn.sd.it.a1.persistance.api.QuestionRepository;
import ro.utcn.sd.it.a1.persistance.api.RepositoryFactory;

@Component
@RequiredArgsConstructor
public class CommandImplementation implements CommandFactory{

    private final RepositoryFactory repositoryFactory;

    @Override
    public Command addCommand() {
        QuestionRepository questionRepository=repositoryFactory.createQuestionRepository();
        return new AddCommand(questionRepository);
    }
}
