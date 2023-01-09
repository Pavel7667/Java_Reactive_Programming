package org.reactor.mono;

import org.reactor.utils.Utils;
import reactor.core.publisher.Mono;

public class MonoFromRunnable {

    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println("");

        Mono.fromRunnable(timeConsumerProcess()).subscribe(
                Utils.onNext(),
                Utils.onError(),
                ()-> {
                    System.out.println("process is done");
                }
        );
    }

    private static Runnable timeConsumerProcess(){
        return () -> {
            Utils.sleepSeconds(3);
            System.out.println("Operation complited");
        };
    }
}
