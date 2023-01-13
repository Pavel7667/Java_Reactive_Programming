package org.reactor.assignment.assigmentSix;

import org.reactor.utils.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Assignment {

    public static void main(String[] args) {

        Set<String> allowedCategories = Set.of(
                "Science fiction",
                "Fantasy",
                "Suspense/Thriller"
        );

        bookStream()
                .filter(book -> allowedCategories.contains(book.getCategory()))
                .buffer(Duration.ofSeconds(1))
                .map(Assignment::revenueCalculator)
                .subscribe(Utils.subscriber());


        Utils.sleepSeconds(20);
    }


    private static RevenueReport revenueCalculator(List<BookOrder> books) {
        Map<String, Double> map = books.stream()
                .collect(Collectors.groupingBy(BookOrder::getCategory,
                        Collectors.summingDouble(BookOrder::getPrice)));
        return new RevenueReport(map);
    }


    public static Flux<BookOrder> bookStream() {
        return Flux.interval(Duration.ofMillis(10))
                .map(i -> new BookOrder());
    }
}
