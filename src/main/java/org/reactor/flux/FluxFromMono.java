package org.reactor.flux;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxFromMono {

    public static void main(String[] args) {

        Mono<String> mono = Mono.just("a");
//        doSomething(flux); // how convert
        Flux<String> flux = Flux.from(mono);
        doSomething(flux);
        flux.subscribe(Utils.onNext());
    }

    private static void doSomething(Flux<String> flux) {

    }
}
