package com.sylvainhu.project.dao;

import com.sylvainhu.project.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
