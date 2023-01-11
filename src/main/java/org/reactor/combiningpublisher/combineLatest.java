package org.reactor.combiningpublisher;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class combineLatest {
    public static void main(String[] args) {

        Flux.combineLatest(getString(), getNumbers(),
                (str, num) -> str + num
        ).subscribe(Utils.subscriber());

        Utils.sleepSeconds(70);
    }

    private static Flux<String> getString() {
        return Flux.just("A", "B", "C", "D", "E")
                .delayElements(Duration.ofSeconds(1));
    }

    private static Flux<Integer> getNumbers() {
        return Flux.just(1, 2, 3)
                .delayElements(Duration.ofSeconds(3));
    }
}
