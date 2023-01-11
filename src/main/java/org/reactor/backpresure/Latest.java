package org.reactor.backpresure;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Latest {


    public static void main(String[] args) {

//        Queues
        System.setProperty("reactor.bufferSize.small","16");


        Flux.create(fluxSink -> {
                    for (int i = 1; i < 201; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed :" + i);
                        Utils.sleepMills(1);
                    }
                    fluxSink.complete();
                })
                .onBackpressureLatest()
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Utils.sleepMills(10);
                })
                .subscribe(Utils.subscriber());


        Utils.sleepSeconds(3);



    }
}