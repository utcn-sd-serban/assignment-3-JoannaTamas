package ro.utcn.sd.it.a1.persistance.jdbc;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ro.utcn.sd.it.a1.persistance.api.*;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "a1.repository-type", havingValue = "JDBC")
public class JdbcRepositoryFactory implements RepositoryFactory {
    private final JdbcTemplate template;

    @Override
    public QuestionRepository createQuestionRepository() {
        return new JdbcQuestionRepository(template);
    }

    @Override
    public UserRepository createUserRepository() {
        return new JdbcUserRepository(template);
    }

    @Override
    public AnswerRepository createAnswerRepository() {
        return new JdbcAnswerRepository(template);
    }

    @Override
    public TagRepository createTagRepository() {
        return new JdbcTagRepository(template);
    }

}
