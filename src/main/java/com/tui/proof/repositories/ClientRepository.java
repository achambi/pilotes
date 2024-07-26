package com.tui.proof.repositories;

import com.tui.proof.repositories.entities.ClientEntity;
import com.tui.proof.repositories.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
//    @Query("SELECT o FROM orders o WHERE o.client.firstName LIKE :firstName")
//    List<OrderEntity> findByFirstName(@Param("firstName") String firstName);
}