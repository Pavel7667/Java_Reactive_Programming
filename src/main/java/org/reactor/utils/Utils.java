package org.reactor.utils;

import com.github.javafaker.Faker;

import java.util.function.Consumer;

/**
 * Utils class with some View methods to show some SOUT response
 */
public class Utils {

    public static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext() {
        return o -> System.out.println("Received : " + o);
    }

    public static Consumer<Throwable> onError() {
        return err -> System.out.println("ERROR : " + err.getMessage());
    }

    public static Runnable onComplete() {
        return () -> System.out.println("Completed !!!");
    }

    public  static Faker faker(){
        return FAKER;
    }
}
