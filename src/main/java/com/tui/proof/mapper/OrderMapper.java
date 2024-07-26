package com.tui.proof.mapper;

import com.tui.proof.repositories.entities.ClientEntity;
import com.tui.proof.responds.ClientResponds;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    ClientResponds entityToOrderResponse(ClientEntity order);
}