package org.launchcode.neighborgoods.models.data;

import org.launchcode.neighborgoods.models.Business;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends CrudRepository <Business, Integer> {
}
