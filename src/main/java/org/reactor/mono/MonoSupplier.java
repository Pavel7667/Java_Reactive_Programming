package org.reactor.mono;

import org.reactor.utils.Utils;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;

public class MonoSupplier {

    public static void main(String[] args) {

        // use only when you have data already
        //Mono<String> mono = Mono.just(getName());


        Mono<String> mono = Mono.fromSupplier(() -> getName());
        mono.subscribe(Utils.onNext());

        Callable<String> stringCallable = ()->getName();
        Mono.fromCallable(stringCallable).subscribe(Utils.onNext());
    }

    public static String getName() {
        System.out.println("Generate name..");
        return Utils.faker().name().fullName();
    }
}
