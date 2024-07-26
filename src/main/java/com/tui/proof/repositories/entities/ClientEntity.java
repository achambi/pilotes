package com.tui.proof.repositories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "client")
public class ClientEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long client_id;

  @NotBlank
  @NotEmpty
  private String firstName;

  @NotBlank
  @NotEmpty
  private String lastName;

  @NotBlank
  @NotEmpty
  private String telephone;

  @NotBlank
  @NotEmpty
  private String email;

  @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<OrderEntity> orders;

  @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<AddressEntity> address;
}
