package de.codecentric.hateoas;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/inventory")
public class InventoryController {

  private final InventoryService inventoryService;

  @Autowired
  public InventoryController(InventoryService inventoryService) {
    this.inventoryService = inventoryService;
  }

  @ApiOperation("returns aggregated inventory for a product across all sizes")
  @RequestMapping(value = "/product/{articleNumber}", method = GET)
  public ProductInventoryResponse getProductInventory(
      @PathVariable String articleNumber,
      @RequestParam String plant,
      @RequestParam String requirementCategory) {

    ProductInventoryResponse response = inventoryService
        .getAggregatedInventory(articleNumber, plant, requirementCategory);

    response.add(linkTo(methodOn(InventoryController.class)
        .getProductInventory(articleNumber, plant, requirementCategory))
        .withSelfRel());

    response.add(linkTo(methodOn(InventoryController.class)
        .getProductInventoryDetails(articleNumber, plant, requirementCategory))
        .withRel("inventory-detail"));
    return response;
  }

  @ApiOperation("returns precise inventory for a product (per size)")
  @RequestMapping(path = "/product/{articleNumber}/details", method = GET)
  public ProductDetailsInventoryResponse getProductInventoryDetails(
      @PathVariable String articleNumber,
      @RequestParam String plant,
      @RequestParam String requirementCategory) {

    List<ProductAvailability> productAvailabilities = inventoryService
        .returnDetailedInventory(articleNumber, plant, requirementCategory);

    ProductDetailsInventoryResponse response = ProductDetailsInventoryResponse.builder()
        .plant(plant)
        .requirementCategory(requirementCategory)
        .productAvailabilities(productAvailabilities)
        .build();

    response.add(linkTo(methodOn(InventoryController.class)
        .getProductInventoryDetails(articleNumber, plant, requirementCategory))
        .withSelfRel());

    return response;
  }


}
