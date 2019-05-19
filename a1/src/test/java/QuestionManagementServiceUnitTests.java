
import org.junit.Assert;
import org.junit.Test;
import ro.utcn.sd.it.a1.exception.QuestionNotFoundException;
import ro.utcn.sd.it.a1.model.Question;
import ro.utcn.sd.it.a1.model.User;
import ro.utcn.sd.it.a1.persistance.api.RepositoryFactory;
import ro.utcn.sd.it.a1.persistance.memory.InMemoryRepositoryFactory;
import ro.utcn.sd.it.a1.service.QuestionManagementSystem;


public class QuestionManagementServiceUnitTests {

    private static RepositoryFactory createMockedFactory(){
        RepositoryFactory factory=new InMemoryRepositoryFactory();

        factory.createQuestionRepository().save(new Question("title",new User(1,"name","passwrd"),"Some text"));
        factory.createQuestionRepository().save(new Question("title2",new User(2,"name2","passwrd2"),"Some text2"));


        return factory;
    }

    @Test
    public void testRemoveWorksWithExistingId(){
        RepositoryFactory factory=createMockedFactory();
        QuestionManagementSystem qms= new QuestionManagementSystem(factory);

        qms.removeQuestion(1);
        Assert.assertEquals(1,factory.createQuestionRepository().findAll().size());
        Assert.assertTrue(factory.createQuestionRepository().findById(2).isPresent());
    }

    @Test(expected = QuestionNotFoundException.class)
    public void testRemoveThrowsWithNotExistingId(){
        RepositoryFactory factory=createMockedFactory();
        QuestionManagementSystem qms= new QuestionManagementSystem(factory);

        qms.removeQuestion(999);

    }



}
