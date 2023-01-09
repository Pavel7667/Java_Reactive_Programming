package org.reactor.flux;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

public class FlexIntro {

    public static void main(String[] args) {

        Flux<Object> flux = Flux.just(1,2,"2",Utils.faker().name().fullName());

        flux.subscribe(
                Utils.onNext(),
                Utils.onError(),
                Utils.onComplete());
    }
}
