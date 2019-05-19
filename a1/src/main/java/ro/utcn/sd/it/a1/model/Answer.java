package ro.utcn.sd.it.a1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data

@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    private Integer id;
    private Question question;
    private User author;
    private String text;
    private Timestamp date;

    public Answer(int id, String text, User author_id, Question question_id, Timestamp date_time) {
        this.id=id;
        this.text=text;
        this.author=author_id;
        this.question=question_id;
        this.date=date_time;
    }

    public Answer(String text, Question q, User user, Timestamp dateTime) {
        this.text=text;
        this.question=q;
        this.author=user;
        this.date=dateTime;
    }


    public Integer getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public Timestamp getDate() {
        return date;
    }

    public Question getQuestion() {
        return question;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
