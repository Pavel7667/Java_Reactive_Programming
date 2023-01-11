package org.reactor.coldhotpublusher;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class c4HotPublishAutoConnect {

    public static void main(String[] args) {

        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2))
                .publish()
                .autoConnect(0);

        movieStream.subscribe(Utils.subscriber("sam"));

        Utils.sleepSeconds(5);

        movieStream.subscribeWith(Utils.subscriber("mike"));

        Utils.sleepSeconds(50);
    }

    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming");
        return Stream.of(
                "scene1",
                "scene2",
                "scene3",
                "scene4",
                "scene5",
                "scene6",
                "scene7"
        );
    }
}
