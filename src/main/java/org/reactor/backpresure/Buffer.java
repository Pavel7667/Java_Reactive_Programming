package org.reactor.backpresure;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Buffer {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    for (int i = 0; i < 501; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed :" + i);
                    }
                    fluxSink.complete();
                })
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Utils.sleepSeconds(3);
                })
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(60);
    }
}
