package org.reactor.batching;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class p2Window {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {

        eventStream()
                .window(Duration.ofSeconds(2))
                .flatMap(flux->saveEvents(flux))
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(10); // we're blocking main Thread to see Scheduler work
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(500))
                .map(i -> "event : " + i);
    }

    private static Mono<Integer> saveEvents(Flux<String> flux) {
        return flux
                .doOnNext(e -> System.out.println("saving" + e))
                .doOnComplete(() -> {
                    System.out.println("saved this batch");
                    System.out.println("------------");
                }).then(Mono.just(atomicInteger.getAndIncrement()));
    }
}

