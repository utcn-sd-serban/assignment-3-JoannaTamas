package ro.utcn.sd.it.a1.dto;


import lombok.Data;
import ro.utcn.sd.it.a1.model.Question;
import ro.utcn.sd.it.a1.model.Tag;
import ro.utcn.sd.it.a1.model.User;
import ro.utcn.sd.it.a1.persistance.api.RepositoryFactory;

import java.sql.Timestamp;

@Data
public class QuestionDTO {

    private Integer id;
    private String title;
    private String text;
    private String author;
    //  private User author;
    private Tag tag;
    private Timestamp date_time;

    private static RepositoryFactory repository;

    public static QuestionDTO ofEntity(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(question.getId());
        questionDTO.setAuthor(question.getAuthor().getUsername());
        questionDTO.setTitle(question.getTitle());
        questionDTO.setText(question.getText());
        questionDTO.setDate_time(question.getDate_time());
        questionDTO.setTag(question.getTag());

        return questionDTO;
    }


}
