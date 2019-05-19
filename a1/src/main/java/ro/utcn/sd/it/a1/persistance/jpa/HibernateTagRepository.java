package ro.utcn.sd.it.a1.persistance.jpa;

import lombok.RequiredArgsConstructor;
import ro.utcn.sd.it.a1.model.Tag;
import ro.utcn.sd.it.a1.persistance.api.TagRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class HibernateTagRepository implements TagRepository {
    private final EntityManager entityManager;

    @Override
    public List<Tag> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tag> query = builder.createQuery(Tag.class);
        query.select(query.from(Tag.class));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Optional<Tag> findById(int id) {
        return Optional.ofNullable(entityManager.find(Tag.class, id));
    }

    @Override
    public Tag save(Tag tag) {
        if (tag.getId() == null) {
            entityManager.persist(tag);
            return tag;
        } else {
            return entityManager.merge(tag);
        }
    }


    @Override
    public void remove(Tag tag) {
        entityManager.remove(tag);

    }
}
