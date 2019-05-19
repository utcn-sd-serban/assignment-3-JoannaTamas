package ro.utcn.sd.it.a1.persistance.jdbc;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import ro.utcn.sd.it.a1.model.Question;
import ro.utcn.sd.it.a1.model.Tag;
import ro.utcn.sd.it.a1.model.User;
import ro.utcn.sd.it.a1.persistance.api.QuestionRepository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RequiredArgsConstructor
public class JdbcQuestionRepository implements QuestionRepository {

    private final JdbcTemplate template;


    @Override
    public Question save(Question question) {

        if (question.getId() == null) {
            question.setId(insert(question));
            insert_tag(question);
        } else {
            update(question);
        }
        return question;
    }

    @Override
    public Optional<Question> findById(int id) {

        List<Question> questions = template.query("SELECT * FROM question WHERE id=? ", new Object[]{id},
                (resultSet, i) -> new Question(resultSet.getInt("id"),
                        resultSet.getString("title"), resultSet.getString("text"),
                        new User(resultSet.getInt("author_id")), resultSet.getTimestamp("date_time")));

        return questions.isEmpty() ? Optional.empty() : Optional.of(questions.get(0));
    }

    @Override
    public List<Question> findByTitle(String title) {
        //query for reading stuff
        List<Question> questions = template.query("SELECT * FROM question WHERE  title =? ", new Object[]{title},
                (resultSet, i) -> new Question(resultSet.getInt("id"),
                        resultSet.getString("title"), resultSet.getString("text"),
                        new User(resultSet.getInt("author_id")), resultSet.getTimestamp("date_time")));

        return questions.isEmpty() ? null : questions;
    }


    @Override
    public void remove(Question question) {
        template.update("DELETE FROM question WHERE id=?", question.getId());

    }

    @Override
    public List<Question> findAll() {

        return template.query("SELECT * FROM question", (resultSet, i) ->
                new Question(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("text"),
                        new User(resultSet.getInt("author_id")), resultSet.getTimestamp("date_time")));
    }



    @Override
    public List<Question> listByDate() {
        return template.query("SELECT * FROM question ORDER BY date_time DESC", (resultSet, i) ->
                new Question(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("text"),
                        new User(resultSet.getInt("author_id")), resultSet.getTimestamp("date_time")));
    }


    private void insert_tag(Question question) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(template);
        insert.setTableName("question_tag");
        Tag t = question.getTag();
        Map<String, Object> data = new HashMap<>();
        data.put("question_id", question.getId());
        data.put("tag_id", t.getId());


        insert.execute(data);

    }

    private int insert(Question question) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(template);
        insert.setTableName("question");
        insert.setGeneratedKeyName("id");

        Map<String, Object> data = new HashMap<>();
        data.put("title", question.getTitle());
        data.put("text", question.getText());
        data.put("author_id", question.getAuthor().getId());
        data.put("date_time", question.getDate_time());

        return insert.executeAndReturnKey(data).intValue();


    }

    private void update(Question question) {
        template.update("UPDATE  question SET title=? AND text=? WHERRE id=?",
                question.getTitle(), question.getText(), question.getId(), question.getDate_time());
    }

}
