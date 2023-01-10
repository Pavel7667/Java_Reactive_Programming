package org.reactor.operators;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

public class c2Callbacks {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
                    for (int i = 0; i < 5; i++) {
                        fluxSink.next(i);
                    }
                    fluxSink.complete();
                    System.out.println("--completed");
                })
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doFirst(() -> System.out.println("doFirst"))
                .doOnNext(o -> System.out.println("doOnNext " + o))
                .doOnSubscribe(s->System.out.println(s+"doOnSubscribe"))
                .doOnRequest(l->System.out.println(l+"doOnRequest"))
                .doOnError(System.out::println)
                .doOnTerminate(System.out::println)
                .doOnCancel(System.out::println)
                .doFinally(signalType -> System.out.println("doFinally"))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard"))
                .subscribe(Utils.subscriber());
    }
}
