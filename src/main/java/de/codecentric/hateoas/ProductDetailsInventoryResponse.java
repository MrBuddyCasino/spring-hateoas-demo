package de.codecentric.hateoas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

@ApiModel
@Data
@Builder
public class ProductDetailsInventoryResponse extends ResourceSupport {

  @ApiModelProperty(required = true)
  private String plant;

  @ApiModelProperty(required = true)
  private String requirementCategory;

  @ApiModelProperty(required = true)
  private List<ProductAvailability> productAvailabilities;

  @JsonCreator
  public ProductDetailsInventoryResponse(
      @JsonProperty("plant") String plant,
      @JsonProperty("requirementCategory") String requirementCategory,
      @JsonProperty("productAvailabilities") List<ProductAvailability> productAvailabilities) {
    this.plant = plant;
    this.requirementCategory = requirementCategory;
    this.productAvailabilities = productAvailabilities;
  }

}
