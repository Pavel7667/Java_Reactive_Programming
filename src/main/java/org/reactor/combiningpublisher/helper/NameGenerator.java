package org.reactor.combiningpublisher.helper;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    private List<String> list = new ArrayList<>();

    public Flux<String> generateName(){
        return Flux.generate(stringSynchronousSink -> {
                    System.out.println("Generator fresh");
                    Utils.sleepSeconds(1);
                    String name = Utils.faker().name().firstName();
                    list.add(name);
                    stringSynchronousSink.next(name);
                })
                .cast(String.class)
                .startWith(getFromCache());
    }

    private Flux<String> getFromCache(){
        return Flux.fromIterable(list);
    }
}
