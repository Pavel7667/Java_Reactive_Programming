package org.reactor.flux;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * In this Example we see that in List we block and wait till all Elements
 * un-blocking and then given result
 * <p>
 * In Flux, we don't wait until all Elements done we Get result as soon as
 * this come to us
 *
 */
public class ListVsFlux {

    public static void main(String[] args) {
        List<String> names = NameGeneratorDemo.getNames(5);
        System.out.println(names);

        NameGeneratorDemo.getNamesByFlux(5).subscribe(Utils.onNext());

    }


}
