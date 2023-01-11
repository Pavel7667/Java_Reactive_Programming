package org.reactor.combiningpublisher;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

public class p2Concat {

    public static void main(String[] args) {

        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.error(new RuntimeException("will stop concat"));
        Flux<String> flux3 = Flux.just("c", "d", "e");

        Flux<String> stringFlux = Flux.concatDelayError(flux1, flux2, flux3);

        stringFlux.subscribe(Utils.subscriber());

    }
}
