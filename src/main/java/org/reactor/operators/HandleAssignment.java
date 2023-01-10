package org.reactor.operators;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

public class HandleAssignment {

    public static void main(String[] args) {

        Flux.generate(synchronousSink ->
                        synchronousSink.next(Utils.faker().country().name()))
                .map(Object::toString)
                .handle(((s, synchronousSink) -> {
                    synchronousSink.next(s);
                    if (s.toLowerCase().equals("canada")) {
                        synchronousSink.complete();
                    }
                })).subscribeWith(Utils.subscriber());

    }
}
