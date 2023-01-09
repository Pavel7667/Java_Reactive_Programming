package org.reactor.flux;

import reactor.core.publisher.Flux;

public class MultipleSubscriber {

    public static void main(String[] args) {

        Flux<Integer> flux = Flux.just(1, 2, 3, 4);

        Flux<Integer> evenFlux = flux.filter(i -> i % 2 == 0);
        flux.subscribe(i -> System.out.println("Sub 1 : " + i));
        evenFlux.subscribe(i -> System.out.println("Sub 2 : " + i));

    }
}
