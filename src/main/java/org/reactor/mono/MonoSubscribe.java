package org.reactor.mono;

import org.reactor.utils.Utils;
import reactor.core.publisher.Mono;

public class MonoSubscribe {
    public static void main(String[] args) {

        // publisher with Error
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l ->l / 0);


        // 1.for onNext = Consumer<T> make action
        // 2. for err take error Message onError == catching StackTrace !!!
        // 3. terminated operation onCompiled
        mono.subscribe(
                Utils.onNext(),
                Utils.onError(),
                Utils.onComplete()
        );

    }

}
