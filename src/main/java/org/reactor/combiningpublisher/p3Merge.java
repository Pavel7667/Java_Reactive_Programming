package org.reactor.combiningpublisher;

import jdk.jshell.execution.Util;
import org.reactor.combiningpublisher.helper.AmericanAirlines;
import org.reactor.combiningpublisher.helper.Emirates;
import org.reactor.combiningpublisher.helper.QatarFlights;
import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

public class p3Merge {

    public static void main(String[] args) {

        Flux<String> merge = Flux.merge(
                QatarFlights.getFlights(),
                Emirates.getFlights(),
                AmericanAirlines.getFlights()
        );

        merge.subscribe(Utils.subscriber());

        Utils.sleepSeconds(10);
    }
}
