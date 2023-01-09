package org.reactor.mono;

import org.reactor.utils.Utils;
import reactor.core.publisher.Mono;

public class MonoEmptyOrError {
    public static void main(String[] args) {

        userRepository(1).subscribe(
                Utils.onNext(),
                Utils.onError(),
                Utils.onComplete()
        );

    }

    private static Mono<String> userRepository(int userID) {
        if (userID == 1) {
            return Mono.just(Utils.faker().name().firstName());
        } else if (userID == 2) {
            return Mono.empty(); // better version than NULL
        } else {
            return Mono.error(new RuntimeException("Not in Range"));
        }
    }
}
