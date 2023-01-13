package org.reactor.Sink;

import org.reactor.utils.Utils;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class SinkOneDemo {

    public static void main(String[] args) {

        // mono 1 value / empty / error
        Sinks.One<Object> sink = Sinks.one();
        Mono<Object> mono = sink.asMono();
        mono.subscribe(Utils.subscriber("sam"));

        sink.emitValue("hi", ((signalType, emitResult) -> {
            System.out.println(signalType.name());
            System.out.println(emitResult.name());
            return false;
        }));

        sink.emitValue("hello", ((signalType, emitResult) -> {
            System.out.println(signalType.name());
            System.out.println(emitResult.name());
            return false;
        }));
    }
}
