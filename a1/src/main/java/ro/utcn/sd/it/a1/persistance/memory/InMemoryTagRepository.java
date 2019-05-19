package ro.utcn.sd.it.a1.persistance.memory;

import ro.utcn.sd.it.a1.model.Tag;
import ro.utcn.sd.it.a1.persistance.api.TagRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryTagRepository implements TagRepository {
    private final AtomicInteger currentId = new AtomicInteger(0);
    private final Map<Integer,Tag > data = new ConcurrentHashMap<>();


    @Override
    public List<Tag> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Optional<Tag> findById(int id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public Tag save(Tag tag) {
        if(tag.getId() == null){
            tag.setId(currentId.incrementAndGet());
        } data.put(tag.getId(),tag);

        return tag;
    }

    @Override
    public void remove(Tag tag) {
        data.remove(tag.getId());

    }
}
