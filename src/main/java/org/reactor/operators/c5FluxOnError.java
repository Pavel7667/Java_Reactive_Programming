package org.reactor.operators;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class c5FluxOnError {
    public static void main(String[] args) {


        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (3 - i))
//              .onErrorReturn(-1)// in case Error get -1
//              .onErrorResume(e->fallback())// in case Error call this Method
                .onErrorContinue(((throwable, o) -> {
                    // we can catch here Exception
                }))
                .subscribe(Utils.subscriber());
    }

    public static Mono<Integer> fallback() {
        return Mono.fromSupplier(()->Utils.faker().random().nextInt(100,200));
    }
}




