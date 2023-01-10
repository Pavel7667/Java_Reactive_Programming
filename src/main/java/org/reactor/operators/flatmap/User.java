package org.reactor.operators.flatmap;

import lombok.Data;
import lombok.ToString;
import org.reactor.utils.Utils;

@Data
@ToString
public class User {

    private int userId;
    private String name;

    public User(int userId){
        this.userId = userId;
        this.name = Utils.faker().name().fullName();
    }

}
