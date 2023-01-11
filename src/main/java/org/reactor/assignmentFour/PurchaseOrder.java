package org.reactor.assignmentFour;

import lombok.Data;
import lombok.ToString;
import org.reactor.utils.Utils;

@Data
@ToString
public class PurchaseOrder {

    private String item;
    private double price;
    private String category;
    private int quantity;


    public PurchaseOrder() {

        this.item = Utils.faker().commerce().productName();
        this.price = Double.parseDouble(Utils.faker().commerce().price());
        this.category = Utils.faker().commerce().department();
        this.quantity = Utils.faker().random().nextInt(1, 10);
    }
}
