package de.codecentric.hateoas;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

  public ProductInventoryResponse getAggregatedInventory(String product, String plant,
      String requirementCategory) {

    return emptyProduct(product, plant, requirementCategory);
  }

  public List<ProductAvailability> returnDetailedInventory(String product, String plant,
      String requirementCategory) {

    List<ProductAvailability> availabilitiesToHandle = new ArrayList<>();
    return availabilitiesToHandle;
  }

  private ProductInventoryResponse emptyProduct(String articleNumber, String plant,
      String requirementCategory) {
    ProductInventoryResponse res = new ProductInventoryResponse();
    res.setTotalQuantity(0);
    res.setMinimumQuantityAcrossSizes(0);
    res.setRequirementCategory(requirementCategory);
    res.setProduct(articleNumber);
    res.setPlant(plant);
    return res;
  }

}