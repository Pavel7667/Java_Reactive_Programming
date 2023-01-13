package org.reactor.repeatretry;

import org.reactor.utils.Utils;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

public class RetryWhenAdvanced {

    public static void main(String[] args) {
        orderService(Utils.faker().business().creditCardNumber())
                .retryWhen(Retry.from(
                        flux -> flux.doOnNext(retrySignal -> {
                                    System.out.println(retrySignal.totalRetries());
                                    System.out.println(retrySignal.failure());
                                })
                                .handle((retrySignal, synchronousSink) -> {
                                    if (retrySignal.failure().getMessage().equals("500")) {
                                        synchronousSink.next(1);
                                    } else {
                                        synchronousSink.error(retrySignal.failure());
                                    }
                                })
                                .delayElements(Duration.ofSeconds(1))
                )).subscribe(Utils.subscriber());

        Utils.sleepSeconds(10);
    }


    //order service
    private static Mono<String> orderService(String ccNumber) {
        return Mono.fromSupplier(() -> {
            processPayment(ccNumber);
            return Utils.faker().idNumber().valid();
        });
    }

    //payment service
    private static void processPayment(String ccNumber) {
        int random = Utils.faker().random().nextInt(1, 10);
        if (random < 8) {
            throw new RuntimeException("500");
        } else if (random < 10) {
            throw new RuntimeException("404");
        }
    }
}
