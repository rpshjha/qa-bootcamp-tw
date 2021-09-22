package com.vodqa.userdetails.repos;

import com.vodqa.userdetails.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
