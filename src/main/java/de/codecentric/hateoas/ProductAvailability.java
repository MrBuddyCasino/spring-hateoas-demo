package de.codecentric.hateoas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductAvailability {

  private String size;

  private List<DeliveryDate> deliveryDates;

  @JsonCreator
  public ProductAvailability(
      @JsonProperty String size,
      @JsonProperty List<DeliveryDate> deliveryDates) {
    this.size = size;
    this.deliveryDates = deliveryDates;
  }
}
