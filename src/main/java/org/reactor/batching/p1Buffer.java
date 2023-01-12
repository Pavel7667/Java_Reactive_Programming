package org.reactor.batching;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class p1Buffer {

    public static void main(String[] args) {


        eventStream()
                .bufferTimeout(5,Duration.ofSeconds(1))
                .doOnNext(e-> System.out.println("list of "+e.size()))
                .subscribe(Utils.subscriber());

        Utils.sleepSeconds(2); // we're blocking main Thread to see Scheduler work
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofSeconds(20))
                .map(i -> "event : " + i);
    }
}
