package org.reactor.operators;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

public class c7DefaultIfEmpty {

    public static void main(String[] args) {

        getOrderNumbers().filter(i -> i > 10)
                .defaultIfEmpty(-100)
                .subscribeWith(Utils.subscriber());

        getOrderNumbers().filter(i -> i > 10)
                .switchIfEmpty(fallBack())
                .subscribeWith(Utils.subscriber());
    }
    // redis cache
    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 10);
    }
     // db
    private static Flux<Integer> fallBack() {
        return Flux.range(20, 5);
    }
}
