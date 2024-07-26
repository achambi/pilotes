package com.tui.proof.controllers;

import com.tui.proof.repositories.entities.ClientEntity;
import com.tui.proof.services.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    @Autowired
    private ClientService clientService;

    /**
     * Create a new order
     * @param orderRequest
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@Valid  @RequestBody ClientEntity orderRequest, BindingResult result) {
        if(result.hasErrors()){
            return validate(result);
        }
        boolean invalidOrder = orderRequest.getOrders().stream()
                .anyMatch(order -> order.getPilotes() != 5 && order.getPilotes() != 10 && order.getPilotes() != 15);

        if (invalidOrder) {
            return ResponseEntity.badRequest()
                    .body(Collections.singletonMap("message", "Each order must have 5, 10, or 15 pilotes."));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.createOrder(orderRequest));
    }

//    /**
//     * Update an existing order
//     * @param firstName
//     * @return OrderResponds
//     */
//    @GetMapping("/search/{firstName}")
//    public List<OrderResponds> searchOrders(@PathVariable String firstName) {
//        return orderService.searchOrders(firstName);
//    }
//
//    /**
//     * Update an order , we use patch to update
//     * only the fields that we want
//     * @param order_id
//     * @param orderEntity
//     * @return
//     */
//    @PatchMapping("/orders/{order_id}")
//    public ResponseEntity<?> updateOrder(@PathVariable Long order_id, @RequestBody OrderEntity orderEntity) {
//        if (orderEntity.getCreated().plusMinutes(5).isBefore(LocalDateTime.now())) {
//            return ResponseEntity.badRequest()
//                    .body(Collections
//                            .singletonMap("message", "You can't update a order after 5 min."));
//        }
//        OrderResponds responds = orderService.updateOrder(order_id, orderEntity);
//        return new ResponseEntity<>(responds, HttpStatus.CREATED);
//    }

    /**
     * Metodo que valida la entrada del objeto
     * y ademas retorna un mensaje de error
     * @param result
     * @return
     */
    private static ResponseEntity<Map<String, String>> validate(BindingResult result) {
        Map<String,String> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(),"El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}