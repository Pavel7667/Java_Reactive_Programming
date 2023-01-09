package org.reactor.flux;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

public class FluxRange {

    public static void main(String[] args) {

        Flux.range(0, 100)
                .log()
                .map(i -> Utils.faker().name().fullName())
                .log()
                .subscribe(Utils.onNext());
    }
}
