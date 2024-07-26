package com.tui.proof.mapper;

import com.tui.proof.repositories.entities.AddressEntity;
import com.tui.proof.repositories.entities.ClientEntity;
import com.tui.proof.repositories.entities.OrderEntity;
import com.tui.proof.responds.AddressResponds;
import com.tui.proof.responds.ClientResponds;
import com.tui.proof.responds.OrderResponds;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-26T15:53:50-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public ClientResponds entityToOrderResponse(ClientEntity order) {
        if ( order == null ) {
            return null;
        }

        ClientResponds clientResponds = new ClientResponds();

        clientResponds.setClient_id( order.getClient_id() );
        clientResponds.setFirstName( order.getFirstName() );
        clientResponds.setLastName( order.getLastName() );
        clientResponds.setTelephone( order.getTelephone() );
        clientResponds.setEmail( order.getEmail() );
        clientResponds.setAddress( addressEntityListToAddressRespondsList( order.getAddress() ) );
        clientResponds.setOrders( orderEntityListToOrderRespondsList( order.getOrders() ) );

        return clientResponds;
    }

    protected AddressResponds addressEntityToAddressResponds(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        AddressResponds addressResponds = new AddressResponds();

        addressResponds.setClient( entityToOrderResponse( addressEntity.getClient() ) );
        addressResponds.setStreet( addressEntity.getStreet() );
        addressResponds.setPostcode( addressEntity.getPostcode() );
        addressResponds.setCity( addressEntity.getCity() );
        addressResponds.setCountry( addressEntity.getCountry() );

        return addressResponds;
    }

    protected List<AddressResponds> addressEntityListToAddressRespondsList(List<AddressEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressResponds> list1 = new ArrayList<AddressResponds>( list.size() );
        for ( AddressEntity addressEntity : list ) {
            list1.add( addressEntityToAddressResponds( addressEntity ) );
        }

        return list1;
    }

    protected OrderResponds orderEntityToOrderResponds(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        OrderResponds orderResponds = new OrderResponds();

        orderResponds.setOrder_id( orderEntity.getOrder_id() );
        orderResponds.setClient( entityToOrderResponse( orderEntity.getClient() ) );
        orderResponds.setPilotes( orderEntity.getPilotes() );
        orderResponds.setOrderTotal( orderEntity.getOrderTotal() );
        orderResponds.setCreated( orderEntity.getCreated() );

        return orderResponds;
    }

    protected List<OrderResponds> orderEntityListToOrderRespondsList(List<OrderEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderResponds> list1 = new ArrayList<OrderResponds>( list.size() );
        for ( OrderEntity orderEntity : list ) {
            list1.add( orderEntityToOrderResponds( orderEntity ) );
        }

        return list1;
    }
}
