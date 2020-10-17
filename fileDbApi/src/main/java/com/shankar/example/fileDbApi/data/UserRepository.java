package com.shankar.example.fileDbApi.data;

import com.shankar.example.fileDbApi.model.User;
import com.shankar.example.fileDbApi.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
//public interface UserRepository extends JpaRepository<User, Integer> {
//}