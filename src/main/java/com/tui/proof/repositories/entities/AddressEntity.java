package com.tui.proof.repositories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class AddressEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long address_id;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private ClientEntity client;

  @NotBlank
  @NotEmpty
  private String street;

  @NotBlank
  @NotEmpty
  private String postcode;

  @NotBlank
  @NotEmpty
  private String city;

  @NotBlank
  @NotEmpty
  private String country;
}
