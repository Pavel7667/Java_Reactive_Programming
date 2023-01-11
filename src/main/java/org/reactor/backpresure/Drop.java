package org.reactor.backpresure;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.util.concurrent.Queues;

import java.util.ArrayList;
import java.util.List;

public class Drop {

    public static void main(String[] args) {

//        Queues
        System.setProperty("reactor.bufferSize.small","16");

        List<Object> list = new ArrayList<>();

        Flux.create(fluxSink -> {
                    for (int i = 1; i < 501; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed :" + i);
                        Utils.sleepMills(1);
                    }
                    fluxSink.complete();
                })
                .onBackpressureDrop(list::add)
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Utils.sleepMills(10);
                })
                .subscribe(Utils.subscriber());


        Utils.sleepSeconds(3);
        System.out.println(list);


    }
}
