package org.reactor.combiningpublisher;

import org.reactor.combiningpublisher.helper.NameGenerator;
import org.reactor.utils.Utils;

public class p1StartWith {

    public static void main(String[] args) {

        NameGenerator generator = new NameGenerator();
        generator.generateName()
                .take(1)
                .subscribe(Utils.subscriber("sam"));

        generator.generateName()
                .take(2)
                .subscribe(Utils.subscriber("mike"));

        generator.generateName()
                .take(5)
                .subscribe(Utils.subscriber("Jake"));

        generator.generateName()
                .filter(name->name.startsWith("A"))
                .take(1)
                .subscribe(Utils.subscriber("Marshal"));

    }

}
