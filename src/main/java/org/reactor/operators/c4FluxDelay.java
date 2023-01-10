package org.reactor.operators;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.util.concurrent.Queues;

import java.time.Duration;

public class c4FluxDelay {

    public static void main(String[] args) {

        //Queues -> as default as minimum to set 8 - (32)
        // for max 16 - 256
        System.setProperty("reactor.bufferSize.x","10");

        Flux.range(1, 100)
                .log()
                .delayElements(Duration.ofSeconds(1)) // 32 elements
                .subscribe(Utils.subscriber());
    }
}
