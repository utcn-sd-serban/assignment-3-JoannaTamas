package ro.utcn.sd.it.a1.persistance.api;


//@FunctionalInterface
public interface RepositoryFactory {

    QuestionRepository createQuestionRepository();

    UserRepository createUserRepository();

    AnswerRepository createAnswerRepository();

    TagRepository createTagRepository();
}
