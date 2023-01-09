package org.reactor.flux;

import org.reactivestreams.Subscriber;
import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;
import org.reactivestreams.Subscription;


import java.util.concurrent.atomic.AtomicReference;

public class SubscriptionDemo {

    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();

        Flux.range(1, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Show Sub : " + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext : "+ integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError : "+throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed FLUX");
                    }
                });

        Utils.sleepSeconds(3);
        atomicReference.get().request(3);
        Utils.sleepSeconds(5);
        atomicReference.get().request(3);
        Utils.sleepSeconds(5);
        System.out.println("going to cancel");
        atomicReference.get().cancel();
        Utils.sleepSeconds(3);
        atomicReference.get().request(4);
        Utils.sleepSeconds(3);
    }
}
