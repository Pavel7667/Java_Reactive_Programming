package org.reactor.assignment.assignmentSeven;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class OrderProcessor {

    public static Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>> automotiveProcessing() {
        return flux -> flux
                .doOnNext(p -> p.setPrice(2 * p.getPrice()))
                .doOnNext(p -> p.setItem("{{    " + p.getItem() + " }}"));
    }

    public static Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>> kidsProcessing() {
        return flux -> flux
                .doOnNext(p -> p.setPrice(4 * p.getPrice()))
                .flatMap(p -> Flux.concat(Mono.just(p), getFreeKidsOrder()));
    }

    private static Mono<PurchaseOrder> getFreeKidsOrder() {
        return Mono.fromSupplier(() -> {
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setItem("Free - " + purchaseOrder.getItem());
            purchaseOrder.setPrice(0);
            purchaseOrder.setCategory("Kids");
            return purchaseOrder;
        });
    }
}
