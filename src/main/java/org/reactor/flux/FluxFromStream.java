package org.reactor.flux;

import com.github.javafaker.Faker;
import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class FluxFromStream {

    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4);

        Stream<Integer> stream = list.stream();

//        stream.forEach(System.out::println);
        // IllegalStateException: stream has already been operated upon or closed
        //stream.forEach(System.out::println);

//        Flux<Integer> integerFlux = Flux.fromStream(stream);
//        integerFlux.subscribe(Utils.onNext());
        //IllegalStateException: stream has already been operated upon or closed
        //integerFlux.subscribe(Utils.onNext()); == SAME

        Flux<Integer> integerFluxSupplier = Flux.fromStream(()->list.stream());
        integerFluxSupplier.subscribe(Utils.onNext());
        integerFluxSupplier.subscribe(Utils.onNext());
    }


}
