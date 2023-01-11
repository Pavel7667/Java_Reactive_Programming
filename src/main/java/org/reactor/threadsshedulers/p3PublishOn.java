package org.reactor.threadsshedulers;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class p3PublishOn {

    public static void main(String[] args) {

        Flux<Object> flux = Flux.create(fluxSink -> {
            printThreadName("create ");
            for (int i = 0; i < 4; i++) {
                fluxSink.next(i); // creating of Subscribers
            }
            fluxSink.complete();
        }).doOnNext(i -> printThreadName("next " + i));


        flux
                .publishOn(Schedulers.parallel())
                .doOnNext(i -> printThreadName("next" + i))
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(v -> printThreadName("sub " + v));


        Utils.sleepSeconds(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread :" + Thread.currentThread().getName());
    }
}
