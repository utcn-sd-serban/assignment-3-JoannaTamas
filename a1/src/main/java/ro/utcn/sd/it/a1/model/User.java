package ro.utcn.sd.it.a1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class User {
    private Integer id;
   private String username;
   private String password;


    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(Integer id) {
        this.id=id;
        this.username=null;
        this.password=null;


    }


}
