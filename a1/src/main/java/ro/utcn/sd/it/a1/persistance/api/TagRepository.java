package ro.utcn.sd.it.a1.persistance.api;

import ro.utcn.sd.it.a1.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagRepository {
    List<Tag> findAll();

    Optional<Tag> findById(int id);

    Tag save(Tag tag);

    void remove(Tag tag);

}
