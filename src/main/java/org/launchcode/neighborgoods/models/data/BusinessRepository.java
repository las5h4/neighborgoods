package org.launchcode.neighborgoods.models.data;

import org.launchcode.neighborgoods.models.Business;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessRepository extends CrudRepository <Business, Integer> {
    @Query(value="SELECT * FROM Business WHERE date_added <= SUBDATE(CURDATE(),1) Order by date_added desc Limit 5;",nativeQuery = true)
    List<Business> findByDateAdded();
}
