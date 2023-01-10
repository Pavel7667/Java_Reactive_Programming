package org.reactor.operators;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class c6TimeOut {

    public static void main(String[] args) {

        getOrderNumbers()
                .timeout(Duration.ofSeconds(2))
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(50);
    }
    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 100)
                .delayElements(Duration.ofSeconds(4));
    }

    private static Flux<Integer> fallBack(){
        return Flux.range(100, 10)
                .delayElements(Duration.ofMillis(200));
    }
}
