package org.reactor.Sink;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SinkMulticast {
    public static void main(String[] args) {

        //  handle through which we would push items
        Sinks.Many<Object> sink = Sinks.many().multicast().onBackpressureBuffer();

        //  handle through which subscribers will receive items
        Flux<Object> flux = sink.asFlux();



        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you   ?");
        flux.subscribe(Utils.subscriber("sam"));
        flux.subscribe(Utils.subscriber("mike")); // will go
        sink.tryEmitNext("???");

    }
}
