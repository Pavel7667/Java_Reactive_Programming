package org.reactor.operators.flatmap;

import org.reactor.utils.Utils;

public class c11FlatMap {
    public static void main(String[] args) {

        UserService.getUser()
                .concatMap(user -> OrderService.getOrders(user.getUserId()))
                .subscribe(Utils.subscriber());

    }
}
