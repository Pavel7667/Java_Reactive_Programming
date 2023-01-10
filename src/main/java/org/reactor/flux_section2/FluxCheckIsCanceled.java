package org.reactor.flux_section2;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

public class FluxCheckIsCanceled {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
                    String country;
                    do {
                        country = Utils.faker().country().name();
                        System.out.println("pushing  !!! "+ country);
                        fluxSink.next(country);
                    } while (!country.toLowerCase().equals("canada"));
                })
                .take(4) // in this case subscriber doesn't work after 4
                .subscribe(Utils.subscriber());

    }
}
