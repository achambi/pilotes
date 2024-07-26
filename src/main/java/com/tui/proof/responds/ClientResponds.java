package com.tui.proof.responds;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientResponds {
  private Long client_id;
  private String firstName;
  private String lastName;
  private String telephone;
  private String email;
  private List<AddressResponds> address;
  private List<OrderResponds> orders;
}
