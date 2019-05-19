package ro.utcn.sd.it.a1.persistance.memory;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import ro.utcn.sd.it.a1.persistance.api.*;


@Component
@ConditionalOnProperty(name = "a1.repository-type", havingValue = "MEMORY")
public class InMemoryRepositoryFactory implements RepositoryFactory {
    private InMemoryQuestionRepository repository=new InMemoryQuestionRepository();
    private InMemoryUserRepository userRepo=new InMemoryUserRepository();
    private InMemoryTagRepository tagRepo=new InMemoryTagRepository();
    private InMemoryAnswerRepository ansRepo=new InMemoryAnswerRepository();

    @Override
    public QuestionRepository createQuestionRepository() {

        return repository;
    }

    @Override
    public UserRepository createUserRepository() {

        return userRepo;
    }

    @Override
    public AnswerRepository createAnswerRepository() {
        return ansRepo;
    }

    @Override
    public TagRepository createTagRepository() {
        return tagRepo;
    }


}
