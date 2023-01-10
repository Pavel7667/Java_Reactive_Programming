package org.reactor.flux_section2;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

public class FluxTake {

    public static void main(String[] args) {


        Flux.range(1, 10)
                .log()
                .take(3) // after 3 elements cancel PipeLine
                .subscribe(Utils.subscriber());

    }
}
