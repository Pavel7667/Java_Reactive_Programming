package org.reactor.batching;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class GroupingBy {
    public static void main(String[] args) {
        Flux.range(1, 40)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(i -> i % 2)// key 0,2
                .subscribe(gf -> process(gf, gf.key()));

        Utils.sleepSeconds(7);
    }
    private static void process(Flux<Integer> flux, int key) {
        flux.subscribe(i -> System.out.println("Key : " + key + ", Item " + i));
    }
}
