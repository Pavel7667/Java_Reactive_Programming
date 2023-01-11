package org.reactor.threadsshedulers;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class c5FluxInterval_NoteOn {

    public static void main(String[] args) {

        Flux.interval(Duration.ofSeconds(1))
                .subscribeOn(Schedulers.boundedElastic()) // u can change it
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(2);

    }
}
