package ro.utcn.sd.it.a1.persistance.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import ro.utcn.sd.it.a1.model.Answer;
import ro.utcn.sd.it.a1.model.Question;
import ro.utcn.sd.it.a1.model.User;
import ro.utcn.sd.it.a1.persistance.api.AnswerRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class JdbcAnswerRepository implements AnswerRepository {
    private final JdbcTemplate template;


    @Override
    public List<Answer> findAll() {
        return template.query("SELECT * FROM answer", (resultSet, i) ->
                new Answer(resultSet.getInt("id"), resultSet.getString("text"),
                        new User(resultSet.getInt("author_id")), new Question(resultSet.getInt("question_id")),
                        resultSet.getTimestamp("date_time")));


    }

    @Override
    public Answer save(Answer answer) {

        if (answer.getId() ==null) {
            answer.setId(insert(answer));
        } else {
            update(answer);
        }
        return answer;
    }

    @Override
    public void remove(Answer answer) {
        template.update("DELETE FROM answer WHERE id=?", answer.getId());

    }

    @Override
    public Optional<Answer> findById(int id) {

        List<Answer> answers = template.query("SELECT * FROM answer WHERE id= ?", new Object[]{id},
                (resultSet, i) -> new Answer(resultSet.getInt("id"), resultSet.getString("text"),
                        new User(resultSet.getInt("author_id")), new Question(resultSet.getInt("question_id")), resultSet.getTimestamp("date_time")));

        return answers.isEmpty() ? Optional.empty() : Optional.of(answers.get(0));
    }

    @Override
    public Answer edit(Answer answer) {
        if (answer.getId() !=null)
            update(answer);

        return answer;
    }

    private void update(Answer answer) {
        template.update("UPDATE  answer SET  text=?  AND question_id=? AND author_id=? AND date_time =? WHERRE id=?",
                answer.getText(), answer.getQuestion().getId(),answer.getAuthor().getId(), answer.getDate());
    }


    private int insert(Answer answer) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(template);
        insert.setTableName("answer");
        insert.setGeneratedKeyName("id");

        Map<String, Object> data = new HashMap<>();
        data.put("text", answer.getText());
        data.put("author_id", answer.getAuthor().getId());
        data.put("date_time", answer.getDate());
        data.put("question_id",answer.getQuestion().getId());
        return insert.executeAndReturnKey(data).intValue();


    }

}
