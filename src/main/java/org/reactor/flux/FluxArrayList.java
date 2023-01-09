package org.reactor.flux;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class FluxArrayList {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("a", "b", "c");

        Flux.fromIterable(strings).subscribe(Utils.onNext());

        Integer[] arr = {1,2,3,4};
        Flux.fromArray(arr).subscribe(Utils.onNext());
    }


}
