package org.reactor.mono;

import org.reactor.utils.Utils;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class MonoFromFuture {

    public static void main(String[] args) {

        Mono.fromFuture(getName())
                .subscribe(Utils.onNext());

        Utils.sleepSeconds(1);

    }
    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> Utils.faker().name().fullName());
    }
}
