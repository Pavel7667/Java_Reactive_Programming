package org.reactor.repeatretry;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Retry {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        getInteger()
                .retry(2)
                .subscribe(Utils.subscriber());
    }
    private static Flux<Integer> getInteger() {

        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("Subscribe"))
                .doOnComplete(() -> System.out.println("Complete"))
                .map(integer -> integer / 0)
                .doOnError(err -> System.out.println(err.getMessage()));
    }
}

