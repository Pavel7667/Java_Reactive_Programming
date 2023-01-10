package org.reactor.flux_section2;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

public class FluxGenerateAssignment {

    public static void main(String[] args) {

        Flux.generate(() -> 1,
                (counter, synchronousSink) -> {
                    String country = Utils.faker().country().name();
                    System.out.println("push " + counter);
                    synchronousSink.next(country);
                    if (country.toLowerCase().equals("canada") || counter >=10) {
                        synchronousSink.complete();
                    }
                    return ++counter;
                }).subscribe(Utils.subscriber());
    }
}
