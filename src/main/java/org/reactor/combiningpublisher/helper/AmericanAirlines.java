package org.reactor.combiningpublisher.helper;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class AmericanAirlines {

    public static Flux<String> getFlights() {
        return Flux.range(1, Utils.faker().random().nextInt(1, 15))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "America " + Utils.faker().random().nextInt(100, 999))
                .filter(i -> Utils.faker().random().nextBoolean());
    }
}
