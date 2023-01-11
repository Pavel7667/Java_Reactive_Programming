package org.reactor.backpresure;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class OnError {

    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small","16");
        Flux.create(fluxSink -> {
                    for (int i = 1; i < 201 && !fluxSink.isCancelled(); i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed :" + i);
                        Utils.sleepMills(1);
                    }
                    fluxSink.complete();
                })
                .onBackpressureError()
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Utils.sleepMills(10);
                })
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(3);



    }
}
