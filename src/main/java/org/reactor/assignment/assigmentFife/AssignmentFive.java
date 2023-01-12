package org.reactor.assignment.assigmentFife;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class AssignmentFive {

    public static void main(String[] args) {

        final int carPrice = 10_000;

        Flux.combineLatest(monthStream(), demandStream(), (month, demand) -> {
                    return (carPrice - (month * 100)) * demand;
                })
                .subscribe(Utils.subscriber());

Utils.sleepSeconds(20);
    }

    private static Flux<Long> monthStream() {
        return Flux.interval(Duration.ZERO, Duration.ofSeconds(1));
    }

    private static Flux<Double> demandStream() {
        return Flux.interval(Duration.ofSeconds(3))
                .map(i -> Utils.faker().random().nextInt(80, 120) / 100d)
                .startWith(1d);
    }
}
