package org.reactor.assignmentTwo;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class StockPricePublisher {

    /**
     * Generate a Random value for Price
     */
    public static Flux<Integer> getPrice() {
        AtomicInteger atomicInteger = new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> atomicInteger.getAndAccumulate(
                        Utils.faker().random().nextInt(-5, 5),
                        Integer::sum));
    }
}