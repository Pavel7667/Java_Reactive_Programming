package org.reactor.mono;

import org.reactor.utils.Utils;
import reactor.core.publisher.Mono;

public class SupplierRefactoring {

    public static void main(String[] args) {

        getName();
        getName().subscribe(Utils.onNext()); // call Terminate method
        getName();

    }


    /**
     * This method Build PipeLine without Terminate method.
     * In this case when we call this method, nothing happened at all
     * until we call Terminate method
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
