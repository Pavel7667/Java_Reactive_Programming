package org.reactor.assignment.assignmentFour;

import lombok.Data;
import lombok.ToString;
import org.reactor.utils.Utils;

import java.util.Random;

@Data
@ToString
public class PurchaseOrder {

    private String item;
    private int price;
    private String category;
    private int quantity;


    public PurchaseOrder() {

        this.item = Utils.faker().commerce().productName();
        this.price = Utils.faker().random().nextInt(0, 100);
        this.category = Utils.faker().commerce().department();
        this.quantity = Utils.faker().random().nextInt(1, 10);
    }
}
