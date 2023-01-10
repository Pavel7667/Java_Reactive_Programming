package org.reactor.operators.flatmap;

import reactor.core.publisher.Flux;

public class UserService {

    public static Flux<User> getUser(){
        return Flux.range(1, 2)
                .map(i -> new User(i));
    }
}
