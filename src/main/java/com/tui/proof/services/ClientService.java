package com.tui.proof.services;

import com.tui.proof.repositories.entities.ClientEntity;
import com.tui.proof.responds.ClientResponds;


public interface ClientService {
    ClientResponds createOrder(ClientEntity ordersRequest);

//    OrderResponds updateOrder(Long order_id, OrderEntity order);
//
//    List<OrderResponds> searchOrders(String firstName);
}
