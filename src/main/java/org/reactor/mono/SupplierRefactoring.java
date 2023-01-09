package org.reactor.mono;

import org.reactor.utils.Utils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class SupplierRefactoring {

    public static void main(String[] args) {

        getName();
        String name = getName()
                .subscribeOn(Schedulers.boundedElastic()) // add Asynchronous
                .block();
        System.out.println(name);
        getName();

    }


    /**
     * This method Build PipeLine without Terminate method.
     * In this case when we call this method, nothing happened at all
     * until we call Terminate method
     *
     * @return random name
     */
    public static Mono<String> getName() {
        System.out.println("eneret get Name method");
        return Mono.fromSupplier(() -> {
            System.out.println("Genereating name..");
            Utils.sleepSeconds(3);
            return Utils.faker().name().fullName();
        }).map(String::toUpperCase);
    }

}
