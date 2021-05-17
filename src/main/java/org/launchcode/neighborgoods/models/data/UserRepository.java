package org.launchcode.neighborgoods.models.data;

import org.springframework.data.repository.CrudRepository;
import org.launchcode.neighborgoods.models.User;


public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}