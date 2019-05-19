package ro.utcn.sd.it.a1.persistance.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import ro.utcn.sd.it.a1.model.Tag;
import ro.utcn.sd.it.a1.persistance.api.TagRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class JdbcTagRepository implements TagRepository {

    private final JdbcTemplate template;

    @Override
    public List<Tag> findAll() {
        return null;
    }

    @Override
    public Optional<Tag> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Tag save(Tag tag) {
        if (tag.getId() == null) {
            tag.setId(insert(tag));
        } else {
            update(tag);
        }
        return tag;
    }
    @Override
    public void remove(Tag tag) {
        template.update("DELETE FROM tag WHERE id = ?", tag.getId());
    }

    private int insert(Tag tag) {

        SimpleJdbcInsert insert= new SimpleJdbcInsert(template);
        insert.setTableName("tag");
        insert.setGeneratedKeyName("id");

        Map<String, Object>data=new HashMap<>();
        data.put( "tag_name", tag.getName());



        return insert.executeAndReturnKey(data).intValue();
    }

    private void update(Tag tag){
        //template.update( "UPDATE  question SET title=? AND text=? WHERRE id=?",
            //    question.getTitle(),question.getText(),question.getId(),question.getDate_time());
    }
}
