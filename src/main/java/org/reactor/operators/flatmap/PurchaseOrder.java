package org.reactor.operators.flatmap;

import lombok.Data;
import lombok.ToString;
import org.reactor.utils.Utils;

@Data
@ToString
public class PurchaseOrder {

    private String item;
    private String price;
    private int userId;

    public PurchaseOrder(int userId) {
        this.userId = userId;
        this.item = Utils.faker().commerce().productName();
        this.price = Utils.faker().commerce().price();
    }
}
