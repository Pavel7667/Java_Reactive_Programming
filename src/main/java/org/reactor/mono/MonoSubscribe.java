package org.reactor.mono;

import reactor.core.publisher.Mono;

public class MonoSubscribe {
    public static void main(String[] args) {

        // publisher
        Mono<String> mono = Mono.just("ball");

        //1 no action
        mono.subscribe();

        //2).
        // 1.for onNext = Consumer<T> make action
        // 2. for err take error Message onError
        // 3. terminated operation onCompiled
        mono.subscribe(
                item -> System.out.println(item),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );
    }

}
