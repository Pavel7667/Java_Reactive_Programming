package org.reactor.batching;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class p1Buffer {

    public static void main(String[] args) {


        eventStream()
                .buffer(Duration.ofSeconds(2))
                .doOnNext(e-> System.out.println("list of "+e.size()))
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(10); // we're blocking main Thread to see Scheduler work
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(200))
                .map(i -> "event : " + i);
    }
}
