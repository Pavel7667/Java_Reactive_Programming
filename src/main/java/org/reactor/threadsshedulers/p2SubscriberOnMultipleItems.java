package org.reactor.threadsshedulers;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class p2SubscriberOnMultipleItems {


    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
            printThreadName("create ");
            for (int i = 0; i < 20; i++) {
                fluxSink.next(i); // creating of Subscribers
            }
            fluxSink.complete();
        }).doOnNext(i -> printThreadName("next " + i));

        // Realize run method for Thread
        Runnable runnable = () -> flux
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(v -> printThreadName("sub " + v));

        // Create are 5 Threads for Schedulers
        for (int i = 0; i < 5; i++) {
            new Thread(runnable).start();
        }

        Utils.sleepSeconds(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread :" + Thread.currentThread().getName());
    }
}