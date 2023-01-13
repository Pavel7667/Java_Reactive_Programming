package org.reactor.assignment.assignmentSeven;

import lombok.Data;
import lombok.ToString;
import org.reactor.utils.Utils;

@Data
@ToString
public class PurchaseOrder {

    private String item;
    private double price;
    private String category;

    public PurchaseOrder() {
        this.item = Utils.faker().commerce().productName();
        this.price = (Utils.faker().random().nextDouble());
        this.category = Utils.faker().commerce().department();
    }
}
