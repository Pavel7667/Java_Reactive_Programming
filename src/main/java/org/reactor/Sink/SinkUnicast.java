package org.reactor.Sink;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SinkUnicast {

    public static void main(String[] args) {

        //  handle through which we would push items
        Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

        //  handle through which subscribers will receive items
        Flux<Object> flux = sink.asFlux();

        flux.subscribe(Utils.subscriber("sam"));
        flux.subscribe(Utils.subscriber("mike")); // will throw

        //mike  Error : java.lang.IllegalStateException: UnicastProcessor allows only a single Subscriber

        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you   ?");
        sink.tryEmitNext("???");
    }
}
