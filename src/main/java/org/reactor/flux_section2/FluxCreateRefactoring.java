package org.reactor.flux_section2;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

public class FluxCreateRefactoring {

    public static void main(String[] args) {

        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer)
                .subscribe(Utils.subscriber());

        Runnable runnable = nameProducer::produce;


        for (int i = 0; i <10 ; i++) {
            new Thread(runnable).start();
        }

        Utils.sleepSeconds(2);
    }
}
