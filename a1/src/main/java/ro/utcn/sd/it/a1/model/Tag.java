package ro.utcn.sd.it.a1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    private Integer id;
    private String name;



    public Tag(int tag) {

        this.id=tag;
    }

    public Tag(String t) {

        this.name=t;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id= id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
