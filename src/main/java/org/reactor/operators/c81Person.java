package org.reactor.operators;

import lombok.Data;
import lombok.ToString;
import org.reactor.utils.Utils;

@Data
@ToString
public class c81Person {

    private String name;
    private int age;

    public c81Person() {
        this.name = Utils.faker().name().fullName();
        this.age = Utils.faker().random().nextInt(1, 30);
    }
}
