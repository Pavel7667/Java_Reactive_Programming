package org.reactor.Sink;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class SinkReplay {
    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.small","16");

        //  handle through which we would push items
        Sinks.Many<Object> sink = Sinks.many().replay().all(10);

        //  handle through which subscribers will receive items
        Flux<Object> flux = sink.asFlux();

        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you   ?");
        flux.subscribe(Utils.subscriber("sam"));
        flux.subscribe(Utils.subscriber("mike")); // will go
        sink.tryEmitNext("???");
    }
}
