package org.reactor.threadsshedulers;

import reactor.core.publisher.Flux;

public class p1ThreadDemo {

    public static void main(String[] args) {
        Flux<Object> flux= Flux.create(fluxSink -> {
            printThreadName("create ");
            fluxSink.next(1);
        }).doOnNext(i -> printThreadName("next " + i));

        flux.subscribe(v -> printThreadName("sub " + v));
    }

    private static void printThreadName(String msg) {
        System.out.println(msg+"\t\t: Thread :"+Thread.currentThread().getName());
    }
}
