package org.reactor.flux_section2;

import org.reactor.utils.Utils;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<String>> {

    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.fluxSink = stringFluxSink;
    }

    public void produce() {
        String name = Utils.faker().name().fullName();
        this.fluxSink.next(name);
    }


}
