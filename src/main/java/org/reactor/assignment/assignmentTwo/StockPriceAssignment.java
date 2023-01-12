package org.reactor.assignment.assignmentTwo;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class StockPriceAssignment {

    public static void main(String[] args) throws InterruptedException {

        // make interval splitter
        CountDownLatch latch = new CountDownLatch(1);

        StockPricePublisher.getPrice()
                .subscribeWith(new Subscriber<Integer>() {

                    private Subscription subscription;

                    /**
                     * Subscription with big Range
                     */
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        subscription.request(Long.MAX_VALUE);
                    }

                    /**
                     * What do in case get from Flux element
                     */
                    @Override
                    public void onNext(Integer price) {
                        System.out.println(LocalDateTime.now()+" Price : " + price);
                        if (price > 110 || price < 90) {
                            this.subscription.cancel();
                            latch.countDown();
                        }
                    }

                    /**
                     * countDown in case Error
                     */
                    @Override
                    public void onError(Throwable t) {
                        latch.countDown();
                    }

                    /**
                     * countDown in case Complete
                     */
                    @Override
                    public void onComplete() {
                        latch.countDown();
                    }
                });

        // wait until  latch.countDown();
        latch.await();

    }

}
