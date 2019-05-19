package ro.utcn.sd.it.a1.persistance.jpa;

import lombok.RequiredArgsConstructor;
import ro.utcn.sd.it.a1.model.Question;
import ro.utcn.sd.it.a1.persistance.api.QuestionRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class HibernateQuestionRepository implements QuestionRepository {
    private final EntityManager entityManager;


    @Override
    public Question save(Question question) {
        if (question.getId() == null) {
            entityManager.persist(question);
            return question;
        } else {
            return entityManager.merge(question);
        }

    }

    @Override
    public Optional<Question> findById(int id) {

        return Optional.ofNullable(entityManager.find(Question.class, id));
    }

    @Override
    public List<Question> findByTitle(String title) {
        return null;
    }

    @Override
    public void remove(Question question) {
        entityManager.remove(question);

    }

    @Override
    public List<Question> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Question> query = builder.createQuery(Question.class);
        query.select(query.from(Question.class));
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    public List<Question> listByDate() {
        return null;
    }


}
