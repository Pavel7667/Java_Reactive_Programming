package org.reactor.context;

import org.reactor.utils.Utils;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public class Ctx {

    public static void main(String[] args) {

        getWelcomeMessage()
                .contextWrite(Context.of("user","sam"))
                .subscribe(Utils.subscriber());
    }
    private static Mono<String> getWelcomeMessage() {
        return Mono.deferContextual(ctx -> {
            if (ctx.hasKey("user")) {
                return Mono.just("Welcome " + ctx.get("user"));
            } else {
                return Mono.error(new RuntimeException("someException"));
            }
        });
    }


}
