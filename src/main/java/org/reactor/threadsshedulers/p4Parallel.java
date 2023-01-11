package org.reactor.threadsshedulers;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class p4Parallel {

    public static void main(String[] args) {


        Flux.range(1,10)
                .parallel(3)
                .runOn(Schedulers.parallel())
                .doOnNext(i -> printThreadName("next" + i)) // publisher
                .sequential()
                .subscribe(v -> printThreadName("sub " + v)); // subscriber


        Utils.sleepSeconds(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread :" + Thread.currentThread().getName());
    }
}
