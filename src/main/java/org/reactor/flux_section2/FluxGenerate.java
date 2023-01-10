package org.reactor.flux_section2;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

public class FluxGenerate {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
                    synchronousSink.next(Utils.faker().country().name());
//                    synchronousSink.next() //can use only one instance
                    synchronousSink.complete(); // way to stop
                })
                .take(4) // way to stop
                .subscribe(Utils.subscriber());

    }
}
