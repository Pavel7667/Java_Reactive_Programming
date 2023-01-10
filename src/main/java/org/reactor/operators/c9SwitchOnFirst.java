package org.reactor.operators;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class c9SwitchOnFirst {

    public static void main(String[] args) {

        getPerson()
                .switchOnFirst((signal, c81PersonFlux) -> {
                    return (signal.isOnNext() && signal.get().getAge() > 20) ?
                            c81PersonFlux :
                            applyFilterMap().apply(c81PersonFlux);
                })
                .subscribeWith(Utils.subscriber());
    }
    public static Flux<c81Person> getPerson() {
        return Flux.range(1, 10)
                .map(i -> new c81Person());
    }
    public static Function<Flux<c81Person>, Flux<c81Person>> applyFilterMap() {
        return flux -> flux
                .filter(e -> e.getAge() > 10)
                .doOnNext(p -> p.setName(p.getName().toUpperCase()))
                .doOnDiscard(c81Person.class, e -> System.out.println(e + " not in filter"));
    }
}

