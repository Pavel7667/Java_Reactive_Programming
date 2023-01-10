package org.reactor.flux_section2;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

public class FluxCreate {

    public static void main(String[] args) {
        // way to create a flux Stream

        Flux.create(fluxSink -> {
                    String country;
                    do {
                        country = Utils.faker().country().name();
                        fluxSink.next(country);
                    } while (!country.toLowerCase().equals("canada"));
                })
                .subscribe(Utils.subscriber());
    }
}
