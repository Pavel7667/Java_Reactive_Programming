package org.reactor.assignment.assignmentFour;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class RevenueService {

    private Map<String,Integer> db = new HashMap<>();

    public RevenueService(){
        db.put("Kids", 0);
        db.put("AutoMotive", 0);
    }

    public Consumer<PurchaseOrder> subscribeOrderStream(){
        return p -> db.computeIfPresent(p.getCategory(), (k, v) -> v + p.getPrice());
    }

    public Flux<String> revenueStream(){
        return Flux.interval(Duration.ofSeconds(2))
                .map(i -> db.toString());
    }
}
