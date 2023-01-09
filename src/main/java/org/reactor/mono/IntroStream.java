package org.reactor.mono;

import java.util.stream.Stream;

public class IntroStream {
    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1)
                .map(e -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    return e * 2;
                });

        System.out.println(stream); // intermediate stream
        stream.forEach(System.out::println); // terminated stream
    }
}
