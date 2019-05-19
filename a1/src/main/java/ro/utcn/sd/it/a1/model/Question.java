package ro.utcn.sd.it.a1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;

import java.sql.Timestamp;
import java.util.Date;



@Data
//@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private Integer id;
    private String title;
    private String text;

    private User author;
    private Tag tag;
    private Timestamp date_time;

    public Question(int id, String title, String text, User author, Timestamp date_time) {
        this.id=id;
        this.title=title;
        this.author=author;
        this.text=text;
        this.date_time=date_time;
    }

    public Question(String title, User author, String text, Timestamp date_time) {
        this.title=title;
        this.author=author;
        this.text=text;
        this.date_time=date_time;
    }

    public Question(String title, User user, String text, Tag tag, Timestamp date_time) {
        this.title=title;
        this.author=user;
        this.text=text;
        this.date_time=date_time;
        this.tag=tag;
    }
    public Question(String title, User author, String text) {
        this.title=title;
        this.author=author;
        this.text=text;

    }

    public Question(int question_id) {
        this.id=question_id;
    }

    // private DateTimeFormat date;


}
