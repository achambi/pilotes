package com.tui.proof.repositories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long order_id;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private ClientEntity client;

  @NotBlank
  @NotEmpty
  private int pilotes;

  @NotBlank
  @NotEmpty
  private double orderTotal;

  @NotBlank
  @NotEmpty
  private LocalDateTime created;
}
