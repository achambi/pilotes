package com.tui.proof.responds;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressResponds {
  private ClientResponds client;
  private String street;
  private String postcode;
  private String city;
  private String country;
}
