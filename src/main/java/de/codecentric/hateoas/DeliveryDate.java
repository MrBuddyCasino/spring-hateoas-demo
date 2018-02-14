package de.codecentric.hateoas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeliveryDate {

  private int quantity;

  private LocalDate deliveryDate;

  @JsonCreator
  public DeliveryDate(@JsonProperty int quantity, @JsonProperty LocalDate deliveryDate) {
    this.quantity = quantity;
    this.deliveryDate = deliveryDate;
  }
}
