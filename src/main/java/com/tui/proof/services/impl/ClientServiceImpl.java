package com.tui.proof.services.impl;

import com.tui.proof.mapper.OrderMapper;
import com.tui.proof.repositories.ClientRepository;
import com.tui.proof.repositories.entities.ClientEntity;
import com.tui.proof.responds.ClientResponds;
import com.tui.proof.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderMapper mapper;

    @Override
    public ClientResponds createOrder(ClientEntity ordersRequest) {

        Optional<ClientEntity> savedOrder = Optional.of(clientRepository.saveAndFlush(ordersRequest));
        return savedOrder.map(mapper::entityToOrderResponse).orElse(new ClientResponds());
    }


//    @Override
//    public List<OrderResponds> searchOrders(String firstName) {
//        List<OrderEntity> responds = orderRepository.findByFirstName(firstName);
//        return responds.stream().map(mapper::entityToOrderResponse).collect(Collectors.toList());
//    }

//    public OrderResponds updateOrder(Long order_id, OrderEntity orderUpdates) {
//
//        Optional<OrderEntity> existingOrder = orderRepository.findById(order_id);
//        if(existingOrder.isEmpty()) {
//            throw new RuntimeException("Order not found");
//        }
//
//        OrderEntity orderToUpdate = existingOrder.get();
//        orderToUpdate.setPilotes(orderUpdates.getPilotes());
//        orderToUpdate.setCreated(orderUpdates.getCreated());
//        orderToUpdate.setOrderTotal(orderUpdates.getOrderTotal());
//
//        Optional<OrderEntity> responds = Optional.of(orderRepository.saveAndFlush(orderToUpdate));
//        return responds.map(mapper::entityToOrderResponse).orElse(new OrderResponds());
//    }

}
