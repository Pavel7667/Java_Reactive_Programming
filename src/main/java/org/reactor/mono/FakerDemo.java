package org.reactor.mono;

import com.github.javafaker.Faker;

/**
 * Class for generating Random different values
 */
public class FakerDemo {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(Faker.instance().name().fullName());
        }
    }
}
