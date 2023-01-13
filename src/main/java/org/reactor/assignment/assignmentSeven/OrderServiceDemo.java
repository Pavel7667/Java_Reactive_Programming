package org.reactor.assignment.assignmentSeven;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class OrderServiceDemo {

    public static Flux<PurchaseOrder> orderStream(){
        return Flux.interval(Duration.ofMillis(100))
                .map(i -> new PurchaseOrder());
    }


}
