package ro.utcn.sd.it.a1.persistance.memory;

import ro.utcn.sd.it.a1.model.Question;
import ro.utcn.sd.it.a1.persistance.api.QuestionRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryQuestionRepository implements QuestionRepository {
    private final AtomicInteger currentId = new AtomicInteger(0);
    private final Map<Integer,Question > data = new ConcurrentHashMap<>();

    @Override
    public  Question save(Question question) {
        if(question.getId() == null){
            question.setId(currentId.incrementAndGet());
        } data.put(question.getId(),question);

        return question;
    }

    @Override
    public Optional<Question> findById(int id) {

        return Optional.ofNullable(data.get(id));//it can be null and it transforms it into optional
    }

    @Override
    public List<Question> findByTitle(String title) {
        return new ArrayList<>(data.values());
    }


    @Override
    public synchronized void remove(Question question) {

        data.remove(question.getId());
    }

    @Override
    public List<Question> findAll() {

        return new ArrayList<>(data.values());
    }



    @Override
    public List<Question> listByDate() {

        return new ArrayList<>(data.values());
    }
}
