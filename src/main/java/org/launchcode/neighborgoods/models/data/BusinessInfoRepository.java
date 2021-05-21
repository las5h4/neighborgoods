package org.launchcode.neighborgoods.models.data;

import org.launchcode.neighborgoods.models.BusinessCategories;
import org.springframework.data.repository.CrudRepository;

public interface BusinessInfoRepository extends CrudRepository<BusinessCategories, Integer> {
}
