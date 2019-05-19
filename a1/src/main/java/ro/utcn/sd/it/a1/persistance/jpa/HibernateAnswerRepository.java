package ro.utcn.sd.it.a1.persistance.jpa;

import lombok.RequiredArgsConstructor;
import ro.utcn.sd.it.a1.model.Answer;
import ro.utcn.sd.it.a1.persistance.api.AnswerRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class HibernateAnswerRepository implements AnswerRepository {
    private final EntityManager entityManager;


    @Override
    public List<Answer> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Answer> query = builder.createQuery(Answer.class);
        query.select(query.from(Answer.class));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Answer save(Answer ans) {
        if (ans.getId() == null) {
            entityManager.persist(ans);
            return ans;
        } else {
            return entityManager.merge(ans);
        }

    }

    @Override
    public void remove(Answer answer) {
        entityManager.remove(answer);
    }

    @Override
    public Optional<Answer> findById(int id) {
        return Optional.ofNullable(entityManager.find(Answer.class, id));
    }

    @Override
    public Answer edit(Answer answer) {
        return null;
    }
}
