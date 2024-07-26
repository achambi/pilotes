package com.tui.proof.responds;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponds {
  private Long order_id;
  private ClientResponds client;
  private int pilotes;
  private double orderTotal;
  private LocalDateTime created;
}
