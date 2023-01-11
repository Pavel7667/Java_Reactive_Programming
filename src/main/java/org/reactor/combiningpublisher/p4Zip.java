package org.reactor.combiningpublisher;

import jdk.jshell.execution.Util;
import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

public class p4Zip {

    public static void main(String[] args) {

        Flux.zip(
                getBody(),
                getTires(),
                getEngine()
        )
//                .doOnNext(element->element.getT1().concat("12"))
                .subscribe(Utils.subscriber());
    }
    private static Flux<String> getBody() {
        return Flux.range(1, 5)
                .map(e -> "body");
    }
    private static Flux<String> getEngine() {
        return Flux.range(1, 2)
                .map(e -> "Engine");
    }
    private static Flux<String> getTires() {
        return Flux.range(1, 6)
                .map(e -> "Tires");
    }
}
