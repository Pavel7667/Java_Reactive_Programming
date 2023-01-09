package org.reactor.mono;

import reactor.core.publisher.Mono;

public class MonoJust {
    public static void main(String[] args) {

        // publisher
        Mono<Integer> mono = Mono.just(1);

        System.out.println(mono); // same AS intermediate stream

        mono.subscribe(System.out::println); // same AS terminated stream
        mono.subscribe(i -> System.out.println("Received : " + i)); // lambda
    }
}
