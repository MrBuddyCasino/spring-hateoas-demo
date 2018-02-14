package de.codecentric.hateoas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

@ApiModel
@Data
@Builder
public class ProductInventoryResponse extends ResourceSupport {

  @ApiModelProperty(required = true)
  private String product;

  @ApiModelProperty(required = true)
  private String plant;

  @ApiModelProperty(required = true)
  private String requirementCategory;

  @ApiModelProperty(required = true)
  private long totalQuantity;

  @ApiModelProperty(required = true)
  private long minimumQuantityAcrossSizes;

  public ProductInventoryResponse() {
  }

  @JsonCreator
  public ProductInventoryResponse(
      @JsonProperty("product") String product,
      @JsonProperty("plant") String plant,
      @JsonProperty("requirementCategory") String requirementCategory,
      @JsonProperty("totalQuantity") long totalQuantity,
      @JsonProperty("minimumQuantityAcrossSizes") long minimumQuantityAcrossSizes) {
    this.product = product;
    this.plant = plant;
    this.requirementCategory = requirementCategory;
    this.totalQuantity = totalQuantity;
    this.minimumQuantityAcrossSizes = minimumQuantityAcrossSizes;
  }
}
