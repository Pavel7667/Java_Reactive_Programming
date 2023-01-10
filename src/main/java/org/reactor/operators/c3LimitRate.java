package org.reactor.operators;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

public class c3LimitRate {
    public static void main(String[] args) {

        Flux.range(1, 100)
                .log()
                .limitRate(13) // 75 %
                .subscribe(Utils.subscriber());

    }
}
